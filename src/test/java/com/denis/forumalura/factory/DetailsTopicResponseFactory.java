package com.denis.forumalura.factory;

import com.denis.forumalura.model.rules.DetailsTopicResponse;

import java.time.LocalDateTime;
import java.time.Month;

public class DetailsTopicResponseFactory {
    public static DetailsTopicResponse createDatailsCompleteTopicResponse() {
        return new DetailsTopicResponse(
                1L,
                "Titulo do post",
                "Mensagem sobre o topico...",
                LocalDateTime.of(2024, Month.JULY, 2, 10, 30),
                (short) 1,
                "Autor do Topico",
                "Curso do topico"
        );
    }
}
