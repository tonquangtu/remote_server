package vn.tiki.remote_server;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.deployVertx();
    }

    private void deployVertx() {
        var vertxOptions = new VertxOptions();
        var vertx = Vertx.vertx(vertxOptions);
        var deploymentOptions = new DeploymentOptions().setInstances(1);
        vertx.deployVerticle(RemoteServerVerticle::new, deploymentOptions, res -> {
            if (res.succeeded()) {
                System.out.println("Deployment success");
            } else {
                System.out.println("Deployment onFailure");
                res.cause().printStackTrace();
            }
        });
    }
}

