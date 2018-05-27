package windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import client.Client;
import profiles.Account;
import profiles.ChildProfile;
import profiles.ParentProfile;
import profiles.ProfilePicture;
import rewards.Reward;
import tasks.Task;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class ClientController implements ActionListener, Observer {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JFrame frame;
	private JPanel panel;
	private JPanel updatePanel = new JPanel();
	private JButton updateBtn = new JButton("Update");
	private JTextField updateText = new JTextField();
	private Dimension boxDimension = new Dimension(128, 64);
	private AddChildWindow acw;
	private ChildPerformTaskWindow cptw;
	private ChildProfileWindow cpw;
	private ChildRewardWindow crw;
	private ChildChooseTaskWindow cctw;
	private ChildHomeWindow chw;
	private HelpWindow hw;
	private ProfileStartWindow psw;
	private ParentHomeWindow phw;
	private ParentEditTaskWindow petw;
	private ParentTaskWindow ptw;
	private ParentProfileWindow ppw;
	private ParentCreateRewardWindow pcrw;
	private ParentRewardWindow prw;
	private ParentSettingsWindow pSettingsw;
	private TaskStoryWindow tsw;
	private RegisterLoginWindow rlw;
	private Account account;
	private Client client;
	private Boolean clientIsRunning = false;
	private ProfilePicture profilePictures;
	private int port;
	private String host;

	private ChildProfile childProfile;
	private ParentProfile parentProfile;

	
	/**
	 * Constructor for ClientController
	 * @param client klienten.
	 */
	public ClientController(Client client) {
		this.client = client;
		this.client.addObserver(this);
		//this.account = account;
		frame = new JFrame();
		profilePictures = new ProfilePicture();
		rlw = new RegisterLoginWindow(this);
		
		updatePanel.setPreferredSize(new Dimension(128, 128));
		frame.setPreferredSize(new Dimension(400, 600));
		frame.setLayout(new BorderLayout());
		updateBtn.addActionListener(this);
		updateBtn.setPreferredSize(boxDimension);
		updateText.setPreferredSize(boxDimension);
		updatePanel.setLayout(new BorderLayout());
		updatePanel.add(updateBtn, BorderLayout.NORTH);
		updatePanel.add(updateText, BorderLayout.SOUTH);
		panel = updatePanel;
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		setViewRegisterLoginWindow();
		
	}
	
	
	/**
	 * Initialize childwindows if the user is using a child profile
	 * @throws IOException
	 */
	private void initChild() throws IOException {
		cptw = new ChildPerformTaskWindow(this);
		crw = new ChildRewardWindow(this);
		cpw = new ChildProfileWindow(this);
		cctw = new ChildChooseTaskWindow(this);
		chw = new ChildHomeWindow(this);
		tsw = new TaskStoryWindow(this);
	}
	/**
	 * Initialize parent windows if the user is using a parent profile.
	 * @throws IOException
	 */
	private void initParent() throws IOException {
		acw = new AddChildWindow(this);
		phw = new ParentHomeWindow(this);
		petw = new ParentEditTaskWindow(this);
		ptw = new ParentTaskWindow(this);
		ppw = new ParentProfileWindow(this);
		prw = new ParentRewardWindow(this);
		pcrw = new ParentCreateRewardWindow(this);
		pSettingsw = new ParentSettingsWindow(this);
		hw = new HelpWindow(this);
	}
	
	/**
	 * Returns the currently active parent profile
	 * @return the parent profile
	 */
	public ParentProfile getParentProfile() {
		return parentProfile;
	}
	/**
	 * Returns the currently active child profile
	 * @return the child profile
	 */
	public ChildProfile getChildProfile() {
		return childProfile;
	}
	/**
	 * Returns the list of profile pictures
	 * @return the profile picture
	 */
	public ProfilePicture getPictures() {
		return profilePictures;
	}

	/**
	 * Add task to the account database.
	 * @param task The task to be added.
	 * @return a full list of the tasks in the account after the new task has been added.
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public LinkedList<Task> addTaskToAccount(Task task) throws UnknownHostException, IOException {
		return client.addTaskToServer(account, task);
	}

	/**
	 * Sets the chosen task as completed.
	 * @param task The task to be completed.
	 * @return a full list of the tasks in the account after the task has been set as completed.
	 */
	public LinkedList<Task> setTaskAsCompleted(Task task) {
		return client.setTaskAsCompleted(account, task, childProfile);
	}

	/**
	 * Add a child profile to the account through the server.
	 * @param childProfile The child profile to be added.
	 * @throws IOException
	 */
	public void addChildProfile(ChildProfile childProfile) throws IOException {
		client.addChildProfileToServer(account, childProfile);
	}

	/**
	 * Add a parent profile to the account through the server.
	 * @param parentProfile The parent profile to be added.
	 * @throws IOException
	 */
	public void addParentProfile(ParentProfile parentProfile) throws IOException {
		client.addParentProfileToServer(account, parentProfile);
	}

	/**
	 * Returns the current account.
	 * @return the current account for this ClientController.
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Returns the full list of tasks from the current account.
	 * @return the list of tasks.
	 */
	public LinkedList<Task> getTasksFromAccount() {
		while (clientIsRunning) {
			try {
				Thread.sleep(1000);
				System.out.println(clientIsRunning);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		LinkedList<Task> list = new LinkedList<Task>();
		try {
			list = client.getTasksFromServer(account);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Set the current panel the frame is disaplaying.
	 * @param panel the new panel.
	 */
	private void setPanel(JPanel panel) {
		frame.remove(this.panel);
		this.panel = panel;
		frame.add(this.panel, BorderLayout.CENTER);
		frame.revalidate();
		this.panel.updateUI();
	}

	/**
	 * Sets the view to ParentProfileWindow
	 */
	public void setViewParentProfileWindow() {
		setPanel(ppw);
	}
	/**
	 * Sets the view to RegisterLoginWindow
	 */
	public void setViewRegisterLoginWindow() {
		setPanel(rlw);
	}
	/**
	 * Sets the view to ParentTaskWindow
	 */
	public void setViewParentTaskWindow() {
		setPanel(ptw);
	}
	/**
	 * Sets the view to ChildPerformTaskWindow
	 */
	public void setViewChildPerformTaskWindow() {
		setPanel(cptw);
	}

	/**
	 * Sets the view to ChildHomeWindow
	 */
	public void setViewChildHomeWindow() {
		setPanel(chw);
	}
	/**
	 * Set the view to ChildProfileWindow
	 */
	public void setViewChildProfileWindow() {
		setPanel(cpw);
	}
	/**
	 * Set the view to ChildRewardWindow
	 */
	public void setViewChildRewardWindow() {
		setPanel(crw);
	}
	/**
	 * Set the view to ChildChooseTaskWindow
	 */
	public void setViewChildChooseTaskWindow() {
		setPanel(cctw);
	}
	/**
	 * Set the view to ProfileStartWindow
	 */
	public void setViewProfileStartWindow() {
		setPanel(psw);
	}
	/**
	 * Set the view to ParentHomeWindow
	 */
	public void setViewParentHomeWindow() {
		setPanel(phw);
	}
	/**
	 * Set the view to ParentEditTaskWindow
	 */
	public void setViewParentEditTaskWindow() {
		setPanel(petw);

	}
	/**
	 * Set the view to AddChildWindow
	 */
	public void setViewAddChildWindow() {
		setPanel(acw);
	}
	/**
	 * Set the view to ParentSettingsWindow
	 */
	public void setViewParentSettingsWindow() {
		setPanel(pSettingsw);
	}
	/**
	 * Set the view to ViewHelpWindow
	 */
	public void setViewHelpWindow() {
		setPanel(hw);
	}
	/**
	 * Set the view to TaskStoryWindow
	 */
	public void setTaskStoryWindow() {
		setPanel(tsw);
	}
	/**
	 * Set the view to ParentRewardWindow
	 */
	public void setViewParentRewardWindow() {
		setPanel(prw);
	}
	/**
	 * Set the view to ParentCreateRewardWindow
	 */
	public void setViewParentCreateRewardWindow() {
		setPanel(pcrw);
	}

	/**
	 * Sets the current parent profile to the one with the same name in the account.
	 * @param name The name of the profile.
	 */
	public void setParentProfile(String name) {
		for (int i = 0; i < account.getParentProfileList().size(); i++) {
			if (account.getParentProfileList().get(i).getName().equals(name)) {
				parentProfile = account.getParentProfileList().get(i);
			}
		}
		try {
			initParent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Sets the current child profile to the one with the same name in the account.
	 * @param name The name of the profile.
	 */
	public void setChildProfile(String name) {
		for (int i = 0; i < account.getChildProfileList().size(); i++) {
			if (account.getChildProfileList().get(i).getName().equals(name)) {
				childProfile = account.getChildProfileList().get(i);
			}
		}
		try {
			initChild();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateBtn) {
			setPanel(psw);
			try {
				account.setTaskList(client.getTasksFromServer(account));
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		clientIsRunning = false;
	}
	/**
	 * Update the taskList.
	 */
	public void updateTaskLists() {
		ptw.updateTasks();
	}
	/**
	 * Add reward to the account through the server.
	 * @param reward the reward to be added to the account
	 * @return the full list of rewards.
	 * @throws IOException
	 */
	public LinkedList<Reward> addReward(Reward reward) throws IOException {
		LinkedList<Reward> rewardList;
		rewardList = client.addRewardToServer(account, reward);
		return rewardList;
	}
	/**
	 * Remove a reward to the account
	 * @param reward
	 * @return the full list of rewards
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public LinkedList<Reward> removeReward(Reward reward) throws ClassNotFoundException, IOException {
		LinkedList<Reward> rewardList;
		rewardList = client.removeRewardFromServer(account, reward);
		return rewardList;
	}
	/**
	 * Add points to a reward on the account.
	 * @param reward The reward that will recieve the points
	 * @param points The amount of points to be added to the rewardProgress
	 * @param childProfile The child who has done the task
	 * @return Returns the full list of rewards from the account
	 * @throws IOException
	 */
	public LinkedList<Reward> addPointsToReward(Reward reward, int points, ChildProfile childProfile)
			throws IOException {
		LinkedList<Reward> rewardList;
		rewardList = client.addPointsToReward(reward, points, childProfile, account);
		return rewardList;
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
	 * Logs in to the account.
	 * @param account The account to be logged in with
	 * @return the full account from the server.
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Account login(Account account) throws UnknownHostException, IOException, ClassNotFoundException {
		System.out.println("Controller is attempting the login");
		Account res = client.sendLoginToServer(account);
		this.account = res;
		psw = new ProfileStartWindow(this);
		setViewProfileStartWindow();
		return res;
	}
	/**
	 * Mark a task as completed.
	 * @param task the task to be marked.
	 * @param childProfile The profile that did the task.
	 * @return returns a full list of tasks from the account after the task has been set to completed.
	 * @throws IOException
	 */
	public LinkedList<Task> completeTask(Task task, ChildProfile childProfile) throws IOException {
		LinkedList<Task> taskList;
		taskList = client.setTaskCompleted(account, task, childProfile);
		return taskList;
	}
}
