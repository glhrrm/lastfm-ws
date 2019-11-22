package com.example.pw2.models;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Album {

    @JsonProperty("mbid")
    private String id;

    @JsonProperty("name")
    private String name;

    private String artist;

    @JsonProperty("playcount")
    private String playcount;

    private String image;    

    @JsonProperty("artist")
    private void unpackArtist(Map<String, Object> artist) {
        this.artist = (String) artist.get("name");
    }

    @JsonProperty("image")
    private void unpackImage(List<Map<String, Object>> image) {
        this.image = (String) image.get(1).get("#text");
    }

    @Override
    public String toString() {
        return "id: " + id + "; name: " + name + "; artist: " + artist + "; playcount: " + playcount + "; image: "
                + image;
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

    public String getPlaycount() {
        return playcount;
    }

}