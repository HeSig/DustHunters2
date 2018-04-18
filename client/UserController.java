package client;

import java.io.IOException;
import java.net.UnknownHostException;
import profiles.Account;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class UserController {
	private Client client;
	private String host;
	private int port;

	@SuppressWarnings("unused")
	public UserController(String host, int port) throws UnknownHostException, IOException {
		this.host = host;
		this.port = port;
		client = new Client(this);
		// this.window = new UserWindow(this);
		RegisterWindow window = new RegisterWindow(this);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	/**
	 * Regisers a new account through the client.
	 * @param account The account to be registered
	 * @return Returns a string that lets the user know if the account has been registered.
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public String registerUser(Account account) throws UnknownHostException, IOException {
		String res = client.sendRegisterToServer(account);
		return res;
	}
	/**
	 * Attempts a "login" through the client.
	 * @param account The account to be logged in to.
	 * @return Returns true or false, depending on wether the server accepts the login.
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public Boolean login(Account account) throws UnknownHostException, IOException {
		Boolean res = client.sendLoginToServer(account);
		return res;
	}

}
