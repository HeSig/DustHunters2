package windows;

import profiles.Account;
import profiles.ChildProfile;

public class ChildTaskWindow extends AbstractWindowUI {

	private int taskID;
	private Account account;
	private ChildProfile childProfile;
	
	public ChildTaskWindow(String title, int taskID) {
		super(title);
		this.taskID = taskID;
//		topPanel.add()
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		ChildTaskWindow taskWindow = new ChildTaskWindow("Syssla:", 1);
	}
	
	

}
