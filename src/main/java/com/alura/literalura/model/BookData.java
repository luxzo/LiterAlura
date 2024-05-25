package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData (
    @JsonAlias("results/title") String title,
    @JsonAlias("results/download_count") Long downloadCount) {
}
