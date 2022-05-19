package com.gabriel.martins.assembly.kafka.consumer;

import com.gabriel.martins.assembly.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class KafkaConsumer {

    public static final String ASSEMBLY_RESULT_TOPIC = "assembly_result_topic";

    @Autowired
    private AssemblyService service;

    @KafkaListener(topics = ASSEMBLY_RESULT_TOPIC, containerFactory = "kafkaListenerContainerFactory")
    public void run(final String dto, final Acknowledgment acknowledgment) {
        Optional.ofNullable(dto).ifPresent(data -> {
            service.process(data, acknowledgment);
        });
    }
}
