import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

/**
 * StockBot is a utility class for analyzing stock data, calculating indicators like RSI (Relative Strength Index)
 * and Moving Average (MA), and running back-testing algorithms to evaluate trading strategies.
 */
public class StockBot {
    // List to hold stock data records.
    private List<StockData> stockDataList;

    /**
     * Constructor for StockBot. Loads stock data from the given file.
     *
     * @param filePath The path to the CSV file containing stock data.
     * @throws Exception If the file cannot be read or parsed.
     */
    public StockBot(String filePath) throws Exception {
        this.stockDataList = loadStockData(filePath);
    }

    /**
     * Updates the stock data list. Used for testing with aggregated data like weekly or monthly data.
     *
     * @param stockDataList The new list of stock data.
     */
    public void setStockDataList(List<StockData> stockDataList) {
        this.stockDataList = stockDataList;
    }

    /**
     * Loads stock data from a CSV file, parses each line, and stores it in a list.
     *
     * @param filePath The path to the CSV file.
     * @return A list of StockData objects.
     * @throws Exception If the file cannot be read or parsed.
     */
    private List<StockData> loadStockData(String filePath) throws Exception {
        List<StockData> dataList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
    
        // Define supported date formats.
        SimpleDateFormat[] dateFormats = {
            new SimpleDateFormat("MM/dd/yyyy"), // Example: 11/24/2024
            new SimpleDateFormat("MMM-yy"),     // Example: Nov-24
        };
    
        br.readLine(); // Skip the header row.
    
        // Read each line from the CSV file.
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length > 4) { // Ensure the line has enough columns.
                Date date = null;
    
                // Try each date format until one works.
                for (SimpleDateFormat dateFormat : dateFormats) {
                    try {
                        date = dateFormat.parse(parts[0]);
                        break; // Stop trying formats once one succeeds.
                    } catch (ParseException ignored) {
                        // This format didn't work, try the next one.
                    }
                }
    
                // If no valid date was parsed, log and skip the line.
                if (date == null) {
                    System.err.println("Unrecognized date format for line: " + line + ". Skipping.");
                    continue;
                }
    
                try {
                    // Parse and clean the closing price.
                    String cleanedClose = cleanNumericString(parts[4]);
                    double close = Double.parseDouble(cleanedClose);
    
                    // Add the parsed data to the list.
                    dataList.add(new StockData(date, close));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid numeric value in line: " + line + ". Skipping.");
                }
            } else {
                System.err.println("Invalid line structure: " + line + ". Skipping.");
            }
        }
    
        br.close();
        return dataList;
    }


    /**
     * Cleans a numeric string by removing commas and quotes.
     *
     * @param value The raw numeric string from the CSV.
     * @return A cleaned numeric string.
     */
    private String cleanNumericString(String value) {
        return value.replaceAll("[\",]", "").trim();
    }

    /**
     * Calculates the Relative Strength Index (RSI) for the stock data.
     *
     * @param period The period to use for calculating RSI.
     * @see <a href="https://www.macroption.com/rsi-calculation/">RSI Calculation Reference</a>
     */
    public void calculateRSI(int period) {
        if (stockDataList.size() < period + 1) {
            return; // Not enough data to calculate RSI.
        }

        double[] changes = new double[stockDataList.size()];
        double[] gains = new double[stockDataList.size()];
        double[] losses = new double[stockDataList.size()];

        // Calculate daily changes and separate gains from losses.
        for (int i = 1; i < stockDataList.size(); i++) {
            changes[i] = stockDataList.get(i).getClose() - stockDataList.get(i - 1).getClose();
            gains[i] = Math.max(0, changes[i]);
            losses[i] = Math.max(0, -changes[i]);
        }

        // Compute the initial average gain and loss over the given period.
        double avgGain = 0;
        double avgLoss = 0;
        for (int i = 1; i <= period; i++) {
            avgGain += gains[i];
            avgLoss += losses[i];
        }
        avgGain /= period;
        avgLoss /= period;

        // Calculate the first RSI value based on initial averages.
        stockDataList.get(period).setRsi(100 - (100 / (1 + (avgGain / avgLoss))));

        // Compute subsequent RSI values using smoothing.
        for (int i = period + 1; i < stockDataList.size(); i++) {
            avgGain = ((avgGain * (period - 1)) + gains[i]) / period;
            avgLoss = ((avgLoss * (period - 1)) + losses[i]) / period;

            if (avgLoss == 0) {
                stockDataList.get(i).setRsi(100); // No losses; RSI is 100.
            } else {
                stockDataList.get(i).setRsi(100 - (100 / (1 + (avgGain / avgLoss))));
            }
        }
    }

    /**
     * Calculates the Moving Average (MA) for the stock data.
     *
     * @param period The period to use for calculating the moving average.
     */
    public void calculateMovingAverage(int period) {
        for (int i = period - 1; i < stockDataList.size(); i++) {
            double sum = 0;
            // Sum up closing prices over the specified period.
            for (int j = i - period + 1; j <= i; j++) {
                sum += stockDataList.get(j).getClose();
            }
            stockDataList.get(i).setMa(sum / period); // Calculate and set the average.
        }
    }

    /**
     * Evaluates a trading strategy based on RSI thresholds.
     *
     * @param balance The starting cash balance.
     * @param shares  The starting number of shares.
     * @return The final portfolio value.
     */
    public double tradeEvaluator(double balance, int shares) {
        for (StockData data : stockDataList) {
            if (data.getRsi() < 30) { // Buy signal when RSI < 30.
                int numSharesToBuy = (int) (balance / data.getClose());
                balance -= numSharesToBuy * data.getClose();
                shares += numSharesToBuy;
            } else if (data.getRsi() > 70 && shares > 0) { // Sell signal when RSI > 70.
                balance += shares * data.getClose();
                shares = 0;
            }
        }

        // Add the value of any remaining shares to the balance.
        if (!stockDataList.isEmpty()) {
            balance += shares * stockDataList.get(stockDataList.size() - 1).getClose();
        }
        return balance;
    }

    /**
     * Aggregates stock data into larger timeframes (weekly, monthly, yearly).
     *
     * @param timeframe The desired timeframe ("weekly", "monthly", or "yearly").
     * @return Aggregated stock data for the specified timeframe.
     */
    public List<StockData> aggregateData(String timeframe) {
        List<StockData> aggregatedData = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        double closeSum = 0;
        int count = 0;
        Date groupStartDate = null;

        for (StockData data : stockDataList) {
            calendar.setTime(data.getDate());
            boolean newGroup = false;

            switch (timeframe.toLowerCase()) {
                case "weekly":
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) newGroup = true;
                    break;
                case "monthly":
                    if (calendar.get(Calendar.DAY_OF_MONTH) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
                        newGroup = true;
                    break;
                case "yearly":
                    if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER &&
                        calendar.get(Calendar.DAY_OF_MONTH) == 31) newGroup = true;
                    break;
            }

            if (groupStartDate == null) groupStartDate = data.getDate();
            closeSum += data.getClose();
            count++;

            if (newGroup) {
                double avgClose = closeSum / count;
                aggregatedData.add(new StockData(groupStartDate, avgClose));
                groupStartDate = null;
                closeSum = 0;
                count = 0;
            }
        }
        return aggregatedData;
    }
    
    /**
     * Evaluates a momentum-based trading strategy.
     *
     * @param balance        The starting balance.
     * @param shares         The starting number of shares.
     * @param momentumPeriod The period to use for calculating momentum.
     * @return The final portfolio value after applying the strategy.
     */
    public double momentumTradeEvaluator(double balance, int shares, int momentumPeriod) {
        if (stockDataList.size() < momentumPeriod + 1) {
            return balance; // Not enough data to calculate momentum
        }
    
        double[] momentum = new double[stockDataList.size()];
    
        // Calculate momentum for each data point
        for (int i = momentumPeriod; i < stockDataList.size(); i++) {
            double currentPrice = stockDataList.get(i).getClose();
            double pastPrice = stockDataList.get(i - momentumPeriod).getClose();
            momentum[i] = ((currentPrice - pastPrice) / pastPrice) * 100;
        }
    
        // Momentum-based trading logic
        for (int i = momentumPeriod; i < stockDataList.size(); i++) {
            double currentPrice = stockDataList.get(i).getClose();
    
            if (momentum[i] > 2 && balance >= currentPrice) { // Buy signal
                int sharesToBuy = (int) (balance / currentPrice);
                if (sharesToBuy > 0) {
                    shares += sharesToBuy;
                    balance -= sharesToBuy * currentPrice;
                }
            } else if (momentum[i] < -2 && shares > 0) { // Sell signal
                balance += shares * currentPrice;
                shares = 0;
            }
        }
    
        // Add remaining shares' value to balance
        if (!stockDataList.isEmpty() && shares > 0) {
            balance += shares * stockDataList.get(stockDataList.size() - 1).getClose();
        }
    
        return balance;
    }


    /**
     * Retrieves the list of stock data.
     *
     * @return The list of StockData objects.
     */
    public List<StockData> getStockDataList() {
        return stockDataList;
    }
}
