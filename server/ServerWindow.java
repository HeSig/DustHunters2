package server;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public class ServerWindow extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel textPanel = new JPanel();
	private JTextField txtpnl = new JTextField();
	private JTextField status = new JTextField();
	private JButton startServer = new JButton("Start Server");
	private JButton closeServer = new JButton("Close server");
	private Server server;

	public ServerWindow(Server server) {
		GridLayout layout = new GridLayout(2, 1, 32, 32);
		this.server = server;
		setPreferredSize(new Dimension(320, 160));
		setResizable(false);
		status.setText("Server running");
		txtpnl.setText("Port:" + server.getPort());
		status.setEditable(false);
		txtpnl.setEditable(false);
		startServer.addActionListener(this);
		closeServer.addActionListener(this);
		textPanel.setLayout(layout);
		textPanel.add(txtpnl);
		textPanel.add(status);
		textPanel.add(startServer);
		textPanel.add(closeServer);
		textPanel.setBorder(new EmptyBorder(16, 16, 16, 16));
		add(textPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private void setStatus(String str) {
		status.setText(str);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startServer) {
			if (Thread.interrupted() || !server.isAlive()) {
				setStatus("Server running");
				server.run();
			}
		}
		if (e.getSource() == closeServer) {
			if (!Thread.interrupted()) {
				setStatus("Server stopped");
				server.interrupt();

			}
		}

	}

}
