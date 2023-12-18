package com.challenge1.util;

import org.openapitools.client.model.Suggestions;

public class ObjectHelper {

    public static Suggestions createSuggestions(String address, String city, String state, String zipCode){
        Suggestions suggestions = new Suggestions();
        suggestions.setPrimaryLine(address);
        suggestions.setCity(city);
        suggestions.setState(state);
        suggestions.setZipCode(zipCode);

        return suggestions;
    }
}
