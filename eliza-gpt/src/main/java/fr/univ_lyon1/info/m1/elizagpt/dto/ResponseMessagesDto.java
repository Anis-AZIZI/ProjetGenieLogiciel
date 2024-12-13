package fr.univ_lyon1.info.m1.elizagpt.dto;

import fr.univ_lyon1.info.m1.elizagpt.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * class qui va servir de reponse a la requete.
 */
public class ResponseMessagesDto {

    private List<MessageDto> responseDto;

    /**
     * Constructeur d'une reponse dto a partir d'une liste de Messages.
     * elle appelle le constructeur de Dto qui a ete declare pour prendre
     * comme parametre un message.
     * @param messages liste de messages
     */
    public ResponseMessagesDto(final List<Message> messages) {
        responseDto = new ArrayList<>();

        for (Message message : messages) {
            responseDto.add(new MessageDto(message));
        }
    }

    /**
     * Constructeur d'une reponse dto a partir d'une liste de Messages.
     */
    public ResponseMessagesDto() {
        this.responseDto = new ArrayList<>();
    }

    /**
     * rend la List Messagedto a la vue.
     */
    public List<MessageDto> getResponseDto() {
        return this.responseDto;
    }
}

