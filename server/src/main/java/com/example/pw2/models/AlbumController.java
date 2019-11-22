package com.example.pw2.models;

import java.net.URL;
import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
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

}