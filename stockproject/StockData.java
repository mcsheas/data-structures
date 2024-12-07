import java.util.Date;

/**
 * The StockData class represents a single record of stock data,
 * including the date, closing price, RSI (Relative Strength Index),
 * and Moving Average (MA).
 */
public class StockData {

    private Date date; // The date associated with this stock date
    private double close;// The closing price of the stock on the given date
    private double rsi = 0; // The Relative Strength Index (RSI) value for this stock data
    private double ma = 0; // The Moving Average (MA) value for this stock data

    /**
     * Constructs a StockData object with the specified date and close price.
     *
     * @param date  The date of the stock data.
     * @param close The closing price of the stock on that date.
     */
    public StockData(Date date, double close) {
        this.date = date;
        this.close = close;
    }

    /**
     * Retrieves the date of the stock data.
     *
     * @return The date of this stock data.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retrieves the closing price of the stock.
     *
     * @return The closing price of the stock.
     */
    public double getClose() {
        return close;
    }

    /**
     * Retrieves the Relative Strength Index (RSI) value for the stock.
     *
     * @return The RSI value.
     */
    public double getRsi() {
        return rsi;
    }

    /**
     * Sets the Relative Strength Index (RSI) value for the stock.
     *
     * @param rsi The RSI value to set.
     */
    public void setRsi(double rsi) {
        this.rsi = rsi;
    }

    /**
     * Retrieves the Moving Average (MA) value for the stock.
     *
     * @return The MA value.
     */
    public double getMa() {
        return ma;
    }

    /**
     * Sets the Moving Average (MA) value for the stock.
     *
     * @param ma The MA value to set.
     */
    public void setMa(double ma) {
        this.ma = ma;
    }
}
