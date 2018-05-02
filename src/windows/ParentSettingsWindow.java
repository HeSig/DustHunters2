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
import profiles.ChildProfile;

/**
 * 
 * @author dalvig
 *
 */
public class ParentSettingsWindow extends JPanel implements ActionListener {
	
	private JButton btnHome = new JButton();
	private JLabel lblTitle;
	private JLabel lblChildName;
	private JLabel lblChildPassword;
	private JLabel lblChildPassRepeat;
	private JTextField txtChildName;
	private JTextField txtChildPassword;
	private JTextField txtChildPassRepeat;
	private JButton btnSave = new JButton();
	private JButton btnCancel = new JButton();
	private JButton btnProfile = new JButton();
	private JButton btnProfilePic = new JButton();
	

	private Account account;
	private ChildProfile childProfile;
	private DisplayWindow displayWindow;

	public ParentSettingsWindow(DisplayWindow displayWindow) throws IOException {
		this.displayWindow = displayWindow;
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

		lblTitle = new JLabel("L�gg till unge");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setBounds(120, 30, 285, 30);
		btnHome.setIcon(new ImageIcon("images/house.jpg"));
		btnHome.setBounds(5, 5, 80, 65);
		btnProfile.setIcon(new ImageIcon("images/20x20Dammtuss.jpg"));
		btnProfile.setBounds(260, 16, 90, 50);

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
		pnlMiddle2.setLayout(new GridLayout(3,2));
		pnlMiddle2.setBackground(Color.YELLOW);

		
		lblChildName = new JLabel("Namn: ");
		lblChildName.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		
		lblChildPassword = new JLabel("L�senord: ");
		lblChildPassword.setFont(new Font("SansSerif", Font.BOLD, 12));
	
		
		lblChildPassRepeat = new JLabel("Upprepa l�senord: ");
		lblChildPassRepeat.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		txtChildName = new JTextField();
		txtChildPassword = new JTextField();
		txtChildPassRepeat = new JTextField();
		
		
		pnlMiddle2.add(lblChildName);
		pnlMiddle2.add(txtChildName);
		pnlMiddle2.add(lblChildPassword);
		pnlMiddle2.add(txtChildPassword);
		pnlMiddle2.add(lblChildPassRepeat);
		pnlMiddle2.add(txtChildPassRepeat);
		
	

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
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnHome) {
			displayWindow.setViewChildTaskWindow();

		} else if (e.getSource() == btnProfile) {
			displayWindow.setViewChildProfileWindow();

		} else if (e.getSource() == btnProfilePic) {

		} 

	}

	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		ParentSettingsWindow parentSettings = new ParentSettingsWindow(null);
		frame.add(parentSettings);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(400, 600));
	}
}




