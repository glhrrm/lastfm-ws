package com.example.pw2.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {

    private int position;

    @JsonProperty("name")
    private String name;

    @JsonProperty("@attr")
    private void unpackPosition(Map<String, Object> attr) {
        this.position = Integer.valueOf((String) attr.get("rank"));
    }
    
}