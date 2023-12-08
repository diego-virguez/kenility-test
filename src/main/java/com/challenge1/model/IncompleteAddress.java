package com.challenge1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class IncompleteAddress {
    @NotEmpty
    private String addressPrefix;
    private String city;
    private String state;
    private String zipCode;
}
