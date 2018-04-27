package windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

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
	private JButton updateButton = new JButton("Update");
	private JTextField updateText = new JTextField();
	private Dimension boxDimension = new Dimension(128, 64);
	private ChildTaskWindow ctw;
	
	public DisplayWindow() {
		
		try {
			ctw = new ChildTaskWindow();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updatePanel.setPreferredSize(new Dimension(128, 128));
		this.setPreferredSize(new Dimension(400, 600));
		setLayout(new BorderLayout());
		updateButton.addActionListener(this);
		updateButton.setPreferredSize(boxDimension);
		updateText.setPreferredSize(boxDimension);
		updatePanel.setLayout(new BorderLayout());
		updatePanel.add(updateButton, BorderLayout.NORTH);
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
	
	public void changePanel(JPanel panel) {
		setPanel(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateButton) {
			changePanel(ctw);
		}
	}
	
	public static void main(String[] args) throws IOException {
		DisplayWindow displayWindow = new DisplayWindow();
	}

}
