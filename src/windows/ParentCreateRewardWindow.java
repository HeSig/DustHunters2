package windows;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import profiles.Account;
import profiles.ChildProfile;

/**
 * 
 * @author dalvig
 *
 */

public class ParentCreateRewardWindow extends JPanel implements ActionListener {
	
	private JLabel lblTitle;
	
	private JButton btnHome = new JButton();
	private JButton btnProfile = new JButton();
	
	private Account account;
	private ChildProfile childProfile;
	private ClientController clientController;
	
	public ParentCreateRewardWindow(ClientController clientController) throws IOException {
		this.clientController = clientController;
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
		Border border3 = BorderFactory.createEtchedBorder();

	

	
		

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
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnHome ) {
			clientController.setViewParentHomeWindow();
		}
			else if (e.getSource() == btnProfile) {
				clientController.setViewParentProfileWindow();
			}
		
	}

}
