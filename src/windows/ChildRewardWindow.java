package windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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


public class ChildRewardWindow extends JPanel implements ActionListener {
	
	private Account account;
	private ChildProfile childProfile;
	private int rewardPoints;
	private ImageIcon profilePicture;
	private ImageIcon rewardActivity;
	private JLabel childName = new JLabel("johnny");
	private JButton btnBack;
	private JFrame frame;
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
	
	