package com.challenge1.service;

import com.challenge1.exception.ThirdPartyServiceException;
import com.challenge1.model.CompleteAddress;
import com.challenge1.model.IncompleteAddress;
import com.challenge1.util.ApiConsumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openapitools.client.model.Suggestions;
import org.openapitools.client.model.UsAutocompletions;
import org.openapitools.client.model.UsAutocompletionsWritable;

import java.util.ArrayList;
import java.util.List;

import static com.challenge1.util.ObjectHelper.createSuggestions;
import static org.mockito.Mockito.when;

public class AddressServiceTest {

    @Mock
    private ApiConsumer apiConsumer;

    @InjectMocks
    private AddressService addressService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAutoCompleteHappyPath() {

        // DATA SETUP

        String requestAddress = "123";
        String requestCity = "Seattle";
        String requestState = "WA";
        String requestZipCode = "98101";

        String responseAddress = "123 Main St";
        String responseCity = "Seattle";
        String responseState = "WA";
        String responseZipCode = "98101";

        IncompleteAddress incompleteAddress = new IncompleteAddress();
        incompleteAddress.setAddressPrefix(requestAddress);
        incompleteAddress.setCity(requestCity);
        incompleteAddress.setState(requestState);
        incompleteAddress.setZipCode(requestZipCode);

        UsAutocompletionsWritable autoCompletionWritable = new UsAutocompletionsWritable();
        autoCompletionWritable.setAddressPrefix(requestAddress);
        autoCompletionWritable.setCity(requestCity);
        autoCompletionWritable.setState(requestState);
        autoCompletionWritable.setZipCode(requestZipCode);

        List<Suggestions> suggestions = new ArrayList<>();
        suggestions.add(createSuggestions(responseAddress, responseCity, responseState, responseZipCode));

        UsAutocompletions usAutocompletions = new UsAutocompletions();
        usAutocompletions.setSuggestions(suggestions);

        when(apiConsumer.callAutoCompletions(autoCompletionWritable)).thenReturn(usAutocompletions);

        // TEST
        List<CompleteAddress> completeAddresses = addressService.autoComplete(incompleteAddress);

        // VALIDATION
        Assertions.assertEquals(1, completeAddresses.size());
        Assertions.assertEquals(responseAddress, completeAddresses.get(0).getPrimaryLine());
        Assertions.assertEquals(responseCity, completeAddresses.get(0).getCity());
        Assertions.assertEquals(responseState, completeAddresses.get(0).getState());
        Assertions.assertEquals(responseZipCode, completeAddresses.get(0).getZipCode());
    }

    @Test
    public void testAutoCompleteSadPath() {

        // DATA SETUP

        String requestAddress = "123";
        String requestCity = "Seattle";
        String requestState = "WA";
        String requestZipCode = "98101";

        IncompleteAddress incompleteAddress = new IncompleteAddress();
        incompleteAddress.setAddressPrefix(requestAddress);
        incompleteAddress.setCity(requestCity);
        incompleteAddress.setState(requestState);
        incompleteAddress.setZipCode(requestZipCode);

        UsAutocompletionsWritable autoCompletionWritable = new UsAutocompletionsWritable();
        autoCompletionWritable.setAddressPrefix(requestAddress);
        autoCompletionWritable.setCity(requestCity);
        autoCompletionWritable.setState(requestState);
        autoCompletionWritable.setZipCode(requestZipCode);

        when(apiConsumer.callAutoCompletions(autoCompletionWritable)).thenThrow(
                new ThirdPartyServiceException("exception message"));

        // TEST, VALIDATION
        Assertions.assertThrows(ThirdPartyServiceException.class, () -> {
            addressService.autoComplete(incompleteAddress);
        });
    }
}
