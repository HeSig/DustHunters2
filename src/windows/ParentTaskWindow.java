package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import profiles.Account;
import profiles.ParentProfile;
import tasks.Task;

/**
 * Klar! 
 * @author Angelina Fransson, Henrik Sigeman
 *
 */
public class ParentTaskWindow extends JPanel implements ActionListener {
	private Account account; 
	private ParentProfile parentProfile;
	private JLabel lblChildTask;
	private DisplayWindow displayWindow;
	
	private JLabel lblCheck;
	private JLabel lblTask;
	private JButton btnHome;
	private JButton btnAddTask;
	private JButton btnEditTask;
	private JLabel lblChildDoingTask; //Ifylld när ett barn har blivit assigned/valt en syssla. 
	private JButton btnProfileSymbol;
	private ImageIcon dustBallImage;
	private LinkedList<JPanel> taskPanelList = new LinkedList();
	private JPanel pnlMiddle;

	//SwitchPanel (panel t.ex. RewardPanel) { this.panel = panel }
	//Note to self: enable/disable JCheckBox beroende på om barnet gjort den eller inte
	//lägg till setters och getters
	
	public Account getAccount () {
		return account;
	}
	public ParentProfile getParentProfile () {
		return parentProfile; 
	}
	public void setLblNameTask (JLabel lblTask) {
		this.lblTask = lblTask;
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
	
	public void setBtnAddTask (JButton btnAddTask) {
		this.btnAddTask = btnAddTask;
	} 
	public void setBtnEditTask (JButton btnEditTask) {
		this.btnEditTask = btnEditTask;
	}
	
	public void setChildDoingTask (JLabel lblChildDoingTask) {
		this.lblChildDoingTask = lblChildDoingTask;
	
	}
	public ParentTaskWindow (DisplayWindow displayWindow) {
		this.displayWindow = displayWindow;
		start();
	
	}
	
	private void start() {
		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
		lblChildDoingTask.setOpaque(true); 
		lblCheck.setOpaque(true);
		lblTask.setOpaque(true);
		
	}
	private void InitializeGUI() {
		
		this.setBounds(6,6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);
		
		
		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);


		lblChildTask = new JLabel("Barnens sysslor");
		lblChildTask.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblChildTask.setBounds(105, 30, 285, 20);
		pnlTop.add(lblChildTask);

		btnHome = new JButton(" Home ");
		btnHome.addActionListener(this);
		btnHome.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnHome.setBounds(10, 16, 90, 50);
		pnlTop.add(btnHome);
		
		btnProfileSymbol = new JButton ();
		dustBallImage = new ImageIcon ("images/20x20Dammtuss.jpg");
		btnProfileSymbol.setBounds(250, 16, 90, 50);
		btnProfileSymbol.setIcon(dustBallImage);
		
		pnlTop.add(btnProfileSymbol);

		//Detta ska ligga i en if-sats. Om man gjort en syssla ska detta synas
	
		pnlMiddle = new JPanel();
		pnlMiddle.setBounds(12, 130, 358, 140);
		//pnlMiddle.setLayout(new GridBagLayout());
		//pnlMiddle.setBackground(Color.YELLOW);
		GridBagConstraints c = new GridBagConstraints();

		Border border3 = BorderFactory.createEtchedBorder();
		lblChildDoingTask = new JLabel("Angie");
		lblChildDoingTask.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 12));
		lblChildDoingTask.setBorder(border3);

		lblTask = new JLabel("Dammsuga Vardagsrummet");
		lblTask.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTask.setBorder(border3);
		
		lblCheck = new JLabel(" ");
		lblCheck.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCheck.setBorder(border3);

//Behövs göras om så alla är exakt lika långa
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		//pnlMiddle.add(lblChildDoingTask, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.weightx = 1;
		c.weighty = 1;
		
		//pnlMiddle.add(lblTask, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.weightx = 1;
		c.weighty = 1;
		

		//pnlMiddle.add(lblCheck, c);
		c.gridx = 0;
		
		updateTasks();


		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 300, 358, 180);
		pnlBottom.setLayout(null);
		pnlBottom.setBackground(Color.YELLOW);
		
		
		btnAddTask = new JButton(" Lägg till en syssla ");
		btnAddTask.addActionListener(this);
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
	
		
		this.add(pnlTop);
		this.add(pnlMiddle);
		this.add(pnlBottom);
	}
		
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == btnHome) {
//			changePanel (phw); //ParentHomeWindow
//		}
//		if (e.getSource() == btnEditTask) {
//			changePanel ();
//		}
//		if (e.getSource() == btnAddTask) {
//			changePanel ();
//		}

		
//	}
//	public static void main (String [] args) {
//		JFrame frame = new JFrame ();
//		//ParentTaskWindow pt = new ParentTaskWindow ();
//		//frame.add(pt);
//		frame.pack();
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setMinimumSize(new Dimension (400,600));
//	}
	@Override

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnHome) {
			displayWindow.setViewParentHomeWindow();
		}
		if(e.getSource() == btnAddTask) {
			displayWindow.setViewParentEditTaskWindow();
		}
		
	}
	
	public void updateTasks() {
		pnlMiddle.removeAll();
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridy = 0;
		
		for(int i = 0; i < displayWindow.getAccount().getTaskList().size(); i++) {
			Task task = displayWindow.getAccount().getTaskList().get(i);
			pnlMiddle.add(new TaskPanel(task.getLocationName(),task.getChoreName(),task.getTaskValue()), c);
			c.gridy++;
		}
		pnlMiddle.revalidate();
		pnlMiddle.repaint();
	}
	
	
	
	private class TaskPanel extends JPanel{
		private String locationName = "";
		private String choreName = "";
		private int choreValue = 0;
		private JLabel location;
		private JLabel chore;
		private JLabel value;
		private JLabel done;
		
		public TaskPanel(String locationName, String choreName, int choreValue) {
			this.locationName = locationName;
			this.choreName = choreName;
			this.choreValue = choreValue;
			location = new JLabel(locationName);
			chore = new JLabel(choreName);
			value = new JLabel(""+choreValue);
			done = new JLabel("Inte färdig");
			
			//setBounds(12, 130, 358, 140);
			setLayout(new GridBagLayout());
			setBackground(Color.YELLOW);
			
			GridBagConstraints c = new GridBagConstraints();
			
			Border border = BorderFactory.createEtchedBorder();
			location.setFont(new Font("SansSerif", Font.BOLD, 12));
			location.setBorder(border);
			chore.setFont(new Font("SansSerif", Font.BOLD, 12));
			chore.setBorder(border);
			value.setFont(new Font("SansSerif", Font.BOLD, 12));
			value.setBorder(border);
			done.setFont(new Font("SansSerif", Font.BOLD, 12));
			done.setBorder(border);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.anchor = GridBagConstraints.NORTHWEST;
			c.weightx = 1;
			c.weighty = 1;
			
			add(location, c);
			add(chore, c);
			add(value, c);
			add(done, c);
		}
		
		
	}
 }
