package com.example.pw2;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.example.pw2.models.Album;
import com.example.pw2.models.AlbumRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MainController {

    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("/{username}")
    public List<Album> getAlbumsByUser(@PathVariable String username) throws IOException {
        URL source = new URL("http://ws.audioscrobbler.com/2.0/?method=user.gettopalbums&user=" + username
                + "&api_key=40824a562c9ab20ff7d4d15766b8b52a&format=json");

        JsonNode finalNode = new ObjectMapper().readTree(source).get("topalbums").get("album");

        for (JsonNode jsonNode : finalNode) {
            Album album = new Album();
            album.setName(jsonNode.get("name").textValue());
            album.setImage(jsonNode.get("image").get(3).get("#text").textValue());
            album.setPlaycount(Integer.valueOf(jsonNode.get("playcount").textValue()));
            album.setArtist(jsonNode.get("artist").get("name").textValue());
            albumRepository.save(album);
        }

        // ModelAndView modelAndView = new ModelAndView("index");
        // modelAndView.addObject("albums", albumRepository.findAll());
        // modelAndView.addObject(new Album());
        // return modelAndView;

        return (List<Album>) albumRepository.findAll();
    }
}