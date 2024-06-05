package com.yourpackage;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.math.BigDecimal;

public class InvestmentService {
    public Investment parseInvestmentData(String jsonData) {
        JsonReader jsonReader = Json.createReader(new StringReader(jsonData));
        JsonObject jsonObject = jsonReader.readObject();

        String name = jsonObject.getString("name");
        int quantity = jsonObject.getInt("quantity");
        BigDecimal purchasePrice = jsonObject.getJsonNumber("purchasePrice").bigDecimalValue();

        return new Investment(name, quantity, purchasePrice);
    }
}
