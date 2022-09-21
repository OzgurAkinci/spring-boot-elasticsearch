package com.app.springbootelasticsearch.repository;

import com.app.springbootelasticsearch.entity.Song;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends ElasticsearchRepository<Song, String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"song_name\": \"?0\"}}]}}")
    List<Song> getByCustomQuery(String search);

    List<Song> findBySongNameLikeOrArtistLike(String songName, String artist);
}
