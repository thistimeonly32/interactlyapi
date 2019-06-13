package com.liveinu.interactly.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.liveinu.interactly.dto.ConnectionDto;
import com.liveinu.interactly.util.Constant;

@Controller
public class ConnectionCont {
	List<ConnectionDto> connectionsDto = new ArrayList<>();

	@MessageMapping("/audioCallReq")
	@SendToUser(value = "/topic/audioCallRes", broadcast = false)
	public ConnectionDto greeting(ConnectionDto connectionDto) throws Exception {
		ConnectionDto remoteConnectionDto = null;
		ConnectionDto localConnectionDto = connectionDto;

		connectionsDto.add(localConnectionDto);
		System.out.println("current List: " + connectionsDto.size() + " " + localConnectionDto.getLocalPeerId());

		while (connectionsDto.size() == 1 && connectionsDto.contains(localConnectionDto)) {
//			Thread.sleep(3000);
			System.out
					.println("waiting for users: " + connectionsDto.size() + " " + localConnectionDto.getLocalPeerId());
		}

		if (connectionsDto.contains(localConnectionDto)) {
			connectionsDto.remove(localConnectionDto);
			remoteConnectionDto = connectionsDto.get(connectionsDto.size() - 1);
			connectionsDto.remove(remoteConnectionDto);
			connectionDto.setRemotePeerId(remoteConnectionDto.getLocalPeerId());
			connectionDto.setConnectionType(Constant.CONNECTION_TYPE_CALL);
		} else {
			connectionDto.setConnectionType(Constant.CONNECTION_TYPE_WAIT);
		}

//		if (connectionsDto.contains(localConnectionDto)) {
//			connectionsDto.remove(localConnectionDto);
//			if (connectionsDto.size() > 0) {
//				remoteConnectionDto = connectionsDto.get(connectionsDto.size() - 1);
//				connectionsDto.remove(remoteConnectionDto);
//				connectionDto.setRemotePeerId(remoteConnectionDto.getLocalPeerId());
//				connectionDto.setConnectionType(Constant.CONNECTION_TYPE_CALL);
//			} else {
//				connectionsDto.remove(localConnectionDto);
//				connectionDto.setConnectionType(Constant.CONNECTION_TYPE_NO_USER_AVAILABLE);
//			}
//
//		} else {
//			connectionDto.setConnectionType(Constant.CONNECTION_TYPE_WAIT);
//			connectionsDto.remove(localConnectionDto);
//		}
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
