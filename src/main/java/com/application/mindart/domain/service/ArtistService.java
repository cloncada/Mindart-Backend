package com.application.mindart.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.application.mindart.domain.entity.Artist;
import com.application.mindart.domain.repository.ArtistRepository;

@Service
public class ArtistService  {
    
    @Autowired
    private ArtistRepository repository;

    public Artist saveArtist(Artist artist) {
       return repository.save(artist);
    }

    public List<Artist> getArtists(){
        return repository.findAll();
    }

    public Artist getArtistById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public String deleteArtist(Integer id){
        repository.deleteById(id);
        return "removed artist with id "+id;
    }

    public Artist updateArtist(Artist artist){
     return null;
    }

    public Artist searchEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email,password);
    }
    public Artist findByEmail(String email){

        return repository.findByEmail(email);
    }
}
