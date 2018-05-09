package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import profiles.Account;
import server.ServerRequest;
import tasks.Task;
import windows.DisplayWindow;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class Client extends Thread {
	@SuppressWarnings("unused")
	private UserController user;
	private OutputStream os;
	private InputStream is;
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private BufferedReader br;
	private String serverRequest;
	private Boolean isActive = false;
	private Observable observable = new Observable();

	/**
	 * Creates a client
	 * 
	 * @param user
	 *            the usercontroller
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public Client(UserController user) throws UnknownHostException, IOException {
		this.user = user;
	}

	public Boolean isActive() {
		return isActive;
	}

	private void setActive(String s) {
		System.out.println(s + " initiated.");
		isActive = true;
	}

	private void setInactive(String s) {
		System.out.println(s + " finished.");
		observable.notifyObservers();
		isActive = false;
	}

	public void addObserver(Observer o) {
		observable.addObserver(o);
	}

	/**
	 * Closes all of the streams.
	 * 
	 * @throws IOException
	 */
	private void closeStreams() throws IOException {
		oos.close();
		br.close();
		os.close();
		is.close();
		socket.close();
	}

	/**
	 * 
	 * @param account
	 *            The account to be registered.
	 * @return
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public String sendRegisterToServer(Account account) throws UnknownHostException, IOException, InterruptedException {
		serverRequest = "Register";
		socket = new Socket(user.getHost(), user.getPort());

		// Get inputstream and outputstream from socket.
		is = socket.getInputStream();
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		os = socket.getOutputStream();
		oos = new ObjectOutputStream(os);
		// Send register request to server.
		oos.writeObject(new ServerRequest(account, serverRequest));
		oos.flush();
		// Wait for response from server.
		String res = null;
		while (res == null) {
			Thread.sleep(500);
			res = br.readLine();
		}
		closeStreams();
		return res;
	}

	public LinkedList<Task> getTasksFromServer(Account account)
			throws UnknownHostException, IOException, ClassNotFoundException {
		setActive("Getting tasks ");
		serverRequest = "GetTasks";

		socket = new Socket(user.getHost(), user.getPort());
		os = socket.getOutputStream();
		oos = new ObjectOutputStream(os);
		is = socket.getInputStream();
		ois = new ObjectInputStream(is);

		oos.writeObject(new ServerRequest(account, serverRequest));
		oos.flush();
		LinkedList<Task> tasks = new LinkedList();
		tasks = (LinkedList<Task>) ois.readObject();
		ois.close();
		is.close();
		oos.close();
		os.close();
		socket.close();
		setInactive("Getting tasks ");
		return tasks;
	}

	public void addRewardToServer(Account account) {

	}

	public void addTaskToServer(Account account, Task task) throws UnknownHostException, IOException {
		setActive("Add task ");
		serverRequest = "AddTask";
		
		socket = new Socket(user.getHost(), user.getPort());
		os = socket.getOutputStream();
		oos = new ObjectOutputStream(os);
		is = socket.getInputStream();
		ois = new ObjectInputStream(is);

		oos.writeObject(new ServerRequest(account, serverRequest));
		oos.writeObject(task);
		oos.flush();

		ois.close();
		is.close();
		oos.close();
		os.close();
		socket.close();
		
		setInactive("Add task ");
	}

	/**
	 * 
	 * @param account
	 *            The account to be logged in to.
	 * @return
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Account sendLoginToServer(Account account) throws UnknownHostException, IOException, ClassNotFoundException {
		setActive("Logging in");
		Boolean ret = false;
		serverRequest = "Login";
		socket = new Socket(user.getHost(), user.getPort());
		System.out.println("Socket created");

		// Get inputstream and outputstream from socket.
		is = socket.getInputStream();
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		os = socket.getOutputStream();
		oos = new ObjectOutputStream(os);
		ois = new ObjectInputStream(is);
		// Send login request to server.
		oos.writeObject(new ServerRequest(account, serverRequest));
		// Wait for response from server
		Account res = null;
		while (res == null) {
			res = (Account) ois.readObject();
		}
		// Object input stream (ois) is specific to this method and thus won't be closed
		// in the closeStreams method.
		ois.close();
		// Close streams.
		closeStreams();
		// printAccount(res);
		DisplayWindow displayWindow = new DisplayWindow(res, this);
		setInactive("Logging in");
		return res;
	}

	private void printAccount(Account account) {
		for (int i = 0; i < account.getParentProfileList().size(); i++) {
			// System.out.println(account.getParentProfileList().get(i).getName());
		}
		for (int i = 0; i < account.getChildProfileList().size(); i++) {
			// System.out.println(account.getChildProfileList().get(i).getName());
		}

	}
}
