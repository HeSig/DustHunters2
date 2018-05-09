package rewards;

import javax.swing.Icon;
/**
 * 
 * @author Henrik Sigeman
 *
 */
public class Reward {
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
	
	public void addPoints(int points){
		rewardProgress += points;
		if (rewardProgress >= pointValue) {
			goalMet = true;
		}
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
