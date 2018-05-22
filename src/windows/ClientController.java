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
import client.UserController;
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
	private ChildTaskWindow ctw;
	private ChildRewardWindow crw;
	private ChildProfileWindow cpw;
	private ChildHomeWindow chw;
	private HelpWindow hw;
	private ProfileStartWindow psw;
	private ParentHomeWindow phw;
	private ParentEditTaskWindow petw;
	private ParentTaskWindow ptw;
	private ParentProfileWindow ppw;
	private ParentRewardWindow prw;
	private ParentSettingsWindow pSettingsw;
	private Account account;
	private Client client;
	private Boolean clientIsRunning = false;
	private ProfilePicture profilePictures;

	private ChildProfile childProfile;
	private ParentProfile parentProfile;

	public ClientController(Account account, Client client) {
		this.client = client;
		this.client.addObserver(this);
		this.account = account;
		frame = new JFrame();
		try {
			acw = new AddChildWindow (this);
			ctw = new ChildTaskWindow(this);
			crw = new ChildRewardWindow(this);
			cpw = new ChildProfileWindow(this);
			chw = new ChildHomeWindow (this);
			psw = new ProfileStartWindow(this);
			phw = new ParentHomeWindow(this);
			petw = new ParentEditTaskWindow(this);
			ptw = new ParentTaskWindow(this);
			ppw = new ParentProfileWindow(this);
			prw = new ParentRewardWindow (this);
			pSettingsw = new ParentSettingsWindow (this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		profilePictures = new ProfilePicture();
		psw = new ProfileStartWindow(this);
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
		setPanel(psw);
		try {
			this.account.setTaskList(this.client.getTasksFromServer(this.account));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initChild() throws IOException {
		ctw = new ChildTaskWindow(this);
		crw = new ChildRewardWindow2(this);
		cpw = new ChildProfileWindow(this);
		chw = new ChildHomeWindow(this);
	}
	
	public ParentProfile getParentProfile() {
		return parentProfile;
	}
	public ChildProfile getChildProfile() {
		return childProfile;
	}

	private void initParent() throws IOException {
		acw = new AddChildWindow(this);
		phw = new ParentHomeWindow(this);
		petw = new ParentEditTaskWindow(this);
		ptw = new ParentTaskWindow2(this);
		ppw = new ParentProfileWindow(this);
		prw = new ParentRewardWindow(this);
		pSettingsw = new ParentSettingsWindow(this);
		hw = new HelpWindow (this);
	}

	public ProfilePicture getPictures() {
		return profilePictures;
	}

	public void updateProfilesList() {
		// TODO Auto-generated method stub

	}

	public LinkedList<Task> addTaskToAccount(Task task) throws UnknownHostException, IOException {
		return client.addTaskToServer(account, task);
	}
	public LinkedList<Task> setTaskAsCompleted(Task task){
		return client.setTaskAsCompleted(account, task, childProfile);
	}

	public void addChildProfile(ChildProfile childProfile) throws IOException {
		client.addChildProfileToServer(account, childProfile);
	}

	public void addParentProfile(ParentProfile parentProfile) throws IOException {
		client.addParentProfileToServer(account, parentProfile);
	}

	public Account getAccount() {
		return account;
	}

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

	private void setPanel(JPanel panel) {
		frame.remove(this.panel);
		this.panel = panel;
		frame.add(this.panel, BorderLayout.CENTER);
		frame.revalidate();
		this.panel.updateUI();
	}

	public void setViewParentProfileWindow() {
		setPanel(ppw);
	}

	public void setViewParentTaskWindow() {
		setPanel(ptw);
	}

	public void setViewChildTaskWindow() {
		setPanel(ctw);
	}

	public void setViewChildHomeWindow() {
		setPanel(chw);
	}

	public void setViewChildRewardWindow2() {
		setPanel(crw);
	}

	public void setViewChildProfileWindow() {
		setPanel(cpw);
	}

	public void setViewProfileStartWindow() {
		setPanel(psw);
	}

	public void setViewParentHomeWindow() {
		setPanel(phw);
	}

	public void setViewParentEditTaskWindow() {
		setPanel(petw);

	}

	public void setViewAddChildWindow() {
		setPanel(acw);
	}

	public void setViewParentSettingsWindow() {
		setPanel(pSettingsw);
	}
	public void setViewHelpWindow () {
		setPanel (hw);
	}

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

	public void updateTaskLists() {
		ptw.updateTasks();
	}

	public LinkedList<Reward> addReward(Reward reward) throws IOException {
		LinkedList<Reward> rewardList;
		rewardList = client.addRewardToServer(account, reward);
		return rewardList;
	}

	public LinkedList<Reward> removeReward(Reward reward) throws ClassNotFoundException, IOException {
		LinkedList<Reward> rewardList;
		rewardList = client.removeRewardFromServer(account, reward);
		return rewardList;
	}

	public LinkedList<Reward> addPointsToReward(Reward reward, int points, ChildProfile childProfile)
			throws IOException {
		LinkedList<Reward> rewardList;
		rewardList = client.addPointsToReward(reward, points, childProfile, account);
		return rewardList;
	}

	public void setViewParentRewardWindow() {
		setPanel(prw);
	}

	public LinkedList<Task> completeTask(Task task, ChildProfile childProfile) throws IOException {
		LinkedList<Task> taskList;
		taskList = client.setTaskCompleted(account, task, childProfile);
		return taskList;
	}
}
