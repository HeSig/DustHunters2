package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class ChildRewardWindow2 extends JPanel implements ActionListener {

	private JButton btnHome = new JButton();
	private JFrame frame;
	private JLabel lblTitle;
	private JLabel lblPTitle;
	private JLabel lblPoints;
	private JButton btnBeach = new JButton();
	private JButton btnCandy = new JButton();
	private JButton btnCinema = new JButton();
	private JProgressBar pbar = new JProgressBar();


	private Account account;
	private ChildProfile childProfile;
	private int rewardPoints;
	private JButton getSource;
	


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
		pnlTop.setBackground(Color.YELLOW);

		lblTitle = new JLabel("Skatter i sikt");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setBounds(140, 30, 285, 20);
		pnlTop.add(lblTitle);

		btnHome.setIcon(new ImageIcon("images/home.png"));
		btnHome.setBounds(5, 5, 80, 65);
		pnlTop.add(btnHome);

		// Middle Panel 
		JPanel pnlMiddle = new JPanel();
		Border border2 = BorderFactory.createTitledBorder("");
		pnlMiddle.setBorder(border2);
		pnlMiddle.setBounds(12, 100, 358, 260);
		pnlMiddle.setLayout(new FlowLayout());
		pnlMiddle.setBackground(Color.YELLOW);
		

		Border border3 = BorderFactory.createEtchedBorder();

		
		btnBeach.setIcon(new ImageIcon("images/beach.jpg"));
		btnBeach.setBounds(10, 10, 10, 10);
		pnlMiddle.add(btnBeach);
		
		btnCandy.setIcon(new ImageIcon("images/candy.jpg"));
		btnCandy.setBounds(10, 10, 10, 10);
		pnlMiddle.add(btnCandy);
		
		btnCinema.setIcon(new ImageIcon("images/cinema.png"));
		btnCinema.setBounds(10, 10, 10, 10);
		pnlMiddle.add(btnCinema);

		//Bottom Panel

		JPanel pnlBottom = new JPanel();
		Border border4 = BorderFactory.createTitledBorder("BottomPanel");
		pnlBottom.setBorder(border4);
		pnlBottom.setBounds(12, 360, 358, 120);
		pnlBottom.setLayout(new FlowLayout());
		pnlBottom.setBackground(Color.YELLOW);


		
		lblPTitle = new JLabel(" Poäng: ");
		lblPTitle.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblPTitle.setBorder(border3);
		lblPoints = new JLabel("30");
		lblPoints.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPoints.setForeground(Color.RED);
		pbar = new JProgressBar();
		btnHome.addActionListener(this);
		btnBeach.addActionListener(this);
		btnCandy.addActionListener(this);
		btnCinema.addActionListener(this);
		
		pnlBottom.add(lblPTitle);
		pnlBottom.add(pbar);
		pnlBottom.add(lblPoints);
		
		pnlMain.add(pnlTop);
		pnlMain.add(pnlMiddle);
		pnlMain.add(pnlBottom);
		frame.add(pnlMain);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
			if (this.getSource == btnHome) {
				
			} else if (this.getSource == btnBeach) {
				
			}
			
	}

	public static void main(String[] args) {
		ChildRewardWindow2 childReward = new ChildRewardWindow2();
	}
}
