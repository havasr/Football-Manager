package model;

public class Currency {
    private String type;
    private double exchangeRate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
