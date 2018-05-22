package windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

import profiles.Account;
import profiles.ParentProfile;
import tasks.Task;

/**
 * Klar! 
 * @author Angelina Fransson, Henrik Sigeman, Maida Sijaric
 *
 */
public class ParentTaskWindow2 extends JPanel implements ActionListener {
	private Account account; 
	private ParentProfile parentProfile;
	private JLabel lblChildTask;

	private ClientController controller;
	

	private JLabel lblCheck;
	private JLabel lblTask;
	private JButton btnHome;
	private JButton btnAddTask;
	private JButton btnEditTask;
	private JLabel lblChildDoingTask; //Filled in when a child has been assigned with a chore
	private JButton btnProfile;
	private ImageIcon dustBallImage;
	private LinkedList<JPanel> taskPanelList = new LinkedList();
	
	private DefaultListModel model = new DefaultListModel();
	private JList taskList = new JList(model);
	private JPanel pnlMiddle;

	

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
	public ParentTaskWindow2 (ClientController clientController) {
		this.controller = clientController;
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
	
	/*
	 * Set sizes and add components
	 */
	private void InitializeGUI() {

		//PnlMain
		this.setBounds(6,6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		// Top panel
		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);

		//Label in the middle of pnlTop
		lblChildTask = new JLabel("Barnens sysslor");
		lblChildTask.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblChildTask.setBounds(105, 30, 285, 20);
		pnlTop.add(lblChildTask);

		btnHome = new JButton();
		btnHome.setIcon(new ImageIcon("images/House.jpg"));
		btnHome.setBounds(5, 5, 75, 70);
		btnHome.addActionListener(this);
		pnlTop.add(btnHome);

		btnProfile = new JButton ();
		btnProfile.addActionListener(this);
		dustBallImage = (new ImageIcon(controller.getPictures().getImage(controller.getParentProfile().getImageString())));
		btnProfile.setBounds(275, 16, 75, 70);
		btnProfile.setIcon(dustBallImage);

		pnlTop.add(btnProfile);

		//This should be in an if-statement. If a chore has been done, then this should be visible
		
		taskList.setCellRenderer(new TaskRenderer());
		JScrollPane taskScroll = new JScrollPane(taskList);
		taskScroll.setBounds(12, 130, 358, 140);
//		pnlMiddle = new JPanel();
//		pnlMiddle.setBounds(12, 130, 358, 140);
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

		//Needs to be redone so that they're all the same length 
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


		//Bottom panel
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
		this.add(taskScroll);
//		this.add(pnlMiddle);
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
			controller.setViewParentHomeWindow();
		}
		if(e.getSource() == btnAddTask) {
			controller.setViewParentEditTaskWindow();
		}
		if(e.getSource() == btnProfile) {
			controller.setViewParentProfileWindow();
		}

	}

	public void updateTasks() {
//		pnlMiddle.removeAll();
		model.clear();
//		GridBagConstraints c = new GridBagConstraints();

//		c.gridy = 0;

		for(int i = 0; i < controller.getAccount().getTaskList().size(); i++) {
			Task task = controller.getAccount().getTaskList().get(i);
			model.addElement(task);
//			pnlMiddle.add(new TaskPanel(task.getLocationName(),task.getChoreName(),task.getTaskValue()), c);
//			c.gridy++;
		}
//		pnlMiddle.revalidate();
//		pnlMiddle.repaint();
	}
	
	private class TaskRenderer implements ListCellRenderer {
		private ActionListener listener;
		private JButton completedButton;
		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			listener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			};
			// TODO Auto-generated method stub
			completedButton = new JButton("Godkänn");
			completedButton.addActionListener(listener);
			JPanel panel = new JPanel(new GridLayout(2,4));
			Task task = (Task)value;
			panel.add(new JLabel(task.getLocationName()));
			panel.add(new JLabel(task.getChoreName()));
			panel.add(new JLabel(""+task.getTaskValue()));
			
			if(task.getCompleted()) {
				panel.add(new JLabel("Färdig"));
				completedButton.setEnabled(true);
			}else {
				panel.add(new JLabel("Ej färdig"));
				completedButton.setEnabled(false);
			}
			panel.add(completedButton);
			
			return panel;
		}
		
	}
	
/** 
 * 
 * @author Henrik Sigeman
 * 
 */


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
