package it.ictgroup.accounts.service.kafka;

import it.ictgroup.accounts.model.Account;
import it.ictgroup.accounts.utils.MessageUtils;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class AccountService {

    Logger logger = Logger.getLogger(getClass());


    @Incoming("messages")
    @Outgoing("accounts")
    @Transactional
    public Account process(String message) {
        String number = MessageUtils.getNumber(message);
        if (number == null) {
            logger.info("no message inside");
            return null;
        }
        long count = Account.count("number", number);
        if (count == 0) {
            Account account = MessageUtils.toAccount(message);
            account.persist();
            return account;
        } else {
            logger.info("account already exist");
            return null;
        }
    }
}
