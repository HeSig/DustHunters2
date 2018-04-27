package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import profiles.Account;
import profiles.ChildProfile;
import tasks.Chore;
import tasks.Task;

public class ChildRewardWindow2 extends JPanel implements ActionListener {

	private JButton btnHome;
	private JButton btnDustSymbol = new JButton();
	private JFrame frame;
	private JLabel lblReward1;
	private JLabel lblChildName;
	private JLabel lblPoints;
	private JButton btnBeach = new JButton();
	private JButton btnCandy = new JButton();
	private JButton btnCinema = new JButton();



	private Account account;
	private ChildProfile childProfile;
	private int rewardPoints;
	private ImageIcon beach;
	private ImageIcon rewardActivity;
	private JLabel lblTitle;


	public ChildRewardWindow2() {
		start();
	}

	public void start() {
		// TODO Auto-generated method stub

		frame = new JFrame();
		frame.setBounds(0, 0, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle(" Reward Window ");
		InitializeGUI();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}

	public void InitializeGUI() {
		// TODO Auto-generated method stub

		// Main
		JPanel pnlMain = new JPanel();
		Border border0 = BorderFactory.createTitledBorder("MainPanel");
		pnlMain.setBorder(border0);
		pnlMain.setBounds(6, 6, 381, 500);
		pnlMain.setLayout(null);
		pnlMain.setBackground(Color.YELLOW);

		// Top
		JPanel pnlTop = new JPanel();
		Border border1 = BorderFactory.createTitledBorder("");
		pnlTop.setBorder(border1);
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.WHITE);

		lblTitle = new JLabel("Möjliga Belöningar ");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setBounds(140, 30, 285, 20);
		pnlTop.add(lblTitle);

		btnHome = new JButton(" Hem ");
		btnHome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnHome.setBounds(10, 16, 90, 50);
		pnlTop.add(btnHome);

		// Middle Panel 
		JPanel pnlInfo = new JPanel();
		Border border2 = BorderFactory.createTitledBorder("");
		pnlInfo.setBorder(border2);
		pnlInfo.setBounds(12, 100, 358, 260);
		pnlInfo.setLayout(new FlowLayout());
		pnlInfo.setBackground(Color.WHITE);
		

		Border border3 = BorderFactory.createEtchedBorder();

		
		btnBeach.setIcon(new ImageIcon("images/beach.jpg"));
		btnBeach.setBounds(10, 10, 10, 10);
		pnlInfo.add(btnBeach);
		
		btnCandy.setIcon(new ImageIcon("images/candy.jpg"));
		btnCandy.setBounds(10, 10, 10, 10);
		pnlInfo.add(btnCandy);
		
		btnCinema.setIcon(new ImageIcon("images/cinema.jpg"));
		btnCinema.setBounds(10, 10, 10, 10);
		pnlInfo.add(btnCinema);

		//Bottom Panel

		JPanel pnlBottom = new JPanel();
		Border border4 = BorderFactory.createTitledBorder("BottomPanel");
		pnlBottom.setBorder(border4);
		pnlBottom.setBounds(12, 360, 358, 120);
		pnlBottom.setLayout(new FlowLayout());
		
		pnlBottom.setBackground(Color.WHITE);


		
		lblPoints = new JLabel(" Sara Poäng: ");
		lblPoints.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblPoints.setBorder(border3);
		pnlBottom.add(lblPoints);
		
		

		pnlMain.add(pnlTop);
		pnlMain.add(pnlInfo);
		pnlMain.add(pnlBottom);
		frame.add(pnlMain);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub


	}

	public static void main(String[] args) {
		ChildRewardWindow2 childReward = new ChildRewardWindow2();
	}
}
