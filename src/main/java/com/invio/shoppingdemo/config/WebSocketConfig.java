package com.invio.shoppingdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/invio");
        registry.enableSimpleBroker("/topic");
    }

    //TODO - Murat Simsek .
    //Front end de sikayet yollayacak bir kod blogu yazilmasi gerekiyor .
    // Proje Backend projesi oldugu icin StackOverFlow da soyle bir cozum buldum ancak projeye ekleyemiyorum .


    // var socket = new SockJS('/ws');
    //var stompClient = Stomp.over(socket);
    //
    //stompClient.connect({}, function(frame) {
    //    console.log('Connected: ' + frame);
    //    setTimeout(function() {
    //        stompClient.send("/app/complaint", {}, "Merhabalar, şikayetinizi detaylı bir şekilde yazabilir misiniz.");
    //    }, 3000);
    //});
    //
    //stompClient.subscribe('/topic/complaints', function(response) {
    //    console.log("Response: " + response.body);
    //    stompClient.disconnect();
    //});
}
