package vn.tiki.remote_server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class RemoteServerVerticle extends AbstractVerticle {

    private Router router;

    private Controller controller;

    @Override
    public void start() {
        this.controller = new Controller(vertx);
        this.router = Router.router(vertx);
//        router.route().handler(BodyHandler.create());
        router.get("/remote_server_test").handler(controller::handleRequest);

        // start http server
        startHttpServer(vertx);
    }

    public void startHttpServer(Vertx vertx) {
        vertx.createHttpServer().requestHandler(router).listen(6789);
    }

}
