package windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import profiles.Account;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class DisplayWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JPanel panel;
	private JPanel updatePanel = new JPanel();
	private JButton updateBtn = new JButton("Update");
	private JTextField updateText = new JTextField();
	private Dimension boxDimension = new Dimension(128, 64);
	private ChildTaskWindow ctw;
	private ChildRewardWindow2 crw;
	private ChildProfileWindow cpw;
	private Account account;
	
	public DisplayWindow(Account account) {
		this.account = account;
		try {
			ctw = new ChildTaskWindow(this);
			crw = new ChildRewardWindow2(this);
			cpw = new ChildProfileWindow(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updatePanel.setPreferredSize(new Dimension(128, 128));
		this.setPreferredSize(new Dimension(400, 600));
		setLayout(new BorderLayout());
		updateBtn.addActionListener(this);
		updateBtn.setPreferredSize(boxDimension);
		updateText.setPreferredSize(boxDimension);
		updatePanel.setLayout(new BorderLayout());
		updatePanel.add(updateBtn, BorderLayout.NORTH);
		updatePanel.add(updateText, BorderLayout.SOUTH);
		panel = updatePanel;
		add(panel, BorderLayout.CENTER);
		pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void setPanel(JPanel panel) {
		this.remove(this.panel);
		this.panel = panel;
		add(this.panel, BorderLayout.CENTER);
		this.revalidate();
	}
	
	public void setViewChildTaskWindow() {
		setPanel(ctw);
	}
	public void setViewChildRewardWindow() {
		setPanel(crw);
	}
	public void setViewChildProfileWindow() {
		setPanel(cpw);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateBtn) {
			setPanel(ctw);
		}
	}
	
	public static void main(String[] args) throws IOException {
		//DisplayWindow displayWindow = new DisplayWindow();
	}

}
