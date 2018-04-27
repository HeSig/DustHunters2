package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import profiles.Account;
import profiles.ParentProfile;

/**
 * 
 * @author Angelina Fransson
 *
 */
public class ParentTaskWindow extends JPanel implements ActionListener {
	private Account account; 
	private ParentProfile parentProfile;
	private JFrame frame;
	private JLabel lblTask;
	private JLabel lblAssigned;

	private JTextField tfHours;
	private JLabel lblCheck;
	private JLabel lblNameTask;
	private JButton btnHome;
	private JButton btnProfile;
	private JButton btnAddTask;
	private JButton btnEditTask;
	private JLabel lblCreatedTask;
	private JLabel lblChildDoingTask; //Ifylld när ett barn har blivit assigned/valt en syssla. 
	private JCheckBox cbCheckCompletedTask; //
	//SwitchPanel (panel t.ex. RewardPanel) { this.panel = panel }
	//Note to self: enable/disable JCheckBox beroende på om barnet gjort den eller inte
	//lägg till setters och getters
	
	public Account getAccount () {
		return account;
	}
	public ParentProfile getParentProfile () {
		return parentProfile; 
	}
	public void setLblNameTask (JLabel lblNameTask) {
		this.lblNameTask = lblNameTask;
	}
	public void setAccount (Account account) {
		this.account = account;
	}
	public void setParentProfile (ParentProfile parentProfile) {
		this.parentProfile = parentProfile;
	}
	public void setBtnHome (JButton btnHome) {
		this.btnHome = btnHome;
	}
	public void setBtnProfile (JButton btnProfile) {
		this.btnProfile = btnProfile;
	}
	public void setBtnAddTask (JButton btnAddTask) {
		this.btnAddTask = btnAddTask;
	} 
	public void setBtnEditTask (JButton btnEditTask) {
		this.btnEditTask = btnEditTask;
	}
	public void setCreatedTask (JLabel lblCreatedTask){
		this.lblCreatedTask = lblCreatedTask;
	}
	public void setChildDoingTask (JLabel lblChildDoingTask) {
		this.lblChildDoingTask = lblChildDoingTask;
	
	}
	public ParentTaskWindow () {
		start();
	
	}
	
	private void start() {
		frame = new JFrame();
		frame.setBounds(0, 0, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle(" ParentTaskWindow ");
		InitializeGUI();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
	}
	private void InitializeGUI() {
		//Main
		JPanel pnlMain = new JPanel();
		Border border0 = BorderFactory.createTitledBorder("MainPanel"); 
		pnlMain.setBorder(border0);
		pnlMain.setBounds(6,6, 381, 500);
		pnlMain.setLayout(null);
		pnlMain.setBackground(Color.YELLOW);
		
		//Top
		JPanel pnlTop = new JPanel();
		Border border1 = BorderFactory.createTitledBorder("TopPanel");
		pnlTop.setBorder(border1);
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.WHITE);

		lblTask = new JLabel("Barnens sysslor");
		lblTask.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTask.setBounds(140, 30, 285, 20);
		pnlTop.add(lblTask);

		btnHome = new JButton(" Home ");
		btnHome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnHome.setBounds(10, 16, 90, 50);
		pnlTop.add(btnHome);

		//Detta ska ligga i en if-sats. Om man gjort en syssla ska detta synas
		//Middle
		JPanel pnlInfo = new JPanel();
		Border border2 = BorderFactory.createTitledBorder("MiddlePanel");
		pnlInfo.setBorder(border2);
		pnlInfo.setBounds(12, 130, 358, 140);
		pnlInfo.setLayout(new GridBagLayout());
		pnlInfo.setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();

		Border border3 = BorderFactory.createEtchedBorder();
		lblChildDoingTask = new JLabel("Angie");
		lblChildDoingTask.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblChildDoingTask.setBorder(border3);

		lblNameTask = new JLabel("Dammsuga Vardagsrummet");
		lblNameTask.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNameTask.setBorder(border3);
		
		lblCheck = new JLabel(" ");
		lblCheck.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCheck.setBorder(border3);

//Behövs göras om så alla är exakt lika långa
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		pnlInfo.add(lblChildDoingTask, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		pnlInfo.add(lblNameTask, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 7;
		c.weighty = 7;

		pnlInfo.add(lblCheck, c);


		JPanel pnlBottom = new JPanel();
		Border border4 = BorderFactory.createTitledBorder("BottomPanel"); 
		pnlBottom.setBorder(border4);
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.WHITE);
		
		
		btnAddTask = new JButton(" Lägg till en syssla ");
		btnAddTask.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnAddTask.setBackground(Color.GREEN);
		btnAddTask.setForeground(Color.BLACK);
		btnAddTask.setBounds(10, 16, 300, 50);
		pnlBottom.add(btnAddTask);
		
		
		btnEditTask = new JButton(" Redigera/Ta bort syssla ");
		btnEditTask.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnEditTask.setBackground(Color.RED);
		btnEditTask.setForeground(Color.BLACK);
		btnEditTask.setBounds(10, 100, 300, 50);
		pnlBottom.add(btnEditTask);
		
		
		pnlMain.add(pnlTop);
		pnlMain.add(pnlInfo);
		pnlMain.add(pnlBottom);
		frame.add(pnlMain);
		
	}
	public void chooseTask () {
		
	}

	public void confirmDoneTask () {
		
	}
	public void denyDoneTask () {
		
	}
	public void setTaskTimeLimit () {
		
	}
	public void createNewTask () {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main (String [] args) {
		ParentTaskWindow pt = new ParentTaskWindow ();
	}
 }
