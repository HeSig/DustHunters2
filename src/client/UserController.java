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

	/**
	 * Returns the client
	 * 
	 * @return the client.
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Sets the controllers client
	 * 
	 * @param client
	 *            the new client.
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * returns the ip-address of the server.
	 * 
	 * @return the ip-address as a String
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Sets the controllers ip-address.
	 * 
	 * @param host
	 *            the new ip-address.
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * returns the controllers port.
	 * 
	 * @return the port.
	 */
	public int getPort() {
		return port;
	}

	/**
	 * sets the controllers port.
	 * 
	 * @param port
	 *            the new port.
	 */

	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Regisers a new account through the client.
	 * 
	 * @param account
	 *            The account to be registered
	 * @return Returns a string that lets the user know if the account has been
	 *         registered.
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public String registerUser(Account account) throws UnknownHostException, IOException, InterruptedException {
		String res = client.sendRegisterToServer(account);
		return res;
	}

	/**
	 * Attempts a "login" through the client.
	 * 
	 * @param account
	 *            The account to be logged in to.
	 * @return Returns true or false, depending on wether the server accepts the
	 *         login.
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Account login(Account account) throws UnknownHostException, IOException, ClassNotFoundException {
		System.out.println("Controller is attempting the login");
		Account res = client.sendLoginToServer(account);
		return res;
	}

}
