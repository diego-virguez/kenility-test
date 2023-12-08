package com.challenge1.util;

import com.challenge1.exception.ThirdPartyServiceException;
import com.lob.api.ApiClient;
import com.lob.api.ApiException;
import com.lob.api.Configuration;
import com.lob.api.auth.HttpBasicAuth;
import com.lob.api.client.UsAutocompletionsApi;
import org.openapitools.client.model.UsAutocompletions;
import org.openapitools.client.model.UsAutocompletionsWritable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiConsumer {

    @Value("${lob.apikey}")
    private String lobApiKey;

    public UsAutocompletions callAutoCompletions(UsAutocompletionsWritable autoCompletionWritable){
        ApiClient lobClient = Configuration.getDefaultApiClient();

        HttpBasicAuth basicAuth = (HttpBasicAuth) lobClient.getAuthentication("basicAuth");
        basicAuth.setUsername(lobApiKey);

        UsAutocompletionsApi apiInstance = new UsAutocompletionsApi(lobClient);

        try {
            UsAutocompletions usAutocompletion = apiInstance.autocomplete(autoCompletionWritable);
            return usAutocompletion;
        } catch(ApiException e) {
            throw new ThirdPartyServiceException(e.getMessage(), e);
        }
    }
}
