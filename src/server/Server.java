package server;

import java.io.*;
import java.net.*;
import profiles.Account;
import tasks.Task;
import client.UserController;
import locations.Location;

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
	private ObjectOutputStream oos;

	public Server(int port, AccountManager accountManager) throws IOException {
		this.accountManager = accountManager;
		this.port = port;
	}

	/**
	 * Close all things.
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		oos.close();
		os.close();
		ss.close();
		s.close();
		ois.close();
		pw.close();
	}

	/**
	 * 
	 * @return current port
	 */
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
				System.out.println("Client connected");
				//System.out.println("Client connected to: " + s.toString());
				os = s.getOutputStream();
				pw = new PrintWriter(s.getOutputStream(), true);
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
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
					Account res;
					res = AccountManager.loginUser(account);
					oos.writeObject(res);
					oos.flush();
				}
				// Add task
				if (request.getRequest().equals("AddTask")) {
					Account account = request.getAccount();
					Task task = (Task) ois.readObject();
					accountManager.addTask(account, task);
					//make this runnable
//					Task task = new Task(new Location(), new Chore(), value)
					//accountManager.addTask(account, task);

				}
				if(request.getRequest().equals("GetTasks")) {
					Account account = request.getAccount();
					oos.writeObject(accountManager.getTask(account));
					oos.flush();
				}
				// System.out.println("Mottaget och levererat");
				close();
				// System.out.println("Closed");
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Something is wrong");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		}
	}
}
