package com.denis.forumalura.model.rules;

import jakarta.validation.constraints.NotBlank;

public record CreateTopicRequest(
    @NotBlank(message = "Titulo obrigatório.")
    String title,
    @NotBlank(message = "Mensagem obrigatória.")
    String message,
    @NotBlank(message = "Autor obrigatório.")
    String author,
    @NotBlank(message = "Curso obrigatório.")
    String course
) {
}
