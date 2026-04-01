package com.cts.api_gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class LoggingFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String requestId = UUID.randomUUID().toString();
        System.out.println("Request with id: "+requestId+ "Request came:  "+exchange.getRequest().getURI());
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            System.out.println("After response");
        }));
    }
}
