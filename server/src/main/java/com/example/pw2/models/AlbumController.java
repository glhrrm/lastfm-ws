package com.example.pw2.models;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlbumController {

    @GetMapping
    public ModelAndView list() throws Exception {
        ModelAndView mv = new ModelAndView("index");

        List<Album> albums = new ArrayList<>();

        URL source = new URL(
                "http://ws.audioscrobbler.com/2.0/?method=user.gettopalbums&user=since93&api_key=40824a562c9ab20ff7d4d15766b8b52a&format=json");
        JsonNode finalNode = new ObjectMapper().readTree(source).get("topalbums").get("album");

        for (JsonNode objNode : finalNode) {
            Album album = new ObjectMapper().treeToValue(objNode, Album.class);
            albums.add(album);
            mv.addObject("albums", albums);
        }

        return mv;
    }

    @GetMapping("/test")
    public ResponseEntity<List<Album>> returnJson() throws IOException {
        URL topAlbums = new URL(
                "http://ws.audioscrobbler.com/2.0/?method=user.gettopalbums&user=since93&api_key=40824a562c9ab20ff7d4d15766b8b52a&format=json");

        JsonNode topAlbumNode = new ObjectMapper().readTree(topAlbums).get("topalbums").get("album");

        List<Album> albums = new ArrayList<>();

        for (JsonNode topAlbum : topAlbumNode) {
            Album album = new ObjectMapper().treeToValue(topAlbum, Album.class);
            albums.add(album);
        }

        return ResponseEntity.ok(albums);
    }

    // @GetMapping("/test2")
    // public ResponseEntity<List<Album>> returnJson2() throws IOException {
    //     URL topAlbums = new URL(
    //             "http://ws.audioscrobbler.com/2.0/?method=user.gettopalbums&user=since93&api_key=40824a562c9ab20ff7d4d15766b8b52a&format=json");

    //     JsonNode topAlbumNode = new ObjectMapper().readTree(topAlbums).get("topalbums").get("album");

    //     List<Album> albums = new ArrayList<>();

    //     for (JsonNode topAlbum : topAlbumNode) {
    //         URL albumTracks = new URL(
    //                 "http://ws.audioscrobbler.com/2.0/?method=album.getinfo&api_key=40824a562c9ab20ff7d4d15766b8b52a&artist=Arcade%20Fire&album=Funeral&format=json");

    //         JsonNode trackNode = new ObjectMapper().readTree(albumTracks).get("album").get("tracks").get("track");

    //         for (JsonNode track : trackNode) {
    //             Album album = new ObjectMapper().treeToValue(topAlbum, Album.class);
    //         }

    //         albums.add(album);
    //     }

    //     return ResponseEntity.ok(albums);
    // }

}