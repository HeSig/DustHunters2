package server;

import java.io.*;
import java.net.*;
import profiles.Account;
import client.UserController;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class Server extends Thread {
	private Socket s;
	private ServerSocket ss;
	private PrintWriter pw;
	private OutputStream os;
	private int port;
	private AccountManager accountManager;
	private ObjectInputStream ois;
	@SuppressWarnings("unused")
	private InputStream is;
	private String serverRequest;

	public Server(int port, AccountManager accountManager) throws IOException {
		this.accountManager = accountManager;
		this.port = port;
	}

	public void close() throws IOException {
		os.close();
		ss.close();
		s.close();
		ois.close();
		pw.close();
	}

	public int getPort() {
		return port;
	}

	public void run() {
		while (!Thread.interrupted()) {
			// port = 53;
			try {
				ServerRequest request = null;
				ss = new ServerSocket(port);
				System.out.println("Waiting for client...");
				s = ss.accept();
				// System.out.println("Client connected to: " + s.toString());
				os = s.getOutputStream();
				pw = new PrintWriter(s.getOutputStream(), true);
				ois = new ObjectInputStream(s.getInputStream());
				while (request == null) {
					request = (ServerRequest) ois.readObject();
				}
				// Registerfunction.
				if (request.getRequest().equals("Register")) {
					Account account = request.getAccount();
					String res = accountManager.registerUser(account);
					pw.println(res);
				}
				// Loginfunction.
				if (request.getRequest().equals("Login")) {
					Account account = request.getAccount();
					String res = AccountManager.loginUser(account);
					pw.println(res);
				}
				// System.out.println("Mottaget och levererat");
				close();
				// System.out.println("Closed");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		int port = 4040;
		String host = "10.2.20.138";
		AccountManager accountManager1 = new AccountManager();
		Server server = new Server(port, accountManager1);
		ServerWindow window = new ServerWindow(server);
		server.start();
		UserController test1 = new UserController(host, port);
	}

}
