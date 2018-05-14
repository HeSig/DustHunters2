package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import profiles.Account;
import profiles.ParentProfile;

/**
 * A panel that is reached when a user clicks the button "Inställningar" on
 * ParentHomeWindow. Here the user (parent) can edit his/her details: username
 * and password.
 * 
 * @author dalvig
 *
 */
public class ParentSettingsWindow extends JPanel implements ActionListener {

	private JLabel lblTitle;
	private JLabel lblParentName;
	private JLabel lblParentPassword;
	private JLabel lblParentPassRepeat;
	private JTextField txtParentName;
	private JTextField txtParentPassword;
	private JTextField txtParentPassRepeat;
	private JButton btnHome = new JButton();
	private JButton btnSave = new JButton();
	private JButton btnCancel = new JButton();
	private JButton btnProfile = new JButton();
	private JButton btnProfilePic = new JButton();

	private Account account;
	private ParentProfile parentProfile;
	private ClientController clientController;

	public ParentSettingsWindow(ClientController clientController) throws IOException {
		this.clientController = clientController;
		start();
	}

	public Account getAccount() {
		return account;
	}

	public ParentProfile getParentProfile() {
		return parentProfile;
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

		lblTitle = new JLabel("Ändra din info");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setBounds(110, 30, 285, 30);
		btnHome.setIcon(new ImageIcon("images/house.jpg"));
		btnHome.setBounds(5, 5, 75, 70);
		btnProfile.setIcon(new ImageIcon("images/20x20Dammtuss.jpg"));
		btnProfile.setBounds(275, 16, 75, 70);

		pnlTop.add(btnHome);
		pnlTop.add(lblTitle);
		pnlTop.add(btnProfile);

		// Middle-Upper Panel
		JPanel pnlMiddle1 = new JPanel();

		pnlMiddle1.setBounds(12, 100, 358, 130);
		pnlMiddle1.setLayout(new FlowLayout());
		pnlMiddle1.setBackground(Color.YELLOW);

		btnProfilePic.setIcon(new ImageIcon("images/20x20Dammtuss.jpg"));
		btnProfilePic.setBounds(10, 10, 10, 10);
		btnProfilePic.setEnabled(true);
		btnProfilePic.addActionListener(this);

		pnlMiddle1.add(btnProfilePic);

		// Middle-Lower Panel
		JPanel pnlMiddle2 = new JPanel();

		pnlMiddle2.setBounds(12, 240, 358, 180);
		pnlMiddle2.setLayout(new GridLayout(3, 2));
		pnlMiddle2.setBackground(Color.YELLOW);

		lblParentName = new JLabel("Ditt namn: ");
		lblParentName.setFont(new Font("SansSerif", Font.BOLD, 12));

		lblParentPassword = new JLabel("Ditt lösenord: ");
		lblParentPassword.setFont(new Font("SansSerif", Font.BOLD, 12));

		lblParentPassRepeat = new JLabel("Upprepa ditt lösenord: ");
		lblParentPassRepeat.setFont(new Font("SansSerif", Font.BOLD, 12));

		txtParentName = new JTextField("Momma Bear");
		txtParentPassword = new JTextField();
		txtParentPassRepeat = new JTextField();

		pnlMiddle2.add(lblParentName);
		pnlMiddle2.add(txtParentName);
		pnlMiddle2.add(lblParentPassword);
		pnlMiddle2.add(txtParentPassword);
		pnlMiddle2.add(lblParentPassRepeat);
		pnlMiddle2.add(txtParentPassRepeat);

		
		// Bottom Panel
		JPanel pnlBottom = new JPanel();

		pnlBottom.setBounds(12, 470, 358, 100);
		pnlBottom.setLayout(new FlowLayout());
		pnlBottom.setBackground(Color.YELLOW);

		btnSave = new JButton("Spara");
		btnSave.setBounds(10, 10, 10, 10);
		btnSave.setBackground(Color.GREEN);
		btnSave.setForeground(Color.BLACK);

		btnCancel = new JButton("Avsluta");
		btnCancel.setBounds(100, 200, 250, 200);
		btnCancel.setBackground(Color.RED);
		btnCancel.setForeground(Color.BLACK);

		pnlBottom.add(btnSave);
		pnlBottom.add(btnCancel);

		this.add(pnlTop);
		this.add(pnlMiddle1);
		this.add(pnlMiddle2);
		this.add(pnlBottom);

		// Add all action listeners
		btnHome.addActionListener(this);
		btnProfile.addActionListener(this);
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnHome) {
			clientController.setViewParentHomeWindow();

		} else if (e.getSource() == btnProfile) {
			clientController.setViewParentProfileWindow();

		} else if (e.getSource() == btnSave) {

		} else if (e.getSource() == btnCancel) {

		}

	}

//	public static void main(String[] args) throws IOException {
//		JFrame frame = new JFrame();
//		ParentSettingsWindow parentSettings = new ParentSettingsWindow(null);
//		frame.add(parentSettings);
//		frame.pack();
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setMinimumSize(new Dimension(400, 600));
//	}
}
