package windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import profiles.Account;
import profiles.ParentProfile;

/*
 * A GUI class that shows the home panel for the Parent Profile.
 * From this class you can reach parent profile, settings, task, rewards and manual/help GUI through actionListeners. 
 * author: Angelina Fransson
 */
@SuppressWarnings("serial")
public class ParentHomeWindow extends JPanel implements ActionListener {
	private Account account;
	private ParentProfile parentProfile;

	private JButton btnSettings;
	private JButton btnTasks;
	private JButton btnRewards;
	private JButton btnHelpManual;
	private JLabel lblHome;
	private JButton btnProfile;
	private ImageIcon imageProfile;
	private ClientController controller;

	/**
	 * Constructor where the GUI is constructed.
	 * 
	 * @param clientController
	 */
	public ParentHomeWindow(ClientController clientController) {
		this.controller = clientController;
		start();

	}

	/**
	 * Makes the GUI visible and sets bounds for the main panel.
	 */
	private void start() {
		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);

	}

	public Account getAccount() {
		return account;
	}

	public ParentProfile getParentProfile() {
		return parentProfile;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setParentProfile(ParentProfile parentProfile) {
		this.parentProfile = parentProfile;

	}

	/**
	 * The GUI.
	 */
	private void InitializeGUI() {

		this.setBounds(6, 6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 90);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);

		lblHome = new JLabel("Hem");
		lblHome.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblHome.setBounds(150, 30, 285, 20);
		pnlTop.add(lblHome);

		imageProfile = (new ImageIcon(
				controller.getPictures().getImage(controller.getParentProfile().getImageString())));
		btnProfile = new JButton();
		btnProfile.addActionListener(this);
		btnProfile.setBounds(275, 16, 75, 70);
		btnProfile.setIcon(imageProfile);
		pnlTop.add(btnProfile);

		JPanel pnlMiddle = new JPanel();
		pnlMiddle.setBounds(12, 180, 358, 140);
		pnlMiddle.setLayout(new GridBagLayout());
		pnlMiddle.setBackground(Color.YELLOW);
		GridBagConstraints c = new GridBagConstraints();

		btnSettings = new JButton("Inställningar");
		btnSettings.addActionListener(this);
		btnSettings.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnSettings.setBounds(1, 16, 90, 50);

		btnTasks = new JButton("Sysslor");
		btnTasks.addActionListener(this);
		btnTasks.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnTasks.setBounds(40, 16, 90, 50);
		pnlMiddle.add(btnTasks);

		btnRewards = new JButton("Belöningar");
		btnRewards.addActionListener(this);
		btnRewards.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnRewards.setBounds(80, 16, 90, 50);
		pnlMiddle.add(btnRewards);

		btnHelpManual = new JButton("Hjälp/Manual");
		btnHelpManual.addActionListener(this);
		btnHelpManual.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnHelpManual.setBounds(120, 16, 90, 50);
		pnlMiddle.add(btnHelpManual);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = -4;
		c.weighty = 1;
		c.gridx = 20;
		c.gridy = 20;
		pnlMiddle.add(btnSettings, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = -4;
		c.weighty = 1;
		c.gridx = 20;
		c.gridy = 40;

		pnlMiddle.add(btnTasks, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = -4;
		c.weighty = 1;
		c.gridx = 20;
		c.gridy = 60;
		pnlMiddle.add(btnRewards, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = -4;
		c.weighty = 1;
		c.gridx = 20;
		c.gridy = 80;
		pnlMiddle.add(btnHelpManual, c);

		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.YELLOW);

		this.add(pnlTop);
		this.add(pnlMiddle);
		this.add(pnlBottom);
	}

	/**
	 * Actions performed when clicking on task, settings, profile and rewards
	 * button.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTasks) {
			controller.setViewParentTaskWindow();
		}
		if (e.getSource() == btnSettings) {
			controller.setViewParentSettingsWindow();
		}
		if (e.getSource() == btnProfile) {
			controller.setViewParentProfileWindow();
		}
		if (e.getSource() == btnRewards) {
			controller.setViewParentRewardWindow();
		}
		if (e.getSource() == btnHelpManual) {
			controller.setViewHelpWindow();
		}
	}

}
