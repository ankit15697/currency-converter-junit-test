package com.currency.controller;

import com.currency.converter.CurrencyConverter;
import com.currency.model.CurrencyData;
import com.currency.model.CurrencyDataContainer;

// This class is the the main class of the application and will collaborate to other classes
public class Controller {
    private CurrencyDataContainer currencyDatacontainer;

    private void init(){
        currencyDatacontainer.setData("USD", 1.0);
        currencyDatacontainer.setData("INR", 0.014);
        currencyDatacontainer.setData("CAD", 0.76);
        currencyDatacontainer.setData("CDF", 0.00051);
        currencyDatacontainer.setData("CHF", 1.11);
    }

    public Controller() {
        currencyDatacontainer = CurrencyDataContainer.getCurrencyDataContainer();
        init();
    }

    public CurrencyData convertCurrencies(String source, String target, double amount) {
        return CurrencyConverter.convert(source, target, amount);
    }
}
