package com.challenge1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompleteAddress {
    private String primaryLine;
    private String city;
    private String state;
    private String zipCode;
}

