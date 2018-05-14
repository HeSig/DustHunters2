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
import profiles.ChildProfile;
import profiles.ParentProfile;
/**
 * 
 * @author Angelina
 *
 */
public class ChildHomeWindow extends JPanel implements ActionListener{
	private Account account; 
	private ChildProfile childProfile;

	private JButton btnMyChores;
	private JButton btnMyRewards;
	private JLabel lblHome; 
	private JButton btnProfile;
	private ImageIcon imageProfile;
	private ClientController clientController;

	public ChildHomeWindow (ClientController clientController) {
		this.clientController = clientController;
		start();

	}

	private void start() {
		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);

	}
	public Account getAccount () {
		return account;
	}
	public ChildProfile getChildProfile () {
		return childProfile; 
	}
	private void InitializeGUI() {

		this.setBounds(6,6, 381, 500);
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
		
		
		imageProfile = new ImageIcon("images/20x20Dammtuss.jpg");
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


		btnMyChores = new JButton("Mina sysslor");
		btnMyChores.addActionListener(this);
		btnMyChores.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnMyChores.setBounds(1, 16, 90, 50);
		pnlMiddle.add(btnMyChores);

		
		btnMyRewards = new JButton ("Mina belöningar");
		btnMyRewards.addActionListener(this);
		btnMyRewards.setFont(new Font ("SansSerif", Font.PLAIN, 14));
		btnMyRewards.setBounds(80, 16, 90, 50);
		pnlMiddle.add (btnMyRewards);

	
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = -4;
		c.weighty = 1;
		c.gridx = 20; 
		c.gridy = 20; 
		pnlMiddle.add(btnMyChores, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = -4;
		c.weighty = 1;
		c.gridx = 20; 
		c.gridy = 60; 

		pnlMiddle.add(btnMyRewards, c);

		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.YELLOW);

		this.add(pnlTop);
		this.add(pnlMiddle);
		this.add(pnlBottom);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnMyRewards) {
			clientController.setViewChildRewardWindow2();
		}
		if(e.getSource() == btnMyChores) {
			clientController.setViewChildProfileWindow();
		}
		if(e.getSource() == btnProfile) {
			clientController.setViewChildProfileWindow();
		}
	}	

}
