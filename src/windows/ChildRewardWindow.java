package windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

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
	private ImageIcon profilePicture = new ImageIcon("images/witch.png");
	private ImageIcon rewardActivity;
	private JLabel childName = new JLabel("johnny");
	private JButton btnBack;
	private JFrame frame;
	private JLabel lblTitle;
	
	public ChildRewardWindow() {
		start();
	}
	
	public void start() {
		// TODO Auto-generated method stub

		frame = new JFrame();
		frame.setBounds(0, 0, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle(" RewardWindow ");
		InitializeGUI();

		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}
	
	public void InitializeGUI() {
		// TODO Auto-generated method stub
		JPanel pnlTop = new JPanel();
		Border border1 = BorderFactory.createTitledBorder("TopPanel");
		pnlTop.setBorder(border1);
		pnlTop.setBounds(12, 12, 368, 100);
		pnlTop.setLayout(null);
		
		frame.setBackground(Color.YELLOW);
		pnlTop.setBackground(Color.YELLOW);
		lblTitle = new JLabel("Möjliga Belöningar ");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setForeground(Color.GREEN);;
	
		lblTitle.setBounds(140, 30, 300, 20);
		pnlTop.add(lblTitle);

		btnBack = new JButton(" Tilbaka ");
		btnBack.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnBack.setBounds(10, 16, 90, 50);
		pnlTop.add(btnBack);

		frame.add(pnlTop);

		JPanel pnlInfo = new JPanel();
		Border border2 = BorderFactory.createTitledBorder("Choices");
		Border border3 = BorderFactory.createEtchedBorder();
		pnlInfo.setBorder(border2);
		pnlInfo.setBounds(12, 125, 368, 100);
		pnlInfo.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		frame.add(pnlInfo);
		
		pnlInfo.add(childName);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		ChildRewardWindow cReward = new ChildRewardWindow();
		
	}
}


	
	
	