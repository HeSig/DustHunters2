package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import locations.Location;
import profiles.Account;
import profiles.ChildProfile;
import tasks.Chore;
import tasks.Task;
/**
 * KLAR! 
 * En metod för att spara ner valen behövs så att valen föräldern gör kommer till ParentTaskWindow.
 * @author Angelina Fransson
 *
 */
@SuppressWarnings("serial")
public class ParentEditTaskWindow extends JPanel implements ActionListener {

	private JButton btnHome = new JButton();
	private JLabel lblTitle;
	private JLabel lblChildName;
	private JLabel lblTask;
	private JLabel lblLocation; 
	
	@SuppressWarnings("rawtypes")
	private JComboBox comboChooseChild;
	@SuppressWarnings("rawtypes")
	private JComboBox comboChooseTask; 
	private JComboBox comboChooseLocation;
	
	private JButton btnSave = new JButton();
	private JButton btnCancel = new JButton();
	private JButton btnProfile = new JButton();

	private Account account;
	private ChildProfile childProfile;
	private String[] childNames = {"MAIDA", "HENRIK", "ANGIE", "SARA", "KASPER", "ALLA"};
	private String [] preSelectedTasks = {"Dammsuga", "Damma", "Diska", "Bädda", "Gå ut med hunden"};
	private String [] preSelectedLocations = {"Hallen", "Sovrummet", "Toaletten", "Vardagsrummet", "utomhus"};
	
	private ClientController displayWindow;
	


	public ParentEditTaskWindow (ClientController displayWindow) {
		this.displayWindow = displayWindow;
		try {
			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Account getAccount() {
		return account;
	}

	public ChildProfile getChildProfile() {
		return childProfile;
	}

	public void start() throws IOException {

		this.setBounds(0, 0, 400, 600);
		this.setLayout(null);
		InitializeGUI();
		this.setVisible(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void InitializeGUI() throws IOException {

		// Main Panel
		this.setBounds(6, 6, 381, 500);
		this.setLayout(null);
		this.setBackground(Color.YELLOW);

		// Top Panel
		JPanel pnlTop = new JPanel();
		pnlTop.setBounds(12, 17, 358, 80);
		pnlTop.setLayout(null);
		pnlTop.setBackground(Color.YELLOW);

		lblTitle = new JLabel("Redigera syssla");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setBounds(100, 30, 285, 20);
		btnHome.setIcon(new ImageIcon("images/house.jpg"));
		btnHome.setBounds(5, 5, 80, 65);
		btnProfile.setIcon(new ImageIcon("images/20x20Dammtuss.jpg"));
		btnProfile.setBounds(260, 16, 90, 50);

		pnlTop.add(btnHome);
		pnlTop.add(lblTitle);
		pnlTop.add(btnProfile);

		// Middle-Top Panel
		JPanel pnlMiddle1 = new JPanel();
		pnlMiddle1.setBounds(12, 100, 358, 130);
		pnlMiddle1.setLayout(new FlowLayout());
		pnlMiddle1.setBackground(Color.YELLOW);
		Border border3 = BorderFactory.createEtchedBorder();

	
		
		// Middle-Bottom Panel
		JPanel pnlMiddle2 = new JPanel();
		pnlMiddle2.setBounds(12, 240, 358, 180);
		pnlMiddle2.setLayout(new GridLayout(3,2));
		pnlMiddle2.setBackground(Color.YELLOW);

		
		lblChildName = new JLabel("Namn: ");
		lblChildName.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		
		lblTask = new JLabel("Välj syssla: ");
		lblTask.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblLocation = new JLabel ("Välj plats: "); 
		lblLocation.setFont(new Font ("SansSerif", Font.BOLD, 12));
	
		
		comboChooseChild = new JComboBox(childNames);
		comboChooseChild.setSelectedIndex(1);
		comboChooseChild.setBorder(border3);
		
		comboChooseTask = new JComboBox (preSelectedTasks);
		comboChooseTask.setSelectedIndex(1);
		comboChooseTask.setSelectedItem(border3);
		
		comboChooseLocation = new JComboBox (preSelectedLocations); 
		comboChooseLocation.setSelectedIndex(1);
		comboChooseLocation.setSelectedItem(border3);
		
		pnlMiddle2.add(lblChildName);
		pnlMiddle2.add(comboChooseChild);
		pnlMiddle2.add(lblTask);
		pnlMiddle2.add(comboChooseTask);
		pnlMiddle2.add(lblLocation);
		pnlMiddle2.add(comboChooseLocation);
	

		// Bottom Panel

		JPanel pnlBottom = new JPanel();
		pnlBottom.setBounds(12, 430, 358, 100);
		pnlBottom.setLayout(new FlowLayout());
		pnlBottom.setBackground(Color.YELLOW);

		
		btnSave = new JButton("Spara");
		btnSave.addActionListener(this);
		btnSave.setBounds(10, 10, 10, 10);
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(Color.GREEN);
		
		btnCancel = new JButton("Avsluta");
		btnCancel.setBounds(100, 200, 250, 200);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.RED);
		
		pnlBottom.add(btnSave);
		pnlBottom.add(btnCancel);
		

		

		this.add(pnlTop);
		this.add(pnlMiddle1);
		this.add(pnlMiddle2);
		this.add(pnlBottom);
		
		// Add all action listeners
		btnHome.addActionListener(this);
		btnProfile.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnHome) {
			displayWindow.setViewParentHomeWindow();
		}
		if(e.getSource() == btnCancel) {
			displayWindow.setViewParentTaskWindow();
		}
		if(e.getSource() == btnSave) {
			Location location = new Location(comboChooseLocation.getSelectedItem().toString());
			Task task = new Task(location, new Chore(comboChooseTask.getSelectedItem().toString()), 10);
			
			//Server add new task to the account.
			try {
				
				displayWindow.addTaskToAccount(task);
				//Fullösning
				Thread.sleep(500);
				//Fullösning
				displayWindow.getAccount().setTaskList(displayWindow.getTasksFromAccount());
				Thread.sleep(500);
				displayWindow.updateTaskLists();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Cannot add new task.");
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			displayWindow.setViewParentTaskWindow();
		}
		if (e.getSource() == btnProfile) {
			displayWindow.setViewParentProfileWindow();
		}
	}
}


