package com.pgs.dwsamples.one.app;

import com.pgs.dwsamples.one.config.MyConfiguration;
import com.pgs.dwsamples.one.health.SampleHealthCheck;
import com.pgs.dwsamples.one.resources.SampleResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by prave_000 on 19/11/2015.
 */
public class SampleApplication extends Application<MyConfiguration> {


    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(MyConfiguration configuration, Environment environment) throws Exception {

        final SampleResource sampleResource = new SampleResource(configuration.getTemplate(), configuration.getDefaultName());
        final SampleHealthCheck sampleHealthCheck = new SampleHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", sampleHealthCheck);
        environment.jersey().register(sampleResource);
    }

    public static void main(String[] args) throws Exception {
        new SampleApplication().run(args);
    }
}
