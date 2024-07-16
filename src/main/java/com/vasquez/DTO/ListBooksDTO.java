package com.vasquez.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListBooksDTO(
        @JsonProperty("results") List<BookDTO> results) {
}
