package com.innoq.js.quarkus;

import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        Greeting greeting = new Greeting("Hello, World!");
        return Response.ok(greeting).build();
    }

    @RegisterForReflection
    public static class Greeting {

        private String text;

        public Greeting(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
