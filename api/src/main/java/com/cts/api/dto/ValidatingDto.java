package com.cts.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ValidatingDto {

    @Id
    @JsonProperty
    private boolean validStatus;
        
}
