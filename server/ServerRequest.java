package server;

import java.io.Serializable;

import profiles.Account;

/**
 * 
 * @author Henrik
 * The ServerRequest class is the way through which the client and the server communicates.
 * 
 */
public class ServerRequest implements Serializable{
	private Account account;
	private String request;

	public ServerRequest(Account account, String request) {
		this.account = account;
		this.request = request;
	}
	
	public Account getAccount() {
		return account;
	}
	public String getRequest() {
		return request;
	}
}
