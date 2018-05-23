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
 * 
 * @author Maida
 *
 * 23/5: Git strulat hela dan. Ominstallerat flera gånger. Git ballade ur. Check-check
 */

public class ChildProfileWindow extends JPanel implements ActionListener {

	private JLabel lblTitle;
	private JButton btnHome = new JButton();
	private JLabel lblProfilePic;
	private JLabel lblUserName;
	private JLabel lblPassword;
	
	private String childUserName;
	private String childPassword;

	private Account account;
	private ChildProfile childProfile;
	private ClientController controller;

	public ChildProfileWindow(ClientController clientController) throws IOException {
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

		lblTitle = new JLabel(" Din Damm-Profil ");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setBounds(120, 30, 285, 20);
		btnHome.setIcon(new ImageIcon("images/House.jpg"));
		btnHome.setBounds(5, 5, 80, 65);

		pnlTop.add(btnHome);
		pnlTop.add(lblTitle);

		// Middle Panel
		JPanel pnlMiddle = new JPanel();

		pnlMiddle.setBounds(12, 130, 358, 280);
		pnlMiddle.setLayout(new FlowLayout());
		pnlMiddle.setBackground(Color.YELLOW);
		
		lblProfilePic = new JLabel();
		lblProfilePic.setBounds(300, 16, 90, 15);
		lblProfilePic.setIcon(new ImageIcon(controller.getPictures().getImage(controller.getChildProfile().getImageString())));
		pnlMiddle.add(lblProfilePic);
		
		
		// Bottom Panel
		JPanel pnlBottom = new JPanel();

//clientcontroller.getChildProfile().getName
		
		pnlBottom.setBounds(12, 430, 358, 120);
		pnlBottom.setLayout(new FlowLayout());
		pnlBottom.setBackground(Color.YELLOW);
		
		lblUserName = new JLabel("Användarnamn: " + getClientController().getChildProfile().getName()); 
		lblUserName.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblUserName.setBounds(1, 10, 90, 50); //1, 10, 90, 50
		pnlBottom.add(lblUserName);
		
		lblPassword = new JLabel("Lösenord: " + getClientController().getChildProfile().get; 
		lblPassword.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblUserName.setBounds(31, 16, 90, 50); //1, 16, 90, 50
		pnlBottom.add(lblPassword);

		// Adds the three panels to the main panel
		this.add(pnlTop);
		this.add(pnlMiddle);
		this.add(pnlBottom);

		// Adds all action listeners
		btnHome.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnHome) {
			controller.setViewChildHomeWindow();

		}
	}

	public ClientController getClientController() {
		return controller;
	}

	public void setClientController(ClientController clientController) {
		this.controller = clientController;
	}

}
