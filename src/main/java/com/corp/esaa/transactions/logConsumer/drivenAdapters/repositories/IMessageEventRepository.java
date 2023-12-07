package com.corp.esaa.transactions.logConsumer.drivenAdapters.repositories;

import com.corp.esaa.transactions.logConsumer.models.database.MessageEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IMessageEventRepository extends ReactiveMongoRepository<MessageEvent,String> {
}
