package com.example.pw2.controllers;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.example.pw2.models.Album;
import com.example.pw2.models.Track;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@CrossOrigin
public class MainController {

    @GetMapping("/{username}/top-albums/{period}")
    public ResponseEntity<List<Album>> getTopAlbums(@PathVariable("username") String username, @PathVariable("period") String period) throws IOException {
        URL topAlbums = new URL("http://ws.audioscrobbler.com/2.0/?method=user.gettopalbums&user=" + username
                + "&period=" + period + "&limit=10&api_key=40824a562c9ab20ff7d4d15766b8b52a&format=json");

        JsonNode topAlbumNode = new ObjectMapper().readTree(topAlbums).get("topalbums").get("album");

        List<Album> albums = new ArrayList<>();

        for (JsonNode topAlbum : topAlbumNode) {
            Album album = new ObjectMapper().treeToValue(topAlbum, Album.class);

            String artistName = URLEncoder.encode(album.getArtist(), StandardCharsets.UTF_8.name());
            String albumName = URLEncoder.encode(album.getName(), StandardCharsets.UTF_8.name());

            URL albumTracks = new URL(
                    "http://ws.audioscrobbler.com/2.0/?method=album.getinfo&api_key=40824a562c9ab20ff7d4d15766b8b52a&artist="
                            + artistName + "&album=" + albumName + "&format=json");

            JsonNode trackNode = new ObjectMapper().readTree(albumTracks).get("album").get("tracks").get("track");

            List<Track> tracks = new ArrayList<>();

            for (JsonNode track : trackNode) {
                Track t = new ObjectMapper().treeToValue(track, Track.class);
                tracks.add(t);
            }

            album.setTracks(tracks);
            albums.add(album);
        }

        return ResponseEntity.ok(albums);
    }

}