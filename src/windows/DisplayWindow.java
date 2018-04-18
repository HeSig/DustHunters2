package windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class DisplayWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Panel panel;
	private JPanel updatePanel = new JPanel();
	private JButton updateButton = new JButton("Update");
	private JTextField updateText = new JTextField();
	private Dimension boxDimension = new Dimension(128, 64);
	
	public DisplayWindow() {
		updatePanel.setPreferredSize(new Dimension(128, 128));
		this.setPreferredSize(new Dimension(1280, 640));
		setLayout(new BorderLayout());
		updateButton.addActionListener(this);
		updateButton.setPreferredSize(boxDimension);
		updateText.setPreferredSize(boxDimension);
		updatePanel.setLayout(new BorderLayout());
		updatePanel.add(updateButton, BorderLayout.NORTH);
		updatePanel.add(updateText, BorderLayout.SOUTH);
		//add(panel, BorderLayout.CENTER);
		add(updatePanel, BorderLayout.SOUTH);
		pack();
		setVisible(true);
		
	}
	
	private void setPanel(Panel panel) {
		this.panel = panel;
	}
	
	public void changePanel(Panel panel) {
		setPanel(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		DisplayWindow displayWindow = new DisplayWindow();
	}

}
