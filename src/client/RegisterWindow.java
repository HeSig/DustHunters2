package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.*;

import profiles.Account;

/**
 * sara hälsar mofoooo
 * @author Henrik Sigeman
 *
 */
public class RegisterWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton registerButton = new JButton("Register");
	private JButton loginButton = new JButton("Login");
	private JTextField email = new JTextField();
	private JTextField password = new JTextField();
	private JTextField emailText = new JTextField("E-mail:");
	private JTextField passwordText = new JTextField("Lösenord:");
	private JTextField infoText = new JTextField("Skriv in en e-mail och ett lösenord för att registrera.");
	private UserController controller;
	private GridBagLayout gLayout = new GridBagLayout();
	private BorderLayout bLayout = new BorderLayout();
	private JPanel registerPanel = new JPanel(gLayout);
	private JPanel buttonPanel = new JPanel();

	
	/**
	 * 
	 * @param controller The local controller
	 */
	public RegisterWindow(UserController controller) {
		email.setText("Test@test.com");
		password.setText("TestTestTest");

		this.controller = controller;
		Dimension panelSize = new Dimension(200, 32);
		GridBagConstraints c = new GridBagConstraints();
		registerButton.addActionListener(this);
		loginButton.addActionListener(this);
		this.setLayout(bLayout);
		email.setPreferredSize(panelSize);
		password.setPreferredSize(panelSize);

		// Composition:
		emailText.setEditable(false);
		passwordText.setEditable(false);
		infoText.setEditable(false);
		c.gridy = 0;
		registerPanel.add(emailText, c);
		registerPanel.add(email, c);
		c.gridy = 1;
		registerPanel.add(passwordText, c);
		registerPanel.add(password, c);
		buttonPanel.add(registerButton, c);
		c.gridy = 2;
		buttonPanel.add(loginButton, c);
		add(infoText, BorderLayout.NORTH);
		add(registerPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		setPreferredSize(new Dimension(640, 320));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private void login() throws UnknownHostException, IOException {
		email.setBackground(Color.WHITE);
		password.setBackground(Color.WHITE);
		String mailStr = email.getText();
		String passStr = password.getText();
		String infoTextStr = "";
		Boolean mailOK = false;
		Boolean passOK = false;
		char a;

		// Krav för valid email: ska ha @.
		for (int i = 0; i < mailStr.length(); i++) {
			a = mailStr.charAt(i);
			if (a == '@') {
				mailOK = true;
				break;
			}
		}
		// Krav för valid password: minst 5 tecken.
		if (passStr.length() >= 5) {
			passOK = true;
		}

		// infoText.setText("");
		if (!mailOK) {
			infoTextStr = infoTextStr + "Fel e-mail format. ";
			email.setBackground(Color.RED);
		}
		if (!passOK) {
			infoTextStr = infoTextStr + "För kort lösenord (minst 5 bokstäver och siffror). ";
			password.setBackground(Color.RED);
		}
		if (mailOK) {
			if (passOK) {
				Account account = new Account(email.getText(), password.getText());
				System.out.println(account.getEmail());
				if (controller.login(account)) {
					System.out.println("Hello");
				} else {

				}

			}
		}
		infoText.setText(infoTextStr);
	}

	private void register() throws UnknownHostException, IOException {
		email.setBackground(Color.WHITE);
		password.setBackground(Color.WHITE);
		String mailStr = email.getText();
		String passStr = password.getText();
		String infoTextStr = "";
		Boolean mailOK = false;
		Boolean passOK = false;
		char a;

		// Krav för valid email: ska ha @.
		for (int i = 0; i < mailStr.length(); i++) {
			a = mailStr.charAt(i);
			if (a == '@') {
				mailOK = true;
				break;
			}
		}
		// Krav för valid password: minst 5 tecken.
		if (passStr.length() >= 5) {
			passOK = true;
		}

		// infoText.setText("");
		if (!mailOK) {
			infoTextStr = infoTextStr + "Fel e-mail format. ";
			email.setBackground(Color.RED);
		}
		if (!passOK) {
			infoTextStr = infoTextStr + "För kort lösenord (minst 5 bokstäver och siffror). ";
			password.setBackground(Color.RED);
		}
		if (mailOK) {
			if (passOK) {
				Account account = new Account(email.getText(), password.getText());
				System.out.println(account.getEmail());
				infoTextStr = controller.registerUser(account);

			}
		}
		infoText.setText(infoTextStr);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == registerButton) {
			try {
				register();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == loginButton) {
			try {
				login();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
