package com.application.Mindart.controller;

import com.application.Mindart.entity.Artist;
import com.application.Mindart.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ArtistController {

    @Autowired
    private ArtistService service;
    @PostMapping("/addArtist")
    public Artist addArtist(@RequestBody Artist artist){

        return service.saveArtist(artist);
    }
    @GetMapping("/Artist")
    public List<Artist> findAllArtists(){


        return service.getArtists();
    }
    @GetMapping("/Artist/{id}")
    public Artist findArtistById(@PathVariable String id){


        return service.getArtistById(id);
    }
    @PutMapping("/update/Artist")
    public Artist updateArtist(@RequestBody Artist artist){
        return service.updateArtist(artist);

    }
    @DeleteMapping("/delete/Artist/{id}")
    public String deleteArtist(@PathVariable  String id){

       return service.deleteArtist(id);
    }

}
