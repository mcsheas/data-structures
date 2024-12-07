import java.text.SimpleDateFormat;

/**
 * StockBotTester is the main class to test the StockBot functionalities.
 * It loads stock data at different intervals (daily, weekly, monthly),
 * calculates RSI and moving averages, and evaluates trading algorithms.
 */
public class StockBotTester {
    public static void main(String[] args) throws Exception {
        // File paths for daily, weekly, and monthly datasets
        String filePathDaily = "C:/Users/saram/Downloads/Download Data - STOCK_US_XNAS_NFLX.csv";
        String filePathWeekly = "C:/Users/saram/Downloads/Download Data - STOCK_US_XNAS_NFLX (1).csv";
        String filePathMonthly = "C:/Users/saram/Downloads/Download Data - STOCK_US_XNAS_NFLX (2).csv";
        
        // Instantiate StockBot objects for different timeframes
        StockBot stockBot1 = new StockBot(filePathDaily);
        StockBot stockBot2 = new StockBot(filePathWeekly);
        StockBot stockBot3 = new StockBot(filePathMonthly);
        
        // Test daily stock data
        System.out.println("\nTesting Daily Stock...");
        testStockBot(stockBot1, "Daily");

        // Test weekly stock data
        System.out.println("\nTesting Weekly Stock...");
        testStockBot(stockBot2, "Weekly");

        // Test monthly stock data
        System.out.println("\nTesting Monthly Stock...");
        testStockBot(stockBot3, "Monthly");
    }

    /**
     * Tests a StockBot object by calculating RSI, moving averages, and evaluating trading algorithms.
     * 
     * @param stockBot  The StockBot instance to test.
     * @param timeframe The timeframe (e.g., Daily, Weekly, Monthly) being tested.
     */
    private static void testStockBot(StockBot stockBot, String timeframe) {
        // Calculate RSI and moving average with a 14-period window
        stockBot.calculateRSI(14);
        stockBot.calculateMovingAverage(14);

        // Print stock data results
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Date\t\tClose\t\tRSI\t\tMA");
        System.out.println("------------------------------------------------");
        
        for (int i = 14; i < stockBot.getStockDataList().size(); i++) {
            StockData data = stockBot.getStockDataList().get(i);
            System.out.printf("%s\t%.2f\t\t%.2f\t\t%.2f%n",
                    dateFormat.format(data.getDate()), 
                    data.getClose(), 
                    data.getRsi(), 
                    data.getMa());
        }

        // Evaluate the trading algorithms
        double initialBalance = 10000;
        int initialShares = 0;

        // RSI + MA trading evaluation
        double rsiMaValue = stockBot.tradeEvaluator(initialBalance, initialShares);
        System.out.printf("%s Final Portfolio Value (RSI+MA): $%.2f%n", 
                         timeframe, rsiMaValue);

        // Momentum trading evaluation
        double momentumValue = stockBot.momentumTradeEvaluator(initialBalance, initialShares, 3);
        System.out.printf("%s Final Portfolio Value (Momentum): $%.2f%n", 
                         timeframe, momentumValue);
        
        // Calculate and display returns
        double rsiMaReturn = ((rsiMaValue - initialBalance) / initialBalance) * 100;
        double momentumReturn = ((momentumValue - initialBalance) / initialBalance) * 100;
        
        System.out.printf("%s RSI+MA Return: %.2f%%%n", timeframe, rsiMaReturn);
        System.out.printf("%s Momentum Return: %.2f%%%n", timeframe, momentumReturn);
    }
}
