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
//	private JFrame frame;
	private JLabel lblTask1;
	private JLabel lblAssigned;
	private JLabel lblChildName;
	private JLabel lblCheck;
	private JLabel lblHours;
	private JTextField tfHours;
	private JCheckBox cbCheckUncheck;
	private ImageIcon dustBallImage;

	private Task task;
	private Chore chore;

	//HEJEJEJEJEJEJEHEJ
	// private ImageIcon dustIcon = new ImageIcon("images/"

	// private JMenuBar menuBar = new JMenuBar();
	// private List<Task> taskList;

	public ChildTaskWindow() throws IOException {
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
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.WHITE);

		lblTask1 = new JLabel("Syssla 1 ");
		lblTask1.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTask1.setBounds(140, 30, 285, 20);
		pnlTop.add(lblTask1);

		btnHome = new JButton(" Tilbaka ");
		btnHome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnHome.setBounds(10, 16, 90, 50);
		pnlTop.add(btnHome);

		// Middle
		JPanel pnlInfo = new JPanel();
		Border border2 = BorderFactory.createTitledBorder("MiddlePanel");
		pnlInfo.setBorder(border2);
		pnlInfo.setBounds(12, 130, 358, 140);
		pnlInfo.setLayout(new GridBagLayout());
		pnlInfo.setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();

		Border border3 = BorderFactory.createEtchedBorder();
		lblAssigned = new JLabel("                 Tilldelning: ");
		lblAssigned.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblAssigned.setBorder(border3);

		lblChildName = new JLabel("                        MAIDA         ");
		lblChildName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblChildName.setBorder(border3);

		lblCheck = new JLabel("              Syssla är gjort: ");
		lblCheck.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblCheck.setBorder(border3);

		cbCheckUncheck = new JCheckBox();
		cbCheckUncheck.setBorder(border3);

		lblHours = new JLabel("                   Timmar: ");
		lblHours.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblHours.setBorder(border3);

		tfHours = new JTextField();
		tfHours.setBorder(border3);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		pnlInfo.add(lblAssigned, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		pnlInfo.add(lblChildName, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 7;
		c.weighty = 7;
		c.gridx = 0;
		c.gridy = 1;
		pnlInfo.add(lblCheck, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 7;
		c.weighty = 7;
		c.gridx = 1;
		c.gridy = 1;
		pnlInfo.add(cbCheckUncheck, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 400;
		c.weighty = 400;
		c.gridx = 0;
		c.gridy = 2;
		pnlInfo.add(lblHours, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 400;
		c.weighty = 400;
		c.gridx = 1;
		c.gridy = 2;
		pnlInfo.add(tfHours, c);

		//Bottom
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

		cbCheckUncheck.addActionListener(this);
		btnDustSymbol.addActionListener(this);
		

		this.add(pnlTop);
		this.add(pnlInfo);
		this.add(pnlBottom);
		this.add(this);

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
		
		if(e.getSource() == btnDustSymbol) {
			//should open story page		
		}
	}

	public static void main(String[] args) throws IOException {
		ChildTaskWindow taskwindow = new ChildTaskWindow();
	}
}
