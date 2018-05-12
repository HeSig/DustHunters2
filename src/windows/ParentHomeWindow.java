package windows;

import java.awt.*;
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

/*
 * KLAR! DET som ska göras är: Mellanrum mellan btn:s, och att fixa actionlisteners
 * author: Angelina Fransson
 */
public class ParentHomeWindow extends JPanel implements ActionListener{
	private Account account; 
	private ParentProfile parentProfile;

	private JButton btnSettings;
	private JButton btnChores;
	private JButton btnRewards;
	private JButton btnHelpManual;
	private JLabel lblHome; 
	private JButton btnProfileSymbol;
	private ImageIcon imageProfile;
	private ClientController clientController;
	private ActionListener listener;

	public ParentHomeWindow (ClientController clientController) {
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
	public ParentProfile getParentProfile () {
		return parentProfile; 
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
		btnProfileSymbol = new JButton();
		btnProfileSymbol.addActionListener(this);
		btnProfileSymbol.setBounds(275, 16, 75, 70);
		btnProfileSymbol.setIcon(imageProfile);
		pnlTop.add(btnProfileSymbol);
		

		JPanel pnlMiddle = new JPanel();
		pnlMiddle.setBounds(12, 180, 358, 140);
		pnlMiddle.setLayout(new GridBagLayout());
		pnlMiddle.setBackground(Color.YELLOW);
		GridBagConstraints c = new GridBagConstraints();


		btnSettings = new JButton("Inställningar");
		btnSettings.addActionListener(this);
		btnSettings.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnSettings.setBounds(1, 16, 90, 50);

		
		btnChores = new JButton ("Sysslor");
		btnChores.addActionListener(this);
		btnChores.setFont(new Font ("SansSerif", Font.PLAIN, 14));
		btnChores.setBounds(40, 16, 90, 50);
		pnlMiddle.add (btnChores);

		btnRewards = new JButton ("Belöningar");
		btnRewards.addActionListener(this);
		btnRewards.setFont(new Font ("SansSerif", Font.PLAIN, 14));
		btnRewards.setBounds(80, 16, 90, 50);
		pnlMiddle.add (btnRewards);

		btnHelpManual = new JButton ("Hjälp/Manual");
		btnHelpManual.addActionListener(this);
		btnHelpManual.setFont(new Font ("SansSerif", Font.PLAIN, 14));
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

		pnlMiddle.add(btnChores, c);

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



	public static void main (String [] args) {
		JFrame frame = new JFrame ();
//		ParentHomeWindow phw = new ParentHomeWindow ();
//		frame.add(phw);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension (400,600));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnChores) {
			clientController.setViewParentTaskWindow();
		}
		if(e.getSource() == btnSettings) {
			clientController.setViewParentSettingsWindow();
		}
		if(e.getSource() == btnProfileSymbol) {
			clientController.setViewParentProfileWindow();
		}
		if(e.getSource() == btnRewards) {
			clientController.setViewParentRewardWindow();
		}
	}	

}
