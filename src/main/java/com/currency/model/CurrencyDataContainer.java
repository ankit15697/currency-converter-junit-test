package com.currency.model;

import com.currency.exceptions.CurrencyNotFoundException;

import java.util.HashMap;

// This class will contain the list of currencies which are valid;
public class CurrencyDataContainer {
    private HashMap<String, CurrencyData> map;
    private static CurrencyDataContainer currencyDataContainer;

    // Constructor is private  because container should be only one
    // hence this is an singleton class
    private CurrencyDataContainer() {
        map = new HashMap<String, CurrencyData>();
    }

    public static CurrencyDataContainer getCurrencyDataContainer() {
        if (currencyDataContainer == null) {
            currencyDataContainer = new CurrencyDataContainer();
        }
        return currencyDataContainer;
    }

    public void setData(String currencyName, double value) {
        map.put(currencyName, new CurrencyData(currencyName, value));
    }

    public CurrencyData getCurrencyObject(String currency) {

        if (!map.containsKey(currency))
            throw new CurrencyNotFoundException("There is no currency Exits with this name : " + currency);
        return map.get(currency);
    }
}
