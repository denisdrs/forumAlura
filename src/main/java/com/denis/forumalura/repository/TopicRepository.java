package com.denis.forumalura.repository;


import com.denis.forumalura.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TopicRepository extends JpaRepository <Topic, Long> {
    Page<Topic> findAllByStatus(short active, Pageable pageable);
}
