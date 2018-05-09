package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import tasks.Chore;
import tasks.Task;

public class ChildTaskWindow extends JPanel implements ActionListener {

	private JButton btnHome;
	private JButton btnDustSymbol;
	private JButton btnProfileSymbol;
	private JButton btnSaveChanges;
	private JLabel lblTask1;
	private JLabel lblAssigned;
	private JLabel lblChildName;
	private JLabel lblCheck;
	private JLabel lblHours;
	private JTextField tfHours;
	private JCheckBox cbCheckUncheck;
	private ImageIcon dustBallImage;
	private ImageIcon imageHome;
	private ImageIcon imageProfile;
	private DisplayWindow displayWindow;
	private JComboBox comboChooseChild; //New design for the assigned-function.
	private String[] childNames = {"MAIDA", "HENRIK", "ANGIE", "SARA", "KASPER"};

	private Task task;
	private Chore chore;

	public ChildTaskWindow(DisplayWindow displayWindow) throws IOException {
		this.displayWindow = displayWindow;
		start();
	}

	public void start() throws IOException {
		// TODO Auto-generated method stub

		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
	}

	public void InitializeGUI() throws IOException {
		// TODO Auto-generated method stub

		// Main
		Border border0 = BorderFactory.createTitledBorder("MainPanel");
		this.setBorder(border0);
		this.setBounds(6, 6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		// Top
		JPanel pnlTop = new JPanel();
		Border border1 = BorderFactory.createTitledBorder("TopPanel");
		pnlTop.setBorder(border1);
		pnlTop.setBounds(12, 17, 358, 90);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.WHITE);

		lblTask1 = new JLabel("Äventyr 1");
		lblTask1.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTask1.setBounds(140, 30, 285, 20);
		pnlTop.add(lblTask1);

		imageHome = new ImageIcon("images/House.jpg");
		btnHome = new JButton();
		btnHome.setBounds(10, 16, 75, 70);
		btnHome.setIcon(imageHome);
		pnlTop.add(btnHome);
		
		imageProfile = new ImageIcon("images/20x20Dammtuss.jpg");
		btnProfileSymbol = new JButton();
		btnProfileSymbol.setBounds(275, 16, 75, 70);
		btnProfileSymbol.setIcon(imageProfile);
		pnlTop.add(btnProfileSymbol);

		// Middle
		JPanel pnlMiddle = new JPanel();
		Border border2 = BorderFactory.createTitledBorder("MiddlePanel");
		pnlMiddle.setBorder(border2);
		pnlMiddle.setBounds(12, 130, 358, 140);
		pnlMiddle.setLayout(new GridBagLayout());
		pnlMiddle.setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();

		Border border3 = BorderFactory.createEtchedBorder();
		lblAssigned = new JLabel("               Äventyrsledare: ");
		lblAssigned.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblAssigned.setBorder(border3);

		comboChooseChild = new JComboBox(childNames);
		comboChooseChild.setSelectedIndex(1);
		comboChooseChild.setBorder(border3);

		lblCheck = new JLabel("               Äventyr är gjort: ");
		lblCheck.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblCheck.setBorder(border3);

		cbCheckUncheck = new JCheckBox();
		cbCheckUncheck.setBorder(border3);

		lblHours = new JLabel("                       Timmar: ");
		lblHours.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblHours.setBorder(border3);

		tfHours = new JTextField();
		tfHours.setBorder(border3);
		
		btnSaveChanges = new JButton("Spara");
		btnSaveChanges.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSaveChanges.setBorder(border3);
		btnSaveChanges.setBackground(Color.YELLOW);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		pnlMiddle.add(lblAssigned, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		pnlMiddle.add(comboChooseChild, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 7;
		c.weighty = 7;
		c.gridx = 0;
		c.gridy = 1;
		pnlMiddle.add(lblCheck, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 7;
		c.weighty = 7;
		c.gridx = 1;
		c.gridy = 1;
		pnlMiddle.add(cbCheckUncheck, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 400;
		c.weighty = 400;
		c.gridx = 0;
		c.gridy = 2;
		pnlMiddle.add(lblHours, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 400;
		c.weighty = 400;
		c.gridx = 1;
		c.gridy = 2;
		pnlMiddle.add(tfHours, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 400;
		c.weighty = 400;
		c.gridx = 1;
		c.gridy = 3;
		pnlMiddle.add(btnSaveChanges, c);
		
		
		
		// Bottom
		JPanel pnlBottom = new JPanel();
		Border border4 = BorderFactory.createTitledBorder("BottomPanel");
		pnlBottom.setBorder(border4);
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.WHITE);

		dustBallImage = new ImageIcon("images/NinjaReducedSize3.png");

		btnDustSymbol = new JButton();
		btnDustSymbol.setBounds(85, 13, 200, 160);
		btnDustSymbol.setIcon(dustBallImage);
		pnlBottom.add(btnDustSymbol);

		//ActionListeners
		cbCheckUncheck.addActionListener(this);
		btnDustSymbol.addActionListener(this);
		btnHome.addActionListener(this);
		btnProfileSymbol.addActionListener(this);
		comboChooseChild.addActionListener(this);
		
		
		
		this.add(pnlTop);
		this.add(pnlMiddle);
		this.add(pnlBottom);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Color color = null;
		if (cbCheckUncheck.isSelected()) {
			cbCheckUncheck.setBackground(Color.GREEN);
		} else {
			cbCheckUncheck.setBackground(null);
		}

		if (e.getSource() == btnDustSymbol) {
			// should open story page
		}
		
		if(e.getSource() == btnHome) {
			// should return the user to the the home-panel
		}
		
		if(e.getSource() == btnProfileSymbol) {
			displayWindow.setViewChildProfileWindow();
			// should direct the user to the profile-panel.  
		}
		
	}

//	public static void main(String[] args) throws IOException {
//		JFrame frame = new JFrame();
//		ChildTaskWindow taskwindow = new ChildTaskWindow(new DisplayWindow(null));
//		frame.add(taskwindow);
//		frame.pack();
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setMinimumSize(new Dimension(400, 600));
//	}
}
