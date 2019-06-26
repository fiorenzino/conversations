package it.ictgroup.accounts.service.rs;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import it.ictgroup.accounts.model.Account;
import it.ictgroup.api.service.RsRepositoryService;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.Map;

import static it.ictgroup.accounts.management.AppConstants.ACCOUNTS_PATH;

@Path(ACCOUNTS_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Singleton
public class AccountRepositoryRs extends RsRepositoryService<Account> {


    public AccountRepositoryRs() {
    }


    @Override
    public PanacheQuery<Account> getSearch(UriInfo ui, String orderBy) {
        Map<String, Object> params = new HashMap<>();
        StringBuffer queryBuffer = new StringBuffer();

        return Account.find(queryBuffer.toString(), params);
    }

    @Override
    public Object getId(Account account) {
        return account.uuid;
    }


}
