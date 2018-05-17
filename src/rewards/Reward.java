package rewards;

import java.io.Serializable;

import javax.swing.Icon;
/**
 * 
 * @author Henrik Sigeman
 *
 */
public class Reward implements Serializable{
	private String rewardName;
	private int pointValue = 0;
	private int rewardProgress = 0;
	private Icon icon;
	@SuppressWarnings("unused")
	private Boolean goalMet = false;
	
	public Reward(String rewardName, int pointValue) {
		this.setRewardName(rewardName);
		this.pointValue = pointValue;
	}
	
	public Reward(String rewardName, int pointValue, int rewardProgress) {
		setRewardName(rewardName);
		this.pointValue = pointValue;
		this.rewardProgress = rewardProgress;
	}

	public Boolean compareRewards(Reward reward) {
		Boolean bool = true;
		if(!rewardName.equals(reward.getRewardName())) {
			bool = false;
		}
		if(pointValue != reward.getPointValue()) {
			bool = false;
		}
		return bool;
	}
	
	public int getProgress() {
		return rewardProgress;
	}
	
	public void addPoints(int points){
		rewardProgress += points;
		if (rewardProgress >= pointValue) {
			goalMet = true;
		}
	}
	
	public int getPointValue() {
		return pointValue;
	}

	public String getRewardName() {
		return rewardName;
	}

	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}
}
