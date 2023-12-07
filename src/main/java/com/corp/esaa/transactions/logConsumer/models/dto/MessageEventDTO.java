package com.corp.esaa.transactions.logConsumer.models.dto;

import java.time.Instant;
import java.util.Objects;


public class MessageEventDTO {

    private String message;
    private Instant publishAt;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getPublishAt() {
        return publishAt;
    }

    public void setPublishAt(Instant publishAt) {
        this.publishAt = publishAt;
    }

}
