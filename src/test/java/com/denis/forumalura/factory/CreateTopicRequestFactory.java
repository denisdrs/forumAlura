package com.denis.forumalura.factory;

import com.denis.forumalura.model.Topic;
import com.denis.forumalura.model.rules.CreateTopicRequest;

public class CreateTopicRequestFactory {

    public static CreateTopicRequest completedCreateTopicRequest(){
        return new CreateTopicRequest(
                "Título do Tópico.",
                "Mensagem sobre o tópico.",
                "Autor do Tópico",
                "Curso do Tópico"
        );
    }

    public static CreateTopicRequest failedCreateTopicRequest(){
        return new CreateTopicRequest(
                "",
                "Mensagem sobre o tópico",
                "Autor do Tópico",
                "Curso do Tópico"
        );
    }
}
