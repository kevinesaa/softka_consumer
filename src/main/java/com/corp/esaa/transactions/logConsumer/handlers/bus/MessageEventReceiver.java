package com.corp.esaa.transactions.logConsumer.handlers.bus;

import com.corp.esaa.transactions.logConsumer.drivenAdapters.repositories.IMessageEventRepository;
import com.corp.esaa.transactions.logConsumer.models.dto.MessageEventDTO;
import com.corp.esaa.transactions.logConsumer.models.mappers.MessageEventMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.rabbitmq.Receiver;

@Component
public class MessageEventReceiver  implements CommandLineRunner {

    @Autowired
    private Receiver receiver;

    @Autowired
    private Gson gson;

    @Autowired
    private IMessageEventRepository repository;

    public void readMessage() {

    }

    @Override
    public void run(String... args) throws Exception {
        this.receiver
                .consumeAutoAck("transactions-queue")
                .map(m -> new String(m.getBody()) )
                .map(jsonString -> {
                    System.out.println(jsonString);
                    return gson.fromJson(jsonString, MessageEventDTO.class);
                })
                .map(dto -> new MessageEventMapper().toDatabaseModel(dto))
                .map(model -> repository.save(model).subscribe())
                .subscribe( System.out::println);
    }
}
