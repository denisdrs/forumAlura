package com.denis.forumalura.model.rules;

import com.denis.forumalura.model.Topic;
import java.time.LocalDateTime;

public record DetailsTopicResponse(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        Short status,
        String author,
        String course
) {
    public DetailsTopicResponse(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getStatus(),
                topic.getAuthor(),
                topic.getCourse()
        );
    }
}
