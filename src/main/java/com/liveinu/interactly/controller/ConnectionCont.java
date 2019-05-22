package com.liveinu.interactly.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.liveinu.interactly.dto.ConnectionDto;

@Controller
public class ConnectionCont {
//te
	List<ConnectionDto> connectionsDto = new ArrayList<>();

	@MessageMapping("/connect")
	@SendTo("/interactly-response/connection-response")
	public ConnectionDto greeting(ConnectionDto connectionDto) throws Exception {
		connectionsDto.add(connectionDto);
		connectionDto.setRemotePeerId("not found");
//		Thread.sleep(10000); // simulated delay
		connectionsDto.remove(connectionDto);
		return connectionDto;
	}

//	@MessageMapping("/getPeer")
//	@SendTo("/voice/response")
//	public Peer getPeer(Peer peer) throws Exception {
////		Thread.sleep(1000); // simulated delay
//		System.out.println("in get peer: " + this.peers.size());
//		return new Peer(String.valueOf(this.peers.size()));
//	}

}
