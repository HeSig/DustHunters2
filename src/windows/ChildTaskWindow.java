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

/**
 * 
 * @author Angelina &........
 *
 */
public class ChildTaskWindow extends JPanel implements ActionListener {

	private JButton btnHome;
	private JButton btnDustSymbol;
	private JButton btnProfile;
	private JButton btnSave;
	private JLabel lblTitle;
	private JLabel lblTask;
	private JLabel lblChildName; // delete? - Angie
	private JLabel lblCheck;

	private JCheckBox cbCheckUncheck;
	private ImageIcon dustBallImage;
	private ImageIcon imageHome;
	private ImageIcon imageProfile;
	private ClientController controller;
	private JComboBox comboChore; // New design for the assigned-function.
	private String[] choreList = { "Dammsuga i hallen", "Damma i vardagsrummet", "Gå ut med hunden", "Moppa golvet",
			"Laga middag" };
	private Task task;
	private Chore chore;

	public ChildTaskWindow(ClientController clientController) throws IOException {
		this.controller = clientController;
		start();
	}

	public void start() throws IOException {

		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);

		InitializeGUI();
		this.setVisible(true);
		lblTask.setOpaque(true);
		lblCheck.setOpaque(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void InitializeGUI() throws IOException {
		// TODO Auto-generated method stub

		// Main
		this.setBounds(6, 6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		// Top
		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 90);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);

		lblTitle = new JLabel("Äventyr");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setBounds(140, 30, 285, 20);
		pnlTop.add(lblTitle);

		imageHome = new ImageIcon("images/House.jpg");
		btnHome = new JButton();
		btnHome.setBounds(10, 16, 75, 70);
		btnHome.setIcon(imageHome);
		pnlTop.add(btnHome);

		imageProfile = new ImageIcon("images/20x20Dammtuss.jpg");
		btnProfile = new JButton();
		btnProfile.setBounds(275, 16, 75, 70);
		btnProfile.setIcon(imageProfile);
		pnlTop.add(btnProfile);

		// Middle
		JPanel pnlMiddle = new JPanel();
		pnlMiddle.setBounds(12, 130, 358, 140);
		pnlMiddle.setBackground(Color.YELLOW);
		pnlMiddle.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		Border border3 = BorderFactory.createEtchedBorder();
		lblTask = new JLabel("               Äventyr: ");
		lblTask.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblTask.setBorder(border3);

		comboChore = new JComboBox(choreList);
		comboChore.setSelectedIndex(1);
		comboChore.setBorder(border3);

		lblCheck = new JLabel("               Äventyr är avklarat: ");
		lblCheck.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblCheck.setBorder(border3);

		cbCheckUncheck = new JCheckBox();
		cbCheckUncheck.setBorder(border3);

		btnSave = new JButton("Spara");
		btnSave.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSave.setBorder(border3);
		btnSave.setBackground(Color.GREEN);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		pnlMiddle.add(lblTask, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		pnlMiddle.add(comboChore, c);

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
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 400;
		c.weighty = 400;
		c.gridx = 1;
		c.gridy = 3;
		pnlMiddle.add(btnSave, c);

		// Bottom
		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.YELLOW);

		dustBallImage = new ImageIcon("images/NinjaReducedSize3.png");

		btnDustSymbol = new JButton();
		btnDustSymbol.setBounds(85, 13, 200, 160);
		btnDustSymbol.setIcon(dustBallImage);
		pnlBottom.add(btnDustSymbol);

		// ActionListeners
		cbCheckUncheck.addActionListener(this);
		btnDustSymbol.addActionListener(this);
		btnHome.addActionListener(this);
		btnProfile.addActionListener(this);
		comboChore.addActionListener(this);

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
			// När barnet trycker på isChecked så ska klienten skicka den aktuella tasken
			// till klienten för att sedan registrera den som "färdig".
			
			//HÄR <----------------------------------------------------------------------------> HÄR
			
			//controller.setTaskAsCompleted(task);
			
		} else {
			cbCheckUncheck.setBackground(null);
		}

		if (e.getSource() == btnDustSymbol) {
			// should open story page
		}

		if (e.getSource() == btnHome) {
			controller.setViewChildHomeWindow();
			// should return the user to the the home-panel
		}

		if (e.getSource() == btnProfile) {
			controller.setViewChildProfileWindow();
			// should direct the user to the profile-panel.
		}

	}

}
