package it.ictgroup.messages.utils;

import it.ictgroup.messages.model.WhatsappMessage;

public class BodyUtils {


    public WhatsappMessage message(String body) {
        WhatsappMessage whatsappMessage = new WhatsappMessage();
        String[] parts = body.split("&");
        for (String part : parts) {
            String[] value = part.split("=");

        }
        return whatsappMessage;
    }
}
