package windows;

import javax.swing.ImageIcon;

import profiles.Account;
import profiles.ChildProfile;

/** A class that draws the window children will see when they
 *  go to look at how many points they have accumulated, and what rewards
 *  they can get. The rewards will be images, with a picture of what 
 *  the reward is (e.g. ice cream / cinema). The image will also state the 
 *  amount of points needed for a child to get the reward. 
 *  The rewards will be dimmed / disabled for pushing, until a child
 *  has acquired the stated amount of points. 
 *  Updated 
 * 
 * @author dalvig
 *
 */


public class ChildRewardWindow extends AbstractWindowUI {
	
	private Account account;
	private ChildProfile childProfile;
	private int rewardPoints;
	private ImageIcon profilePicture;
	private ImageIcon rewardActivity;
	private ImageIcon boobs;
	

	public ChildRewardWindow(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

}
