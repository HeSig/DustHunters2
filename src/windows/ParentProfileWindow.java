package windows;

import java.awt.Color;
import java.awt.Dimension;
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
import profiles.ParentProfile;

/**
 * KLAR F�R HENRIK ATT PILLA I! Hit kommer man om man trycker p� profilknappen.
 * 
 * Trycker man p� de olika dammtussarna ska man komma till deras inst�llningar.
 * 
 * @author Angelina Fransson
 *
 */

@SuppressWarnings("serial")
public class ParentProfileWindow extends JPanel implements ActionListener {
	private Account account;
	private ParentProfile parentProfile;
	private JLabel lblProfile;

	private JButton btnHome;
	private JButton btnAddChild;
	private JButton btnChildProfile;
	private JButton btnProfile;
	private ImageIcon dammtussParentProfile;
	private ImageIcon dammtussMaja;
	private ClientController clientController;

	public ParentProfileWindow(ClientController clientController) {
		this.clientController = clientController;
		start();
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
	public void setBtnHome (JButton btnHome) {
		this.btnHome = btnHome;
	}

	private void start() {
		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
	}

	private void InitializeGUI() {

		this.setBounds(6, 6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);

		lblProfile = new JLabel("Mitt Crew");
		lblProfile.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblProfile.setBounds(105, 30, 285, 20);
		pnlTop.add(lblProfile);
		
		btnHome = new JButton();
		btnHome.setIcon(new ImageIcon("images/House.jpg"));
		btnHome.setBounds(5, 5, 75, 70);
		btnHome.addActionListener(this);
		pnlTop.add(btnHome);

		JPanel pnlMiddle = new JPanel();
		pnlMiddle.setBounds(12, 130, 358, 140);
		pnlMiddle.setLayout(new GridBagLayout());
		pnlMiddle.setBackground(Color.YELLOW);
		GridBagConstraints c = new GridBagConstraints();

		btnProfile = new JButton();
		btnProfile.addActionListener(this);
		dammtussParentProfile = new ImageIcon("images/dammtussParentProfile.png");
		btnProfile.setBounds(275, 16, 75, 70);
		btnProfile.setIcon(dammtussParentProfile);

		pnlMiddle.add(btnProfile);

		btnChildProfile = new JButton();
		btnChildProfile.addActionListener(this);
		dammtussMaja = new ImageIcon("images/dammtussMaja.png");
		btnChildProfile.setBounds(350, 100, 90, 100);
		btnChildProfile.setIcon(dammtussMaja);
		pnlMiddle.add(btnChildProfile);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 20;
		c.gridy = 100;
		pnlMiddle.add(btnProfile, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 100;
		c.gridy = 100;

		pnlMiddle.add(btnChildProfile, c);

		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 400, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.YELLOW);

		btnAddChild = new JButton(" L�gg till ett barn ");
		btnAddChild.addActionListener(this);
		btnAddChild.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnAddChild.setBackground(Color.GREEN);
		btnAddChild.setForeground(Color.BLACK);
		btnAddChild.setBounds(10, 16, 300, 50);
		pnlBottom.add(btnAddChild);

		this.add(pnlTop);
		this.add(pnlMiddle);
		this.add(pnlBottom);
	}

//	 public static void main (String [] args) {
//	 JFrame frame = new JFrame ();
//	 ParentProfileWindow ppw = new ParentProfileWindow ();
//	 frame.add(ppw);
//	 frame.pack();
//	 frame.setVisible(true);
//	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	 frame.setMinimumSize(new Dimension (400,600));
//	 }
	@Override

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnHome) {
			clientController.setViewParentHomeWindow();
		}
		if (e.getSource() == btnAddChild) {
			clientController.setViewAddChildWindow();
		}
	
		if (e.getSource() == btnChildProfile) {
			//g�r ett window d�r man kan se namn + l�senord tydligare, alternativt ta bort JButton och ha det som en bild. Denna kan fungera som delete/edit profile
		}
		if (e.getSource() == btnProfile) {
			//g�r ett window d�r man kan se namn + l�senord tydligare, alternativt ta bort JButton och ha det som en bild. Denna kan fungera som delete/edit profile
		}
	}
}
