package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import profiles.Account;
import profiles.ParentProfile;

/**
 * A GUI class that shows the panel where the Parent Profile can see the their children's profiles.
 * From this class you can reach parent home, AddChild, and ChildProfile GUI through actionListeners.
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
	private ClientController controller;
/**
 * Constructor. Constructs the GUI. 
 * @param clientController
 */
	public ParentProfileWindow(ClientController clientController) {
		this.controller = clientController;
		start();
	}
/**
 * setters and getters for Account and ParentProfile
 */
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
 * Makes the GUI visible and sets bounds for the main panel. 
 */
	private void start() {
		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
	}
	/**
	 * The GUI.
	 */

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
		dammtussParentProfile = (new ImageIcon(controller.getPictures().getImage(controller.getParentProfile().getImageString())));
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

		btnAddChild = new JButton(" Lägg till ett barn ");
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


	@Override
	/**
	 * Actions performed when clicking on home, addChild, ChildProfile and Profile button. 
	 */

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnHome) {
			controller.setViewParentHomeWindow();
		}
		if (e.getSource() == btnAddChild) {
			controller.setViewAddChildWindow();
		}
	
		if (e.getSource() == btnChildProfile) {
			//gör ett window där man kan se namn + lösenord tydligare, alternativt ta bort JButton och ha det som en bild. Denna kan fungera som delete/edit profile
		}
		if (e.getSource() == btnProfile) {
			//gör ett window där man kan se namn + lösenord tydligare, alternativt ta bort JButton och ha det som en bild. Denna kan fungera som delete/edit profile
		}
	}
}
