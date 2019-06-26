package it.ictgroup.realtime;

import io.smallrye.reactive.messaging.annotations.Stream;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/accounts")
public class AccountRealtimeService {


    @Inject
    @Stream("accounts")
    Publisher<String> accounts; //


    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)             //
    public Publisher<String> stream() {                 //
        return accounts;
    }

}
