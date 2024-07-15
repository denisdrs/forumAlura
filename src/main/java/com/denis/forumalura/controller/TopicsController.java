package com.denis.forumalura.controller;
import com.denis.forumalura.model.Topic;

import com.denis.forumalura.model.rules.UpdateTopicRequest;
import com.denis.forumalura.model.rules.CreateTopicRequest;
import com.denis.forumalura.model.rules.DetailsTopicResponse;
import com.denis.forumalura.service.TopicService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicsController {

    @Autowired
    private TopicService service;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreateTopicRequest request, UriComponentsBuilder uriComponentsBuilder) {
        var topic = service.createTopic(new Topic(request));

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topic.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailsTopicResponse(topic));
    }

    @GetMapping
    public ResponseEntity<Page<DetailsTopicResponse>> list(@PageableDefault(sort = {"creationDate"}) Pageable pagination){
        var page = service.listTopics(pagination).map(DetailsTopicResponse::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var topic = service.detailsTopic(id);

        return ResponseEntity.ok(new DetailsTopicResponse(topic));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateTopicRequest request) {
        var topic = service.updateTopic(new Topic(request));

        return ResponseEntity.ok(new DetailsTopicResponse(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        service.deleteTopic(id);

        return ResponseEntity.noContent().build();
    }
}
