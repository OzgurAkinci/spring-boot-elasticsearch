package com.app.springbootelasticsearch.controller;


import com.app.springbootelasticsearch.entity.Song;
import com.app.springbootelasticsearch.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    SongRepository repository;

    @PostConstruct
    public void init() {
        Song song1 = new Song("1", "Kara Tren", "Yavuz Bingöl");
        Song song2 = new Song("2", "Sarı Gelin", "Yavuz Bingöl");
        Song song3 = new Song("3", "Sarı Şekerim",  "Kayahan");
        Song song4 = new Song("4", "Kara Gözlüm",  "Serkan Kaya");
        Song song5 = new Song("5", "Yeniden",  "Hırsız Yavuz");
        List<Song> songs = Arrays.asList(song1, song2, song3, song4, song5);
        for (Song song : songs) {
            if(repository.findById(song.getId()).isEmpty()) {
                repository.save(song);
            }
        }
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Song>> getSong(@PathVariable String search) {
        return ResponseEntity.ok(repository.getByCustomQuery(search));
    }

    @GetMapping("/{songName}/{artist}")
    public ResponseEntity<List<Song>> getSongV2(@PathVariable String songName, @PathVariable String artist) {
        return ResponseEntity.ok(repository.findBySongNameLikeOrArtistLike(songName, artist));
    }
}
