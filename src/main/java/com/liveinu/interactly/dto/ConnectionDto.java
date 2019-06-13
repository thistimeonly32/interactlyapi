package com.liveinu.interactly.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ConnectionDto {

	private String localPeerId;
	private String remotePeerId;
	private String connectionMsg;
	private String connectionType;

	public ConnectionDto() {
		super();
	}

	public ConnectionDto(String localPeerId, String remotePeerId, String connectionMsg) {
		super();
		this.localPeerId = localPeerId;
		this.remotePeerId = remotePeerId;
		this.connectionMsg = connectionMsg;
	}

	public String getLocalPeerId() {
		return localPeerId;
	}

	public void setLocalPeerId(String localPeerId) {
		this.localPeerId = localPeerId;
	}

	public String getRemotePeerId() {
		return remotePeerId;
	}

	public void setRemotePeerId(String remotePeerId) {
		this.remotePeerId = remotePeerId;
	}

	public String getConnectionMsg() {
		return connectionMsg;
	}

	public void setConnectionMsg(String connectionMsg) {
		this.connectionMsg = connectionMsg;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

}
