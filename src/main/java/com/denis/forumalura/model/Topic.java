package com.denis.forumalura.model;

import com.denis.forumalura.model.rules.UpdateTopicRequest;
import com.denis.forumalura.model.rules.CreateTopicRequest;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private Short status;
    private String author;
    private String course;

    public Topic(CreateTopicRequest request) {
        this.title = request.title();
        this.message = request.message();
        this.creationDate = LocalDateTime.now();
        this.status = 1;
        this.author = request.author();
        this.course = request.course();
    }

    public Topic(UpdateTopicRequest request) {
        this.id = request.id();
        this.title = request.title();
        this.message = request.message();
        this.author = request.author();
        this.course = request.course();
    }

    public Topic updateTopic(Topic topic) {
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.author = topic.getAuthor();
        this.course = topic.getCourse();

        return topic;
    }

    public void delete() {
        this.status = (short) 0;
    }
}