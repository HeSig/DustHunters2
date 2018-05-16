package windows;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JScrollPane;
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

	private ClientController clientController;
	

	private JLabel lblCheck;
	private JLabel lblTask;
	private JButton btnHome;
	private JButton btnAddTask;
	private JButton btnEditTask;
	private JLabel lblChildDoingTask; //Ifylld när ett barn har blivit assigned/valt en syssla. 
	private JButton btnProfile;
	private ImageIcon dustBallImage;
	private LinkedList<JPanel> taskPanelList = new LinkedList();
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
	public ParentTaskWindow (ClientController clientController) {
		this.clientController = clientController;
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

		btnHome = new JButton();
		btnHome.setIcon(new ImageIcon("images/House.jpg"));
		btnHome.setBounds(5, 5, 75, 70);
		btnHome.addActionListener(this);
		pnlTop.add(btnHome);

		btnProfile = new JButton ();
		btnProfile.addActionListener(this);
		dustBallImage = new ImageIcon ("images/20x20Dammtuss.jpg");
		btnProfile.setBounds(275, 16, 75, 70);
		btnProfile.setIcon(dustBallImage);

		pnlTop.add(btnProfile);

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
			clientController.setViewParentHomeWindow();
		}
		if(e.getSource() == btnAddTask) {
			clientController.setViewParentEditTaskWindow();
		}
		if(e.getSource() == btnProfile) {
			clientController.setViewParentProfileWindow();
		}

	}

	public void updateTasks() {
		pnlMiddle.removeAll();
		GridBagConstraints c = new GridBagConstraints();

		c.gridy = 0;

		for(int i = 0; i < clientController.getAccount().getTaskList().size(); i++) {
			Task task = clientController.getAccount().getTaskList().get(i);
			pnlMiddle.add(new TaskPanel(task), c);
			c.gridy++;
		}
		pnlMiddle.revalidate();
		pnlMiddle.repaint();
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
		private JButton completedButton;
		private ActionListener listener;

		public TaskPanel(Task task) {
			this.locationName = task.getLocationName();
			this.choreName = task.getChoreName();
			this.choreValue = task.getTaskValue();
			location = new JLabel(locationName);
			chore = new JLabel(choreName);
			value = new JLabel(""+choreValue);
			completedButton = new JButton("Godkänn");
			completedButton.setEnabled(task.getCompleted());
			listener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == completedButton) {
						try {
							clientController.completeTask(task, task.getChildProfile());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			};
			completedButton.addActionListener(listener);
			
			
			String str = "Inte färdig";
			if(task.getCompleted()) {
				str = "Färdig";
			}
			done = new JLabel(str);

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
			add(completedButton, c);
		}


	}
}
