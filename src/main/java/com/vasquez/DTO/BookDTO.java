package com.vasquez.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(
                @JsonProperty("title") String title,
                @JsonProperty("authors") List<AuthorDTO> authors,
                @JsonProperty("languages") List<String> languages,
                @JsonProperty("download_count") Double downloadTotal) {

}
