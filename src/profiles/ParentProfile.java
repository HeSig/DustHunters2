package profiles;

import locations.Location;
import rewards.Reward;
import tasks.Chore;
import tasks.Task;
/**
 * 
 * @author Henrik Sigeman
 *
 */
public class ParentProfile {
	private String name;
	private Account account;

	public ParentProfile(String name) {
		this.name = name;
	}

	/*
	public void createNewTask(Location location, Chore chore, int value) {
		account.addTask(new Task(location, chore, value));
	}
	public void createNewReward(String rewardName, int rewardValue) {
		account.addReward(new Reward(rewardName, rewardValue));
	}
	*/

}
