package com.pgs.dwsamples.one.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.pgs.dwsamples.one.api.SampleAPI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by prave_000 on 19/11/2015.
 */
@Path("/sample-app1")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public SampleResource (String template, String defaultName)
    {
        this.template = template;
        this.counter = new AtomicLong();
        this.defaultName = defaultName;
    }

    @GET
    @Timed
    public SampleAPI sayHello (@QueryParam("name")Optional<String> name)
    {
        final String value = String.format(template, name.or(defaultName));
        return new SampleAPI(counter.incrementAndGet(), value);
    }
}
