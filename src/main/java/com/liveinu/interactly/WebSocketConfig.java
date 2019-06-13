package com.liveinu.interactly;

import java.security.Principal;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//	@Override
//	public void configureMessageBroker(MessageBrokerRegistry config) {
//		config.enableSimpleBroker("/interactly-response");
//		config.setApplicationDestinationPrefixes("/interactly-request");
//	}
//
//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry registry) {
//		registry.addEndpoint("/interactly/websocket").setAllowedOrigins("*").withSockJS();
//	}
//
//}

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/websocket").setHandshakeHandler(new HandshakeHandler()).setAllowedOrigins("*").withSockJS();
	}

//	@EventListener
//	public void onSocketConnected(SessionConnectedEvent event) {
//		System.out.println("peer-connect " + event.getUser().getName());
//		StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
//		System.out.println("[Connected] " + sha.getSessionId());
//	}
//
//	@EventListener
//	public void onSocketDisconnected(SessionDisconnectEvent event) {
//		System.out.println("peer-disconnect " + event.getUser().getName());
//		StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
//		System.out.println("[Disonnected] " + sha.getSessionId());
//	}

//	.setHandshakeHandler(new HandshakeHandler())

	private class HandshakeHandler extends DefaultHandshakeHandler {

		@Override
		protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
				Map<String, Object> attributes) {
			System.out.println(attributes.size());
			// TODO Auto-generated method stub
//			return super.determineUser(request, wsHandler, attributes);
			return new Principal() {

				@Override
				public String getName() {
					// TODO Auto-generated method stub
					return "shivam-id";
				}
			};
		}

	}

}