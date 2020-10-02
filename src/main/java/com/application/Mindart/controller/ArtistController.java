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

    @PostMapping("/login/artist")
    public Artist loginUser(@RequestBody Artist artist) throws Exception {
        String email = artist.getEmail();
        String password = artist.getPassword();
        Artist artistObject = null;

        if(email != null && password != null){
            artistObject = service.searchEmailAndPassword(email,password);
        }
        if (artistObject == null){
            throw new Exception("El usuario o la contraseña estan incorrectos");
        }
        return artistObject;
    }
}
