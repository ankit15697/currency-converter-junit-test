package com.currency.model;


/// All value of currency is in dollar form
public class CurrencyData {
    private String currencyName;
    private double currencyValue;

    public CurrencyData() {
    }

    public CurrencyData(String currencyName, double value) {
        this.currencyName = currencyName;
        this.currencyValue = value;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(double currencyValue) {
        this.currencyValue = currencyValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyData)) return false;
        CurrencyData that = (CurrencyData) o;

        return Math.abs(that.currencyValue - currencyValue) <= 0.001 &&
                getCurrencyName().equals(that.getCurrencyName());

    }

    @Override
    public String toString() {
        return currencyName + " : "+ currencyValue;
    }
}
