package profiles;

import java.io.Serializable;

import locations.Location;
import rewards.Reward;
import tasks.Chore;
import tasks.Task;
/**
 * 
 * @author Henrik Sigeman
 *
 */
public class ParentProfile implements Serializable{
	private String name;
	private Account account;

	public ParentProfile(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
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
