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
 */
public class UserMain {
	public static void main(String[] args) throws UnknownHostException, IOException {
		int port = 4040;
		String host = "10.2.5.9";
		AccountManager accountManager1 = new AccountManager();
		Server server = new Server(port, accountManager1);
		ServerWindow window = new ServerWindow(server);
		server.start();
		UserController test1 = new UserController(host, port);
	}
}