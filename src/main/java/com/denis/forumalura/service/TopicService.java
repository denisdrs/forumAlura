package com.denis.forumalura.service;

import com.denis.forumalura.model.Topic;
import com.denis.forumalura.repository.TopicRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    private Short ACTIVE = (short) 1;

    @Autowired
    private TopicRepository repository;

    public Topic createTopic(Topic topic) {
        return repository.save(topic);
    }

    public Page<Topic> listTopics(Pageable pageable) {
        return repository.findAllByStatus(ACTIVE, pageable);
    }

    public Topic detailsTopic(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Tópico com o ID fornecido não foi encontrado."));
    }

    public Topic updateTopic(Topic topicAtt) {
        var topic = repository.findById(topicAtt.getId())
                .orElseThrow(() -> new ObjectNotFoundException(topicAtt.getId(), "Tópico com o ID fornecido não foi encontrado."));
        topic.updateTopic(topicAtt);
        return topic;
    }

    public void deleteTopic(Long id) {
        var topic = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Tópico com o ID fornecido não foi encontrado."));
        topic.delete();
    }
}
