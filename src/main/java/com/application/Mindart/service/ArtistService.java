package com.application.Mindart.service;

import com.application.Mindart.entity.Artist;
import com.application.Mindart.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Artist getArtistById(String id){

        return repository.findById(id).orElse(null);

    }
    public String deleteArtist(String id){
        repository.deleteById(id);
        return "removed artist with id "+id;


    }
    public Artist updateArtist(Artist artist){

     return null;


    }
}
