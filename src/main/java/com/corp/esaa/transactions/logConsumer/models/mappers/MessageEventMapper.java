package com.corp.esaa.transactions.logConsumer.models.mappers;

import com.corp.esaa.transactions.logConsumer.models.database.MessageEvent;
import com.corp.esaa.transactions.logConsumer.models.dto.MessageEventDTO;

public class MessageEventMapper {

    public MessageEvent toDatabaseModel(MessageEventDTO dto) {
        final MessageEvent event = new MessageEvent();
        event.setMessage(dto.getMessage());
        event.setPublishAt(dto.getPublishAt());
        return event;
    }
}
