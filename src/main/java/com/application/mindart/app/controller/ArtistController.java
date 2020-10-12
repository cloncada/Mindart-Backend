package com.application.mindart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.mindart.domain.entity.Artist;
import com.application.mindart.domain.service.ArtistService;
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
    public Artist findArtistById(@PathVariable Integer id){
        return service.getArtistById(id);
    }

    @PutMapping("/update/Artist")
    public Artist updateArtist(@RequestBody Artist artist){
        return service.updateArtist(artist);
    }

    @DeleteMapping("/delete/Artist/{id}")
    public String deleteArtist(@PathVariable  Integer id){
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
    @GetMapping("artist/{email}")
    public Artist findByEmail (@PathVariable String email){
        return service.findByEmail(email);

    }


}
