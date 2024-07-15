package com.denis.forumalura.factory;

import com.denis.forumalura.model.Topic;

import java.time.LocalDateTime;
import java.time.Month;

public class TopicFactory {
    public static Topic createCompleteTopic() {
        return new Topic(
                1L,
                "Titulo do post",
                "Mensagem sobre o topico...",
                LocalDateTime.of(2024, Month.JULY, 2, 10, 30),
                (short) 1,
                "Autor do Topico",
                "Curso do topico"
        );
    }

    public static Topic createInvalidTopic() {
        return new Topic(
                1L,
                "",
                "Mensagem sobre o topico...",
                LocalDateTime.of(2024, Month.JULY, 2, 10, 30),
                (short) 1,
                "Autor do Topico",
                "Curso do topico"
        );
    }
}
