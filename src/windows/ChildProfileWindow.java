package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import profiles.Account;

import windows.ClientController;

/**
 * GUI for children's profile
 * 
 * @author Maida & Angelina
 * 
 *         25/4: Reinstalled and retry. --- 27/4: Reinstalled, once again. Took
 *         >5h. --- 2/5: Reinstalled. AGAIN. -- 4/5: It seems like I don't have
 *         all classes like the others. Maybe my Git is bad again?
 *
 */

public class ChildProfileWindow extends JPanel implements ActionListener {
	private Account account;
	private String name; // Delete? - Angie

	private JLabel lblToDo;
	private JLabel lblTitleChores; // Title, in middle of top panel
	private ImageIcon dustBallImage; // Profilepic, in the middle of middle panel
	private JButton btnProfileSymbol; // Symbol, profilepic will be inside this button
	private JButton btnHome;
	private JLabel lblNumberOrder; // Number of tasks. Delete?
	private JLabel lblLocation;
	private JButton btnChore; // When user clicks task, they will in fact click a button to take them to class
	// ChildTaskWindow
	private JLabel lblRewardPoints;

	private ClientController clientController;

	//Setters
	public void setLblLocation(JLabel lblLocation) {
		this.lblLocation = lblLocation;
	}

	public void setLblChore(JLabel lblLocation) {
		this.btnChore = btnChore;
	}

	public void setLblRewardPoints(JLabel lblLocation) {
		this.lblRewardPoints = lblRewardPoints;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	//Getters
	public Account getAccount() {
		return account;
	}

	// Constructor
	public ChildProfileWindow(ClientController clientController) throws IOException {
		// this.name = name; Delete?
		this.clientController = clientController;

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
		lblTitleChores = new JLabel("Dina Sysslor");
		lblTitleChores.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitleChores.setBounds(105, 30, 285, 20);
		pnlTop.add(lblTitleChores);

		btnHome = new JButton();
		btnHome.addActionListener(this);
		btnHome.setIcon(new ImageIcon("images/House.jpg"));
		btnHome.setBounds(5, 5, 80, 65);
		pnlTop.add(btnHome);

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
		lblToDo = new JLabel("Sysslor att göra");
		lblToDo.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblToDo.setBounds(1, 10, 90, 50);
		pnlMiddle.add(lblToDo);

		lblLocation = new JLabel("Kök");
		lblLocation.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblLocation.setBounds(1, 16, 90, 50);
		pnlMiddle.add(lblLocation);

		btnChore = new JButton("Dammsuga Vardagsrummet");
		btnChore.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnChore) {
			clientController.setViewChildTaskWindow();
		} else if (e.getSource() == btnHome) {
			clientController.setViewChildHomeWindow();
		}

	}

}
