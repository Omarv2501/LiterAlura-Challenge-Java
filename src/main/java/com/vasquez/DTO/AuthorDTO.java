package com.vasquez.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorDTO(
                @JsonProperty("name") String name,
                @JsonProperty("birth_year") int birthYear,
                @JsonProperty("death_year") int deathYear) {
}