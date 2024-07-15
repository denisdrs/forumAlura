package com.denis.forumalura.model.rules;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateTopicRequest(
     @NotNull
     Long id,
     @NotBlank(message = "titulo obrigatório")
     String title,
     @NotBlank(message = "mensagem obrigatória")
     String message,
     @NotBlank(message = "autor obrigatório")
     String author,
     @NotBlank(message = "curso obrigatório")
     String course
) {
}
