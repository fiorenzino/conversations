package it.ictgroup.messages.service.kafka;

import it.ictgroup.messages.model.WhatsappMessage;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.inject.Singleton;

@Singleton
public class MessageService {


    @Outgoing("messages")
    public String toQueue(WhatsappMessage whatsappMessage) {


        return whatsappMessage.toString();
    }
}
