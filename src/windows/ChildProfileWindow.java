package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import profiles.Account;

/**
 * GUI for children's profile
 * 
 * @author Maida
 * 
 *         25/4: Reinstalled and retry. --- 27/4: Reinstalled, once again. Took
 *         >5h. --- 2/5: Reinstalled. AGAIN. -- 4/5: It seems like I don't have
 *         all classes like the others. Maybe my Git is bad again?
 *
 */

public class ChildProfileWindow extends JPanel implements ActionListener {
	private Account account;
	private String name;

	private JLabel lblToDo;
	private JLabel lblTitleHome; // Title, in middle of top panel
	private ImageIcon dustBallImage; // Profilepic, in the middle of middle panel
	private JButton btnProfileSymbol; // Symbol, profilepic will be inside this button

	private JLabel lblNumberOrder; // Number of tasks
	private JLabel lblLocation;
	private JButton btnChore; // When user clicks task, they will in fact click a button to take them to class
								// ChildTaskWindow
	private JLabel lblRewardPoints;

	/*
	 * Three setters and three getters for the components inside of a task (L + C +
	 * R) ADD GETTERS!!!! From what class?????
	 */
	public void setLblLocation(JLabel lblLocation) {
		this.lblLocation = lblLocation;
	}

	public void setLblChore(JLabel lblLocation) {
		this.btnChore = btnChore;
	}

	public void setLblRewardPoints(JLabel lblLocation) {
		this.lblRewardPoints = lblRewardPoints;
	}

	// Getters for other objects
	public Account getAccount() {
		return account;
	}

	// Funktionalitet som inte �r implementerad �nnu
	// public RewardWindow getProgress() {
	// return progress;
	// }

	// Constructor
	public ChildProfileWindow() {
		// this.name = name;
		start();

	}

	private void start() {
		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
		lblLocation.setOpaque(true);
		btnChore.setOpaque(true);
		lblRewardPoints.setOpaque(true);

	}

	/*
	 * Set sizes and add components
	 */
	private void InitializeGUI() {
		// TODO Auto-generated method stub

		// PnlMain
		this.setBounds(6, 6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		// Top panel
		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);

		// Home-label in middle of pnlTop
		lblTitleHome = new JLabel("Hem");
		lblTitleHome.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitleHome.setBounds(105, 30, 285, 20);
		pnlTop.add(lblTitleHome);

		// Middle panel
		JPanel pnlMiddle = new JPanel();
		pnlMiddle.setBounds(12, 130, 358, 140); // Original 12, 130, 358, 140
		pnlMiddle.setLayout(new GridBagLayout());
		pnlMiddle.setBackground(Color.YELLOW);
		GridBagConstraints c = new GridBagConstraints();

		// Profile picture in the middle of middle panel
		btnProfileSymbol = new JButton();
		dustBallImage = new ImageIcon("images/20x20Dammtuss.jpg");
		btnProfileSymbol.setBounds(250, 16, 90, 50); // Original 250, 16, 90, 50
		btnProfileSymbol.setIcon(dustBallImage);
		pnlMiddle.add(btnProfileSymbol);

		/*
		 * Components added to the middle panel. Remember; a task A task consists of
		 * location + chore + reward.
		 */
		lblToDo = new JLabel("Sysslor att g�ra");
		lblToDo.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblToDo.setBounds(1, 10, 90, 50);
		pnlMiddle.add(lblToDo);

		lblLocation = new JLabel("K�k");
		lblLocation.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblLocation.setBounds(1, 16, 90, 50);
		pnlMiddle.add(lblLocation);

		btnChore = new JButton("Dammsuga Vardagsrummet");
		btnChore.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnChore.setBounds(40, 16, 90, 50); // Original 40, 16, 90, 50
		pnlMiddle.add(btnChore);

		lblRewardPoints = new JLabel(" 5p");
		lblRewardPoints.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRewardPoints.setBounds(80, 16, 90, 50); // Original 80, 16, 90, 50
		pnlMiddle.add(lblRewardPoints);

		// Components of task needs size constraints. In middle panel
		// I didn't have btnProfileSymbol in gridbagcontraints before
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1; // 1
		c.weighty = 1; // 1
		c.gridx = 1;
		c.gridy = 0;
		pnlMiddle.add(btnProfileSymbol, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1; // 1
		c.weighty = 1; // 1
		c.gridx = 1;
		c.gridy = 1;
		pnlMiddle.add(lblToDo, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1; // 1
		c.weighty = 1; // 1
		c.gridx = 0;
		c.gridy = 2;
		pnlMiddle.add(lblLocation, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 2;
		pnlMiddle.add(btnChore, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 2;
		c.gridy = 2;
		pnlMiddle.add(lblRewardPoints, c);

		// Bottom panel. It's empty.
		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.YELLOW);

		// Add panels
		this.add(pnlTop);
		this.add(pnlMiddle);
		this.add(pnlBottom);

	}

	public static void main(String[] args) {
		ChildProfileWindow pnlChildProfile = new ChildProfileWindow();
		JFrame frame = new JFrame();
		frame.add(pnlChildProfile);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(400, 600));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
