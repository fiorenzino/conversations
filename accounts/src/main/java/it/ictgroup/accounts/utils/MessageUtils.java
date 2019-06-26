package it.ictgroup.accounts.utils;

import it.ictgroup.accounts.model.Account;
import org.jboss.logging.Logger;

public class MessageUtils {

    static Logger logger = Logger.getLogger(MessageUtils.class);

    public static String getNumber(String message) {
        if (message == null || message.trim().isEmpty()) {
            return null;
        }
        return "number";
    }

    public static Account toAccount(String message) {
        Account account = new Account();
        String[] parts = message.split(" ");
        if (parts.length > 1) {
            logger.info("nickname not valid");
            account.nickname = "no_name";
        } else {
            account.nickname = parts[0];
        }
        account.number = getNumber(message);
        return account;
    }
}
