package profiles;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import rewards.Reward;
import tasks.Task;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class Account implements java.io.Serializable {
	private static final long serialVersionUID = -3465005032629663541L;

	private String email, password;
	
	//Todo: But ArrayList till LinkedList?

	private LinkedList<ChildProfile> childProfileList = new LinkedList<ChildProfile>();
	private LinkedList<ParentProfile> parentProfileList = new LinkedList<ParentProfile>();
	private LinkedList<Task> taskList = new LinkedList<Task>();
	private LinkedList<Reward> rewardList = new LinkedList<Reward>();
	
	/**
	 * Create a new Account (not automatically registered)
	 * 
	 * @param email
	 *            Account Email
	 * @param password
	 *            Account password
	 */
	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public Account(Account account) {
		this.email = account.getEmail();
		this.password = account.getPassword();
		setParentProfileList(account.getParentProfileList());
		setChildProfileList(account.getChildProfileList());
		setTaskList(account.getTaskList());
		setRewardList(account.getRewardList());
	}

	public LinkedList<ChildProfile> getChildProfileList() {
		return childProfileList;
	}

	public void setChildProfileList(LinkedList<ChildProfile> childProfileList) {
		this.childProfileList = childProfileList;
	}

	public LinkedList<ParentProfile> getParentProfileList() {
		return parentProfileList;
	}

	public void setParentProfileList(LinkedList<ParentProfile> parentProfileList) {
		this.parentProfileList = parentProfileList;
	}

	public void setTaskList(LinkedList<Task> taskList) {
		this.taskList = taskList;
	}

	public void setRewardList(LinkedList<Reward> rewardList) {
		this.rewardList = rewardList;
	}
	
	public ChildProfile getChildProfileFromList(int i) {
		return childProfileList.get(i);
	}
	
	public ParentProfile getParentProfileFromList(int i) {
		return parentProfileList.get(i);
	}

	

	/**
	 * Add a childprofile to the account;
	 * 
	 * @param profile
	 *            the profile to be added.
	 */
	public void addChildProfile(ChildProfile profile) {
		childProfileList.add(profile);

	}

	/**
	 * Add a parentprofile to the account;
	 * 
	 * @param profile
	 *            the profile to be added.
	 */
	public void addParentProfile(ParentProfile profile) {
		parentProfileList.add(profile);
	}

	/**
	 * Add a task to the account
	 * 
	 * @param task
	 *            the task to be added.
	 */
	public void addTask(Task task) {
		taskList.add(task);
	}

	/**
	 * Add a reward to the account
	 * 
	 * @param reward
	 *            the reward to be added.
	 */
	public void addReward(Reward reward) {
		rewardList.add(reward);
	}

	/**
	 * Return the account email;
	 * 
	 * @return the set email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the account email.
	 * 
	 * @param email
	 *            the new email address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the account password.
	 * 
	 * @return the account password;
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the account password
	 * 
	 * @param password
	 *            The new password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the list of tasks.
	 * 
	 * @return the list of tasks.
	 */
	public LinkedList<Task> getTaskList() {
		return taskList;
	}

	/**
	 * Get specific task from the list of tasks.
	 * 
	 * @param index
	 *            the task index.
	 * @return the task at index.
	 */
	public Task getTaskFromList(int index) {
		if (index > taskList.size()) {
			return taskList.get(taskList.size() - 1);
		} else {
			return taskList.get(index);
		}
	}

	/**
	 * Get list of rewards.
	 * 
	 * @return The list of rewards.
	 */
	public LinkedList<Reward> getRewardList() {
		return rewardList;
	}

	/**
	 * Get specific reward from the list of rewards.
	 * 
	 * @param index
	 *            the reward index.
	 * @return the reward at index.
	 */
	public Reward getRewardFromList(int index) {
		if (index > rewardList.size()) {
			return rewardList.get(rewardList.size() - 1);
		} else {
			return rewardList.get(index);
		}
	}

}