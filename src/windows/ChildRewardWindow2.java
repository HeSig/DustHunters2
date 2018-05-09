package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import profiles.Account;
import profiles.ChildProfile;

/** 
 * A panel that children users will see when they want to view their
 * potential rewards. The rewards are shown as buttons displaying a 
 * picture representing the reward and a large red number, which indicates the
 * amount of points needed to choose the reward. The buttons will
 * be disabled until the children have gathered the necessary amount
 * of points. 
 * 
 * @author dalvig
 *
 */

public class ChildRewardWindow2 extends JPanel implements ActionListener {

	
	private JLabel lblTitle;
	private JLabel lblPTitle;
	private JLabel lblPoints;
	private JButton btnHome = new JButton();
	private JButton btnProfile = new JButton();
	private JButton btnBeach = new JButton();
	private JButton btnCandy = new JButton();
	private JButton btnCinema = new JButton();
	private JProgressBar pbar = new JProgressBar();
	private int childsPoints; // Amount of points a child has accumulated through completing chores. To be used in the progress bar to visualize how they are doing.
	
	private Account account;
	private ChildProfile childProfile;
	private ClientController displayWindow;

	public ChildRewardWindow2(ClientController displayWindow) throws IOException {
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

		lblTitle = new JLabel("Skatter i sikt");
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

		lblPTitle = new JLabel(" Poäng: ");
		lblPTitle.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblPTitle.setBorder(border3);
		lblPoints = new JLabel("55");
		lblPoints.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPoints.setForeground(Color.RED);
		pbar = new JProgressBar();
		
	
		
		pnlBottom.add(lblPTitle);
		pnlBottom.add(pbar);
		pnlBottom.add(lblPoints);

		// Adds the three panels to the main panel
		this.add(pnlTop);
		this.add(pnlMiddle);
		this.add(pnlBottom);
		
		
		// Adds all action listeners
		btnHome.addActionListener(this);
		btnBeach.addActionListener(this);
		btnCandy.addActionListener(this);
		btnCinema.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnHome) {
			displayWindow.setViewChildTaskWindow();

		} else if (e.getSource() == btnProfile) {
			displayWindow.setViewChildProfileWindow();

		} else if (e.getSource() == btnBeach) {

		} else if (e.getSource() == btnCandy) {

		} else if (e.getSource() == btnCinema) {

		}

	}

	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		ChildRewardWindow2 childRWindow = new ChildRewardWindow2(null);
		frame.add(childRWindow);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(400, 600));
	}
}
