package profiles;

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

	private List<ChildProfile> childProfileList;
	private List<ParentProfile> parentProfileList;
	private List<Task> taskList;
	private List<Reward> rewardList;

	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public void addChildProfile(ChildProfile profile) {
		childProfileList.add(profile);

	}

	public void addParentProfile(ParentProfile profile) {
		parentProfileList.add(profile);
	}

	public void addTask(Task task) {
		taskList.add(task);
	}

	public void addReward(Reward reward) {
		rewardList.add(reward);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public Task getTaskFromList(int index) {
		if (index > taskList.size()) {
			return taskList.get(taskList.size() - 1);
		} else {
			return taskList.get(index);
		}
	}

	public List<Reward> getRewardList() {
		return rewardList;
	}

	public Reward getRewardFromList(int index) {
		if (index > rewardList.size()) {
			return rewardList.get(rewardList.size() - 1);
		} else {
			return rewardList.get(index);
		}
	}

}