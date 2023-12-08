package com.challenge1.service;

import com.challenge1.util.ApiConsumer;
import com.challenge1.model.CompleteAddress;
import com.challenge1.model.IncompleteAddress;
import lombok.AllArgsConstructor;
import org.openapitools.client.model.Suggestions;
import org.openapitools.client.model.UsAutocompletions;
import org.openapitools.client.model.UsAutocompletionsWritable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressService {

    private ApiConsumer apiConsumer;

    public List<CompleteAddress> autoComplete(IncompleteAddress incompleteAddress){
        UsAutocompletionsWritable autoCompletionWritable = new UsAutocompletionsWritable();
        autoCompletionWritable.setAddressPrefix(incompleteAddress.getAddressPrefix());
        autoCompletionWritable.setCity(incompleteAddress.getCity());
        autoCompletionWritable.setState(incompleteAddress.getState());
        autoCompletionWritable.setZipCode(incompleteAddress.getZipCode());

        UsAutocompletions usAutocompletions = apiConsumer.callAutoCompletions(autoCompletionWritable);
        return usAutocompletions != null?transformList(usAutocompletions.getSuggestions()):new ArrayList<>();
    }

    private static List<CompleteAddress> transformList(List<Suggestions> suggestions){
        return suggestions.stream().map(suggestion -> new CompleteAddress(
                suggestion.getPrimaryLine(),
                suggestion.getCity(),
                suggestion.getState(),
                suggestion.getZipCode()
        )).collect(Collectors.toList());
    }
}
