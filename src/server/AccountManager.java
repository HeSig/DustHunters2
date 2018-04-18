package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import profiles.Account;

/**
 * 
 * @author Henrik Sigeman
 * The AccountManager handles all interaction between the server and the database
 * which stores all of the accounts and their contents.
 */
public class AccountManager {

	private static File filename = new File("files/accounts.txt");

	public static String loginUser(Account account) throws IOException {
		String email = account.getEmail();
		String password = account.getPassword();
		FileReader fileReader = new FileReader(filename);

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			if (line.equals(email)) {
				if (bufferedReader.readLine().equals(password)) {
					bufferedReader.close();
					fileReader.close();
					return "OK";
				}
			}
		}
		bufferedReader.close();
		fileReader.close();
		return "NO";
	}
	/**
	 * Register an account to the database.
	 * @param account The account to be added.
	 * @return a String message.
	 * @throws IOException
	 */
	public String registerUser(Account account) throws IOException {
		String email = account.getEmail();
		String password = account.getPassword();
		FileReader fileReader = new FileReader(filename);

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			// System.out.println(line);
			if (line.equals(email)) {
				bufferedReader.close();
				fileReader.close();
				return "E-mail already in use";
			}
		}
		FileWriter fileWriter = new FileWriter(filename, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		PrintWriter pr = new PrintWriter(fileWriter);
		if (filename.length() != 0) {
			pr.append("\n");
		}
		pr.append(email);
		pr.append("\n" + password);
		pr.close();
		bufferedReader.close();
		fileReader.close();
		bufferedWriter.close();
		fileWriter.close();
		return "New account registered";
	}

}
