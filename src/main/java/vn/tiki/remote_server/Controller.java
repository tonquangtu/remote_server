package vn.tiki.remote_server;

import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;


public class Controller {

    private Vertx vertx;
    public Controller(Vertx vertx) {
        this.vertx = vertx;
    }

    public void handleRequest(RoutingContext context) {
        vertx.setTimer(300, aLong -> {
            var response = "This text from remote server (tuton)";
            context.response()
                    .putHeader("content-type", "application/json")
                    .setStatusCode(200)
                    .end(response);
        });

    }
}
