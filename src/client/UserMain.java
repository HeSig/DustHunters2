package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import server.AccountManager;
import server.Server;
import server.ServerWindow;

/**
 * 
 * @author Henrik Sigeman
 *
 */


/**
 * The current "main" class. The program is started through here.
 * To Test this program: replace the "host" string with this computers current IPv4-address.
 * 
 * To test this program remotely: Use two computers. Make sure they share a network.
 * One program should ONLY run the server part and the other ONLY the client part.
 * To only use the server side: comment out everything below the "Client" comment and above the "Server" comment within the main-method.
 * To only use the client side: comment out everything below the "Server" comment within the main-method.
 */
public class UserMain {
	public static void main(String[] args) throws UnknownHostException, IOException {
		int port = 4040;
		//Client
		String host = "10.2.9.147";
		AccountManager accountManager1 = new AccountManager();
		UserController test1 = new UserController(host, port);
		//Server
		Server server = new Server(port, accountManager1);
		ServerWindow window = new ServerWindow(server);
		server.start();
	}
}