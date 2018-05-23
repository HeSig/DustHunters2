package windows;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import profiles.Account;
import profiles.ChildProfile;

/**
 * A panel that adult users will see when they click "Ny Belöning" (New Reward)
 * in the point-viewing-window. The adult user will be able to choose to active
 * rewards, which have been created by the developers. The rewards are shown as
 * pictures with a number on them, which represents the amount of points needed
 * for a child to claim the reward. When the parents choose to activate a
 * reward, it will become visible on a child users reward window.
 * 
 * @author dalvig
 *
 */

public class ParentCreateRewardWindow extends JPanel implements ActionListener {

	private JLabel lblTitle;

	private JButton btnHome = new JButton();
	private JButton btnProfile = new JButton();
	private JButton btnCandy = new JButton();
	private JButton btnBeach = new JButton();
	private JButton btnCinema = new JButton();

	private Account account;
	private ChildProfile childProfile;
	private ClientController controller;

	public ParentCreateRewardWindow(ClientController clientController) throws IOException {
		this.setClientController(clientController);
		start();
	}

	public Account getAccount() {
		return account;
	}

	public ChildProfile getChildProfile() {
		return childProfile;
	}

	public void start() throws IOException {

		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
	}

	public void InitializeGUI() throws IOException {

		// Main Panel
		this.setBounds(6, 6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		// Top Panel
		JPanel pnlTop = new JPanel();

		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);

		lblTitle = new JLabel("Skapa belöning");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setBounds(120, 30, 285, 20);
		btnHome.setIcon(new ImageIcon("images/House.jpg"));
		btnHome.setBounds(5, 5, 80, 65);
		btnProfile.setIcon(new ImageIcon("images/20x20Dammtuss.jpg"));
		btnProfile.setBounds(260, 16, 90, 50);

		pnlTop.add(btnHome);
		pnlTop.add(lblTitle);
		pnlTop.add(btnProfile);

		// Middle Panel
		JPanel pnlMiddle = new JPanel();

		pnlMiddle.setBounds(12, 130, 358, 280);
		pnlMiddle.setLayout(new FlowLayout());
		pnlMiddle.setBackground(Color.YELLOW);

		btnCandy.setIcon(new ImageIcon("images/candy.jpg"));
		btnCandy.setBounds(10, 10, 10, 10);
		btnCandy.setEnabled(true);

		btnBeach.setIcon(new ImageIcon("images/beach.jpg"));
		btnBeach.setBounds(10, 10, 10, 10);
		btnBeach.setEnabled(true);

		btnCinema.setIcon(new ImageIcon("images/cinema.png"));
		btnCinema.setBounds(10, 10, 10, 10);
		btnCinema.setEnabled(false);

		pnlMiddle.add(btnCandy);
		pnlMiddle.add(btnBeach);
		pnlMiddle.add(btnCinema);

		// Bottom Panel
		JPanel pnlBottom = new JPanel();

		pnlBottom.setBounds(12, 430, 358, 120);
		pnlBottom.setLayout(new FlowLayout());
		pnlBottom.setBackground(Color.YELLOW);

		// Adds the three panels to the main panel
		this.add(pnlTop);
		this.add(pnlMiddle);
		this.add(pnlBottom);

		// Adds all action listeners
		btnHome.addActionListener(this);
		btnProfile.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnHome) {
			controller.setViewParentHomeWindow();
		} else if (e.getSource() == btnProfile) {
			controller.setViewParentProfileWindow();
		}

	}

	public ClientController getClientController() {
		return controller;
	}

	public void setClientController(ClientController clientController) {
		this.controller = clientController;
	}
}
