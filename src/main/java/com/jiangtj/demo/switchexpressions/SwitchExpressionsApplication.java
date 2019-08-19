package com.jiangtj.demo.switchexpressions;

import com.jiangtj.demo.switchexpressions.factory.OldPays;
import com.jiangtj.demo.switchexpressions.factory.Pays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.annotation.Resource;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@SpringBootApplication
public class SwitchExpressionsApplication {

    @Resource
    private OldPays oldPays;
    @Resource
    private Pays pays;

    public static void main(String[] args) {
        SpringApplication.run(SwitchExpressionsApplication.class, args);
    }

    @Bean
    public RouterFunction indexRouter() {
        return RouterFunctions.route(GET("/"), request -> {
            return ServerResponse.ok().body(BodyInserters.fromObject(request.queryParams()));
        });
    }

    @Bean
    public RouterFunction oldRouter() {
        return RouterFunctions.route(GET("/old"), request -> {
            PayService service = oldPays.get(request.queryParam("pay").orElse(""));
            return ServerResponse.ok()
                    .body(BodyInserters.fromObject(service.pay()));
        });
    }

    @Bean
    public RouterFunction newRouter() {
        return RouterFunctions.route(GET("/new"), request -> {
            PayService service = pays.get(request.queryParam("pay").orElse(""));
            return ServerResponse.ok()
                    .body(BodyInserters.fromObject(service.pay()));
        });
    }

}
