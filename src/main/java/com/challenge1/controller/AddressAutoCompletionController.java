package com.challenge1.controller;

import com.challenge1.model.CompleteAddress;
import com.challenge1.model.IncompleteAddress;
import com.challenge1.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressAutoCompletionController {

    private AddressService addressService;

    @CrossOrigin
    @PostMapping("/autocomplete")
    public ResponseEntity<List<CompleteAddress>> handleAutoCompleteRequest(
            @Valid @RequestBody IncompleteAddress incompleteAddress) {
        List<CompleteAddress> response = addressService.autoComplete(incompleteAddress);
        return ResponseEntity.ok(response);
    }
}
