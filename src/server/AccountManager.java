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

import locations.Location;
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
 * 
 *         Kommentar: Har gjort allting statiskt. Om det inte funkar som det
 *         ska, ta bort all "static" och gör om.
 */
public class AccountManager {

	private File filename = new File("files/accounts.txt");
	private File f;
	private LinkedList<String> fileContent;
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private PrintWriter pr;
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	private void openStreams(Account account) throws IOException {
		fileContent = new LinkedList<String>();
		f = new File("accounts/" + account.getEmail() + ".txt");
		fileWriter = new FileWriter(f, true);
		bufferedWriter = new BufferedWriter(fileWriter);
		pr = new PrintWriter(bufferedWriter);
		fileReader = new FileReader(f);
		bufferedReader = new BufferedReader(fileReader);
	}

	private void closeStreams() throws IOException {
		bufferedReader.close();
		fileReader.close();
		pr.close();
		bufferedWriter.close();
		fileWriter.close();
	}

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
	public Account buildAccount(String email, String password) throws IOException {
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
			br.readLine();
			readLine = br.readLine();
			while (!readLine.equals("$")) {
				parent = new ParentProfile(readLine);
				parent.setImage(br.readLine());
				account.addParentProfile(parent);
				readLine = br.readLine();
			}
		} else {

		}
		// Child profiles
		if (br.readLine().equals("ChildProfiles:")) {
			String points = "";
			br.readLine();
			readLine = br.readLine();
			while (!readLine.equals("$") && !points.equals("$")) {
				String image = br.readLine();
				points = br.readLine();
				ChildProfile profile = new ChildProfile(readLine, Integer.parseInt(points));
				profile.setImage(image);
				account.addChildProfile(profile);
				readLine = br.readLine();
			}
		}

		// Tasks
		LinkedList<Task> list = (LinkedList<Task>) getTask(account);
		account.setTaskList(list);

		// Rewards
		while (!readLine.equals("Rewards:")) {
			readLine = br.readLine();
		}
		if (readLine.equals("Rewards:")) {
			br.readLine();
			while (!readLine.equals("$")) {
				String rewardName = br.readLine();
				int rewardValue = Integer.parseInt(br.readLine());
				int rewardProgress = Integer.parseInt(br.readLine());
				account.addReward(new Reward(rewardName, rewardValue, rewardProgress));
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
	public Account loginUser(Account account) throws IOException {
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
					Account newAccount = new Account(buildAccount(account.getEmail(), account.getPassword()));
					fileReader.close();
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
		writer.println("dammtuss");
		writer.println("$");
		writer.println("ChildProfiles:");
		writer.println("0");
		writer.println("$");
		writer.println("Tasks:");
		writer.println("0");
		writer.println("$");
		writer.println("Rewards:");
		writer.println("0");
		writer.println("$");

		closeStreams();
		return "New account registered";
	}

	/**
	 * getTask returnerar hela listan på tasks från den uppdaterade listan.
	 * 
	 * @param account
	 *            kontot som tasks ska hämtas ifrån.
	 * @return listan på tasks.
	 */
	public List<Task> getTask(Account account) throws IOException {
		List<Task> list = new LinkedList();

		openStreams(account);
		String line = "";
		while (line != null) {
			line = bufferedReader.readLine();
			if (line.equals("Tasks:")) {
				int taskCount = Integer.parseInt(bufferedReader.readLine());
				for (int i = 0; i < taskCount; i++) {
					Location location = new Location(bufferedReader.readLine());
					Chore chore = new Chore(bufferedReader.readLine());

					int value = Integer.parseInt(bufferedReader.readLine());
					String completed = bufferedReader.readLine();
					String assignee = bufferedReader.readLine();
					ChildProfile childProfile;
					if (assignee.equals("null")) {
						childProfile = null;
					} else {
						childProfile = account.getChildProfileFromList(assignee);
					}
					Boolean bool;
					if (completed.equals("true")) {
						bool = true;
					} else {
						bool = false;
					}
					Task task = new Task(location, chore, value, bool, childProfile);
					list.add(task);
				}
				break;
			}

		}
		closeStreams();
		return list;

	}

	public List<ParentProfile> getParentProfiles(Account account) throws IOException {
		List<ParentProfile> list = new LinkedList<ParentProfile>();
		openStreams(account);
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
		closeStreams();

		return list;
	}

	public List<ChildProfile> getChildProfiles(Account account) throws IOException {
		List<ChildProfile> list = new LinkedList<ChildProfile>();

		openStreams(account);
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
		closeStreams();

		return list;
	}

	/**
	 * addTask lägger till en task i kontots tasklista på servern.
	 * 
	 * @param account
	 *            kontot som tasken ska läggas in i
	 * @param task
	 *            Tasken som ska läggas in.
	 * @throws IOException
	 */

	public void addTask(Account account, Task task) throws IOException {
		openStreams(account);
		LinkedList<String> fileContent = new LinkedList();

		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			fileContent.add(line);
			if (line.equals("Tasks:")) {
				bufferedReader.readLine();
				fileContent.add("" + (account.getTaskList().size() + 1));
				for (int i = 0; i < account.getTaskList().size(); i++) {
					fileContent.add(account.getTaskFromList(i).getLocationName());
					fileContent.add(account.getTaskFromList(i).getChoreName());
					fileContent.add("" + account.getTaskFromList(i).getTaskValue());
					fileContent.add("" + account.getTaskFromList(i).getCompleted());
					try {
						fileContent.add("" + account.getTaskFromList(i).getChildProfile().getName());
					} catch (NullPointerException e) {
						fileContent.add("null");
					}
				}
				fileContent.add(task.getLocationName());
				fileContent.add(task.getChoreName());
				fileContent.add("" + task.getTaskValue());
				fileContent.add("" + task.getCompleted());
				fileContent.add("null");
				break;
			}
		}
		while (!line.equals("$")) {
			System.out.println(line);
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

		closeStreams();

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
		openStreams(account);

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			fileContent.add(line);
			if (line.equals("ParentProfiles:")) {
				bufferedReader.readLine();
				fileContent.add("" + (account.getParentProfileList().size() + 1));
				for (int i = 0; i < account.getParentProfileList().size(); i++) {
					fileContent.add(account.getParentProfileFromList(i).getName());
					fileContent.add(account.getParentProfileFromList(i).getImageString());
				}
				fileContent.add(parentProfile.getName());
				fileContent.add(parentProfile.getImageString());
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

		closeStreams();

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
		openStreams(account);

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			fileContent.add(line);
			if (line.equals("ChildProfiles:")) {
				bufferedReader.readLine();
				fileContent.add("" + (account.getChildProfileList().size() + 1));
				for (int i = 0; i < account.getChildProfileList().size(); i++) {
					fileContent.add(account.getChildProfileFromList(i).getName());
					fileContent.add(account.getChildProfileFromList(i).getImageString());
					fileContent.add("" + account.getChildProfileFromList(i).getPoints());
				}
				fileContent.add(childProfile.getName());
				fileContent.add(childProfile.getImageString());
				fileContent.add("" + childProfile.getPoints());
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

		closeStreams();

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

	public void removeTask(Account account, Task task) throws IOException {
		openStreams(account);

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			fileContent.add(line);
			if (line.equals("Tasks:")) {
				bufferedReader.readLine();
				fileContent.add("" + (account.getTaskList().size() - 1));
				for (int i = 0; i < account.getTaskList().size(); i++) {
					if (!account.getTaskFromList(i).compareTask(task)) {
						fileContent.add(account.getTaskFromList(i).getLocationName());
						fileContent.add(account.getTaskFromList(i).getChoreName());
						fileContent.add("" + account.getTaskFromList(i).getTaskValue());
						fileContent.add("" + account.getTaskFromList(i).getCompleted());
						try {
							fileContent.add("" + account.getTaskFromList(i).getChildProfile().getName());
						} catch (NullPointerException e) {
							fileContent.add("null");
						}
					}
				}
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

		closeStreams();

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

	public void completeTask(Account account, Task task, ChildProfile childProfile) throws IOException {
		removeTask(account, task);
		openStreams(account);

		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			fileContent.add(line);
			if (line.equals("ChildProfiles:")) {
				fileContent.add(bufferedReader.readLine());
				for (int i = 0; i < account.getChildProfileList().size(); i++) {
					if (!account.getChildProfileFromList(i).getName().equals(childProfile.getName())) {
						fileContent.add(account.getChildProfileFromList(i).getName());
						fileContent.add("" + account.getChildProfileFromList(i).getPoints());
					} else {
						fileContent.add(childProfile.getName());
						int points = childProfile.getPoints() + task.getTaskValue();
						System.out.println("" + task.getTaskValue());
						fileContent.add("" + points);
					}
				}
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

		closeStreams();

		if (f.exists()) {
			f.delete();
		}
		FileWriter out = new FileWriter(f);

		// Print new document.
		for (int i = 0; i < fileContent.size(); i++) {
			out.write(fileContent.get(i) + "\n");
		}
		out.close();

		closeStreams();

	}

	public void addReward(Account account, Reward reward) throws IOException {
		openStreams(account);

		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			fileContent.add(line);
			if (line.equals("Rewards:")) {
				bufferedReader.readLine();
				fileContent.add("" + (account.getRewardList().size() + 1));
				for (int i = 0; i < account.getRewardList().size(); i++) {
					// Reward name
					fileContent.add(bufferedReader.readLine());
					// Reward value
					fileContent.add(bufferedReader.readLine());
					// Reward progress
					fileContent.add(bufferedReader.readLine());
					// Reward icon
					// fileContent.add(bufferedReader.readLine());
				}
				break;
			}
		}
		fileContent.add(reward.getRewardName());
		fileContent.add("" + reward.getPointValue());
		fileContent.add("" + reward.getProgress());
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

		closeStreams();

		if (f.exists()) {
			f.delete();
		}
		FileWriter out = new FileWriter(f);

		// Print new document.
		for (int i = 0; i < fileContent.size(); i++) {
			out.write(fileContent.get(i) + "\n");
		}
		out.close();

		closeStreams();

	}

	public void removeReward(Account account, Reward reward) throws IOException {
		openStreams(account);

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			fileContent.add(line);
			if (line.equals("Tasks:")) {
				bufferedReader.readLine();
				fileContent.add("" + (account.getTaskList().size() - 1));
				for (int i = 0; i < account.getTaskList().size(); i++) {
					if (!account.getRewardFromList(i).compareRewards(reward)) {
						fileContent.add(account.getRewardFromList(i).getRewardName());
						fileContent.add("" + account.getRewardFromList(i).getPointValue());
						fileContent.add("" + account.getRewardFromList(i).getProgress());
					}
				}
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

		closeStreams();

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

	public void setTaskAsComplete(Account account, Task task, ChildProfile childProfile) throws IOException {
		openStreams(account);
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			fileContent.add(line);
			if (line.equals("Tasks:")) {
				fileContent.add(bufferedReader.readLine());
				for (Task t : account.getTaskList()) {
					if (!t.compareTask(task)) {
						fileContent.add(bufferedReader.readLine());
						fileContent.add(bufferedReader.readLine());
						fileContent.add(bufferedReader.readLine());
						fileContent.add(bufferedReader.readLine());
						fileContent.add(bufferedReader.readLine());
					} else {
						fileContent.add(task.getChoreName());
						fileContent.add(task.getLocationName());
						fileContent.add("" + task.getTaskValue());
						fileContent.add("true");
						fileContent.add(childProfile.getName());
					}
				}
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

		closeStreams();

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

	public void addRewardPoints(Account account, Reward reward, ChildProfile childProfile, int i2) throws IOException {
		openStreams(account);

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			fileContent.add(line);
			if (line.equals("ChildProfiles:")) {
				fileContent.add(bufferedReader.readLine());
				for (ChildProfile p : account.getChildProfileList()) {
					if (!p.getName().equals(childProfile.getName())) {
						fileContent.add(bufferedReader.readLine());
						fileContent.add(bufferedReader.readLine());
					} else {
						fileContent.add(childProfile.getName());
						fileContent.add("" + (childProfile.getPoints() - i2));
					}
				}

			}
			if (line.equals("Tasks:")) {
				fileContent.add(bufferedReader.readLine());
				for (int i = 0; i < account.getTaskList().size(); i++) {
					if (!account.getRewardFromList(i).compareRewards(reward)) {
						fileContent.add(account.getRewardFromList(i).getRewardName());
						fileContent.add("" + account.getRewardFromList(i).getPointValue());
						fileContent.add("" + account.getRewardFromList(i).getProgress());
					} else {
						fileContent.add(account.getRewardFromList(i).getRewardName());
						fileContent.add("" + (account.getRewardFromList(i).getPointValue()));
						fileContent.add("" + account.getRewardFromList(i).getProgress() + i2);
					}
				}
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

		closeStreams();

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

	public LinkedList<Reward> getRewards(Account account) throws IOException {
		LinkedList<Reward> list = new LinkedList();

		openStreams(account);
		String line = "";
		while (line != null) {
			line = bufferedReader.readLine();
			if (line.equals("Rewards:")) {
				int rewardCount = Integer.parseInt(bufferedReader.readLine());
				for (int i = 0; i < rewardCount; i++) {
					String rewardName = bufferedReader.readLine();
					int rewardValue = Integer.parseInt(bufferedReader.readLine());
					int rewardProgress = Integer.parseInt(bufferedReader.readLine());
					Reward reward = new Reward(rewardName, rewardValue, rewardProgress);
					list.add(reward);
				}
				break;
			}
		}
		closeStreams();
		return list;
	}

}
