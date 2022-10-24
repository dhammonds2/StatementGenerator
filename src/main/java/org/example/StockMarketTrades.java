package org.example;
public class StockMarketTrades {
    private String pricePerShare;
    private String stockSymbol;
    private String type;
    private Long countShares;

    public String getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(String pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockStymbol) {
        this.stockSymbol = stockStymbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCountShares() {
        return countShares;
    }

    public void setCountShares(Long countShares) {
        this.countShares = countShares;

    }

    @Override
    public String toString() {
        return "[Price per share: " + pricePerShare + ", Stock Symbol: " + stockSymbol + ", Type: " + type
                + ", Count Shares: " + countShares + "]";
    }

}
