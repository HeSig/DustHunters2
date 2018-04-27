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

import tasks.Chore;
import tasks.Task;

public class ChildTaskWindow extends JPanel implements ActionListener {

	private JButton btnBack;
	private JButton btnDustSymbol = new JButton();
	private JFrame frame;
	private JLabel lblTask1;
	private JLabel lblAssigned;
	private JLabel lblChildName;
	private JLabel lblCheck;
	private JLabel lblHours;
	private JTextField tfHours;
	private JCheckBox cbCheckUncheck;

	private Task task;
	private Chore chore;

	// private ImageIcon dustIcon = new ImageIcon("images/"

	// private JMenuBar menuBar = new JMenuBar();
	// private List<Task> taskList;

	public ChildTaskWindow() {
		start();
	}

	public void start() {
		// TODO Auto-generated method stub

		frame = new JFrame();
		frame.setBounds(0, 0, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle(" ChildTaskWindow ");
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
		Border border1 = BorderFactory.createTitledBorder("TopPanel");
		pnlTop.setBorder(border1);
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.WHITE);

		lblTask1 = new JLabel("Syssla 1 ");
		lblTask1.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTask1.setBounds(140, 30, 285, 20);
		pnlTop.add(lblTask1);

		btnBack = new JButton(" Tilbaka ");
		btnBack.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnBack.setBounds(10, 16, 90, 50);
		pnlTop.add(btnBack);

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

		JPanel pnlBottom = new JPanel();
		Border border4 = BorderFactory.createTitledBorder("BottomPanel");
		pnlBottom.setBorder(border4);
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.WHITE);

		btnDustSymbol.setIcon(new ImageIcon("images/Ninja.png"));
		pnlBottom.add(btnDustSymbol);

		cbCheckUncheck.addActionListener(this);

		pnlMain.add(pnlTop);
		pnlMain.add(pnlInfo);
		pnlMain.add(pnlBottom);
		frame.add(pnlMain);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		Color color = null;
		if (cbCheckUncheck.isSelected()) {
			cbCheckUncheck.setBackground(Color.GREEN);
		} else {
			cbCheckUncheck.setBackground(null);
		}

	}

	public static void main(String[] args) {
		ChildTaskWindow taskwindow = new ChildTaskWindow();
	}
}
