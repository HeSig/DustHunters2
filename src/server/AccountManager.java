package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import locations.BedroomLocation;
import locations.KitchenLocation;
import locations.Location;
import locations.ToiletLocation;
import profiles.Account;
import profiles.ChildProfile;
import profiles.ParentProfile;
import rewards.Reward;
import tasks.Chore;
import tasks.Task;

/**
 * 
 * @author Henrik Sigeman The AccountManager handles all interaction between the
 *         server and the database which stores all of the accounts and their
 *         contents.
 */
public class AccountManager {

	private static File filename = new File("files/accounts.txt");

	/**
	 * buildAccount Bygger en account i servern från filerna i databasen och skickar
	 * den till klienten.
	 * 
	 * @param email
	 *            kontots email
	 * @param password
	 *            Kontots lösenord
	 * @return Det färdiga kontot.
	 * @throws IOException
	 */
	public static Account buildAccount(String email, String password) throws IOException {
		Account account = new Account(email, password);
		FileReader fileReader;
		try {
			fileReader = new FileReader("Accounts/" + email + ".txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Accountfile not found");
			return null;
		}
		BufferedReader br = new BufferedReader(fileReader);
		List<ParentProfile> parentProfileList;
		List<ChildProfile> childProfileList;
		List<Task> taskList;
		List<Reward> rewardList;
		ParentProfile parent;
		String readLine = "";
		br.readLine();
		// Parent profiles
		readLine = br.readLine();
		if (readLine.equals("ParentProfiles:")) {
			readLine = br.readLine();
			while (!readLine.equals("$")) {
				parent = new ParentProfile(readLine);
				account.addParentProfile(parent);

				readLine = br.readLine();
			}
		} else {

		}
		// Child profiles
		if (br.readLine().equals("ChildProfiles:")) {
			String points = "";
			readLine = br.readLine();
			while (!readLine.equals("$") && !points.equals("$")) {
				points = br.readLine();
				account.addChildProfile(new ChildProfile(readLine, Integer.parseInt(points)));
				readLine = br.readLine();
			}
		}

		// Tasks
		LinkedList<Task> list = (LinkedList<Task>) getTask(account);
		account.setTaskList(list);


		// Rewards
		if (br.readLine().equals("Rewards")) {
			readLine = br.readLine();
			while (!readLine.equals("$")) {
				account.addReward(new Reward(br.readLine(), Integer.parseInt(br.readLine())));
				readLine = br.readLine();
			}
		}
		// childProfileList.add(null);

		return account;

	}

	/**
	 * Login user to the account.
	 * 
	 * @param account
	 *            the account.
	 * @return
	 * @throws IOException
	 */
	public static Account loginUser(Account account) throws IOException {
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
					Account newAccount = buildAccount(account.getEmail(), account.getPassword());
					return newAccount;
				}
			}
		}
		bufferedReader.close();
		fileReader.close();
		return null;
	}

	/**
	 * Register an account to the database.
	 * 
	 * @param account
	 *            The account to be added.
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
		// Create new account file
		PrintWriter writer = new PrintWriter("accounts/" + account.getEmail() + ".txt");
		// Write initial information.
		writer.println("Account of " + account.getEmail());
		writer.println("ParentProfiles:");
		writer.println("1");
		writer.println("Förälder1");
		writer.println("$");
		writer.println("ChildProfiles:");
		writer.println("1");
		writer.println("barn1");
		writer.println("0");
		writer.println("$");
		writer.println("Tasks");
		writer.println("0");
		writer.println("$");
		writer.println("Rewards");
		writer.println("$");

		writer.close();
		bufferedReader.close();
		fileReader.close();
		bufferedWriter.close();
		fileWriter.close();
		return "New account registered";
	}

	/**
	 * getTask
	 * returnerar hela listan på tasks från den uppdaterade listan.
	 * @param account kontot som tasks ska hämtas ifrån.
	 * @return listan på tasks.
	 */
	public static List<Task> getTask(Account account) {
		List<Task> list = new LinkedList();

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("accounts/" + account.getEmail() + ".txt", true);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter pr = new PrintWriter(bufferedWriter);
			FileReader fileReader = new FileReader("accounts/" + account.getEmail() + ".txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while (line != null) {
				line = bufferedReader.readLine();
				if (line.equals("Tasks")) {
					int taskCount = Integer.parseInt(bufferedReader.readLine());
					for (int i = 0; i < taskCount; i++) {
						Location location = new Location(bufferedReader.readLine());
						Chore chore = new Chore(bufferedReader.readLine());
						int value = Integer.parseInt(bufferedReader.readLine());
						Task task = new Task(location, chore, value);
						list.add(task);
					}
					break;
				}

			}
			bufferedReader.close();
			fileReader.close();
			pr.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Something is wrong here too");
			e.printStackTrace();
		}

		return list;
	}
	
	public List<ParentProfile> getParentProfiles(Account account){
		List<ParentProfile> list = new LinkedList<ParentProfile>();

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("accounts/" + account.getEmail() + ".txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter pr = new PrintWriter(bufferedWriter);
			FileReader fileReader = new FileReader("accounts/" + account.getEmail() + ".txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while (line != null) {
				line = bufferedReader.readLine();
				if (line.equals("ParentProfiles:")) {
					int parentProfileCount = Integer.parseInt(bufferedReader.readLine());
					for (int i = 0; i < parentProfileCount; i++) {
						ParentProfile parentProfile = new ParentProfile(bufferedReader.readLine());
						list.add(parentProfile);
					}
					break;
				}

			}
			bufferedReader.close();
			fileReader.close();
			pr.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Something is wrong here too");
			e.printStackTrace();
		}

		return list;
	}
	public List<ChildProfile> getChildProfiles(Account account){
		List<ChildProfile> list = new LinkedList<ChildProfile>();

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("accounts/" + account.getEmail() + ".txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter pr = new PrintWriter(bufferedWriter);
			FileReader fileReader = new FileReader("accounts/" + account.getEmail() + ".txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while (line != null) {
				line = bufferedReader.readLine();
				if (line.equals("ChildProfiles:")) {
					int childProfileCount = Integer.parseInt(bufferedReader.readLine());
					for (int i = 0; i < childProfileCount; i++) {
						String name = bufferedReader.readLine();
						int points = Integer.parseInt(bufferedReader.readLine());
						ChildProfile childProfile = new ChildProfile(name, points);
						list.add(childProfile);
					}
					break;
				}

			}
			bufferedReader.close();
			fileReader.close();
			pr.close();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Something is wrong here too");
			e.printStackTrace();
		}

		return list;
	}
	
	/**
	 * addTask
	 * lägger till en task i kontots tasklista på servern.
	 * @param account kontot som tasken ska läggas in i
	 * @param task Tasken som ska läggas in.
	 * @throws IOException
	 */

	public void addTask(Account account, Task task) throws IOException {
		File f = new File("accounts/" + account.getEmail() + ".txt");
		LinkedList<String> fileContent = new LinkedList();
		FileWriter fileWriter = new FileWriter(f, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		PrintWriter pr = new PrintWriter(bufferedWriter);
		FileReader fileReader = new FileReader(f);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			fileContent.add(line);
			if (line.equals("Tasks")) {
				bufferedReader.readLine();
				fileContent.add("" + (account.getTaskList().size() + 1));
				for (int i = 0; i < account.getTaskList().size(); i++) {
					fileContent.add(account.getTaskFromList(i).getLocationName());
					fileContent.add(account.getTaskFromList(i).getChoreName());
					fileContent.add("" + account.getTaskFromList(i).getTaskValue());
				}
				fileContent.add(task.getLocationName());
				fileContent.add(task.getChoreName());
				fileContent.add("" + task.getTaskValue());
				break;
			}
		}
		while (!line.equals("$")) {
			line = bufferedReader.readLine();
		}
		fileContent.add(line);

		while (line != null) {
			line = bufferedReader.readLine();
			if (line == null) {
				break;
			}
			fileContent.add(line);
		}

		bufferedReader.close();
		fileReader.close();
		pr.close();
		bufferedWriter.close();
		fileWriter.close();

		if (f.exists()) {
			f.delete();
		}
		FileWriter out = new FileWriter(f);

		// Print new document.
		for (int i = 0; i < fileContent.size(); i++) {
			out.write(fileContent.get(i) + "\n");
		}
		out.close();
	}
	public void addParentProfile(Account account, ParentProfile parentProfile) throws IOException {
		File f = new File("accounts/" + account.getEmail() + ".txt");
		LinkedList<String> fileContent = new LinkedList();
		FileWriter fileWriter = new FileWriter(f, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		PrintWriter pr = new PrintWriter(bufferedWriter);
		FileReader fileReader = new FileReader(f);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			fileContent.add(line);
			if (line.equals("ParentProfiles:")) {
				bufferedReader.readLine();
				fileContent.add("" + (account.getParentProfileList().size() + 1));
				for (int i = 0; i < account.getParentProfileList().size(); i++) {
					fileContent.add(account.getParentProfileFromList(i).getName());
				}
				fileContent.add(parentProfile.getName());
				break;
			}
		}
		while (!line.equals("$")) {
			line = bufferedReader.readLine();
		}
		fileContent.add(line);

		while (line != null) {
			line = bufferedReader.readLine();
			if (line == null) {
				break;
			}
			fileContent.add(line);
		}

		bufferedReader.close();
		fileReader.close();
		pr.close();
		bufferedWriter.close();
		fileWriter.close();

		if (f.exists()) {
			f.delete();
		}
		FileWriter out = new FileWriter(f);

		// Print new document.
		for (int i = 0; i < fileContent.size(); i++) {
			out.write(fileContent.get(i) + "\n");
		}
		out.close();
	}
	

	public void addChildProfile(Account account, ChildProfile childProfile) throws IOException {
		File f = new File("accounts/" + account.getEmail() + ".txt");
		LinkedList<String> fileContent = new LinkedList();
		FileWriter fileWriter = new FileWriter(f, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		PrintWriter pr = new PrintWriter(bufferedWriter);
		FileReader fileReader = new FileReader(f);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			fileContent.add(line);
			if (line.equals("ChildProfiles:")) {
				bufferedReader.readLine();
				fileContent.add("" + (account.getChildProfileList().size() + 1));
				for (int i = 0; i < account.getChildProfileList().size(); i++) {
					fileContent.add(account.getChildProfileFromList(i).getName());
					fileContent.add("" + account.getChildProfileFromList(i).getPoints());
				}
				fileContent.add(childProfile.getName());
				fileContent.add(""+childProfile.getPoints());
				break;
			}
		}
		while (!line.equals("$")) {
			line = bufferedReader.readLine();
		}
		fileContent.add(line);

		while (line != null) {
			line = bufferedReader.readLine();
			if (line == null) {
				break;
			}
			fileContent.add(line);
		}

		bufferedReader.close();
		fileReader.close();
		pr.close();
		bufferedWriter.close();
		fileWriter.close();

		if (f.exists()) {
			f.delete();
		}
		FileWriter out = new FileWriter(f);

		// Print new document.
		for (int i = 0; i < fileContent.size(); i++) {
			out.write(fileContent.get(i) + "\n");
		}
		out.close();
		
	}
}
