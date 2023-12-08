package com.corp.esaa.transactions.logConsumer.models.mappers;

import com.corp.esaa.transactions.logConsumer.models.database.MessageEvent;
import com.corp.esaa.transactions.logConsumer.models.dto.MessageEventDTO;

import java.time.LocalDateTime;

public class MessageEventMapper {

    public MessageEvent toDatabaseModel(final MessageEventDTO dto) {
        final MessageEvent event = new MessageEvent();
        event.setMessage(dto.getMessage());
        event.setType(dto.getType());
        event.setPublishAt(dto.getPublishAt());
        event.setCreatedAt(LocalDateTime.now());
        return event;
    }
}
