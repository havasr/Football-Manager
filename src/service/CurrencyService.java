package service;

import model.Currency;

import java.math.BigDecimal;

public class CurrencyService {

    public Currency createCurrency(String type, double exchangeRate){
        Currency currency = new Currency();
        currency.setType(type);
        currency.setExchangeRate(exchangeRate);

        return currency;
    }

    public BigDecimal exchange(BigDecimal amount, Currency currency1, Currency currency2) {
        if (currency1.getType()!=currency2.getType()) {
            amount.multiply(BigDecimal.valueOf(currency1.getExchangeRate() / currency2.getExchangeRate()));
        }
        return amount;
    }
}
