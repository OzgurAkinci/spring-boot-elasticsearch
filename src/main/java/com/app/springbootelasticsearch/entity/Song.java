package com.app.springbootelasticsearch.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    private String id;
    @Field(name = "song_name", type = FieldType.Text)
    private String songName;
    @Field(name = "artist", type = FieldType.Text)
    private String artist;
}
