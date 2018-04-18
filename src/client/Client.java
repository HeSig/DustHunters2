package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;

import profiles.Account;
import server.ServerRequest;

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
	private BufferedReader br;
	private String serverRequest;

	public Client(UserController user) throws UnknownHostException, IOException {
		this.user = user;
	}

	/**
	 * Closes all of the streams.
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
	 * @param account The account to be registered.
	 * @return
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public String sendRegisterToServer(Account account) throws UnknownHostException, IOException {
		serverRequest = "Register";
		socket = new Socket(user.getHost(), user.getPort());

		// Do stuff;

		is = socket.getInputStream();
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		os = socket.getOutputStream();
		oos = new ObjectOutputStream(os);
		oos.writeObject(new ServerRequest(account, serverRequest));
		String res = null;
		while (res == null) {
			res = br.readLine();
		}
		closeStreams();
		return res;
	}

	/**
	 * 
	 * @param account The account to be logged in to.
	 * @return
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public Boolean sendLoginToServer(Account account) throws UnknownHostException, IOException {
		Boolean ret = false;
		serverRequest = "Login";
		socket = new Socket(user.getHost(), user.getPort());

		// Do stuff;

		is = socket.getInputStream();
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		os = socket.getOutputStream();
		oos = new ObjectOutputStream(os);
		oos.writeObject(new ServerRequest(account, serverRequest));
		String res = null;
		while (res == null) {
			res = br.readLine();
		}
		if(res.equals("OK")) {
			ret = true;
		}
		if(res.equals("NO")) {
			ret = false;
		}
		closeStreams();
		return ret;
	}

}
