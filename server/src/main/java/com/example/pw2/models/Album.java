package com.example.pw2.models;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Album {

    private int position;

    @JsonProperty("name")
    private String name;

    private String artist;

    @JsonProperty("playcount")
    private int playcount;

    private String image;    

    @JsonProperty("@attr")
    private void unpackPosition(Map<String, Object> attr) {
        this.position = Integer.valueOf((String) attr.get("rank"));
    }

    @JsonProperty("artist")
    private void unpackArtist(Map<String, Object> artist) {
        this.artist = (String) artist.get("name");
    }

    @JsonProperty("image")
    private void unpackImage(List<Map<String, Object>> image) {
        this.image = (String) image.get(1).get("#text");
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getImage() {
        return image;
    }

    public int getPlaycount() {
        return playcount;
    }

    public int getPosition() {
        return position;
    }

}