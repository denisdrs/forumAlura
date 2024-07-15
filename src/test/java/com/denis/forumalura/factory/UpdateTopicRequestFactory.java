package com.denis.forumalura.factory;

import com.denis.forumalura.model.rules.UpdateTopicRequest;
import com.denis.forumalura.model.rules.CreateTopicRequest;

public class UpdateTopicRequestFactory {

    public static UpdateTopicRequest createUpdateTopicRequest() {
        return new UpdateTopicRequest(
                1L,
                "Titulo do Tópico",
                "Mensagem do Tópico",
                "Autor do tópico",
                "Curso do Tópico"
        );
    }

    public static CreateTopicRequest completedCreateTopicRequest() {
        return new CreateTopicRequest(
                "Título do Tópico",
                "Mensagem do Tópico",
                "Autor do Tópico",
                "Curso do Tópico"
        );
    }

}
