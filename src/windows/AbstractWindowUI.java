<<<<<<< HEAD
package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public abstract class AbstractWindowUI extends JPanel {

	private JFrame frame = new JFrame();
	private String title;
	private JLabel lblTitle = new JLabel(title);
	private JPanel topPanel;
	private JPanel middlePanel;

	public AbstractWindowUI(String title) {
		this.title = title;
		initializeGUI();
	}

	public void setBackgroundColor() {
		frame.setBackground(Color.YELLOW);
	}

	public void setWindowSize() {
		frame.setBounds(0, 0, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}

	public void setupTopPanel() {
		JPanel topPanel = new JPanel();
		Border border1 = BorderFactory.createTitledBorder("TopPanel");
		topPanel.setBorder(border1);
		topPanel.setBounds(12, 12, 368, 100);
		topPanel.setLayout(null);

		lblTitle = new JLabel(title);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setBounds(140, 30, 300, 20);
		topPanel.add(lblTitle);

		frame.add(topPanel);
	}

	public void setupMiddlePanel() {
		JPanel middlePanel = new JPanel();
		Border border2 = BorderFactory.createTitledBorder("MiddlePanel");
		middlePanel.setBorder(border2);
		middlePanel.setBounds(12, 125, 368, 400);
		middlePanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		frame.add(middlePanel);

	}

	public void setTopTitleText(String title) {
		this.title = title;
	}

	public String getTopTitleText() {
		return title;
	}

	// public void setTopMenuIcon();

	// public void setTopPanelIcon();

	public void initializeGUI() {
		setBackgroundColor();
		setWindowSize();
		setupTopPanel();
		setupMiddlePanel();

	}
	
//	public static void main(String[] args) {
//		AbstractWindowUI ui = new AbstractWindowUI("TaskWindow");
//	}
}
=======
package windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public abstract class AbstractWindowUI extends JPanel {

	private JFrame frame = new JFrame();
	private String title;
	private JLabel lblTitle = new JLabel(title);
	private JPanel topPanel;
	private JPanel middlePanel;

	public AbstractWindowUI(String title) {
		this.title = title;
		initializeGUI();
	}

	public void setBackgroundColor() {
		frame.setBackground(Color.YELLOW);
	}

	public void setWindowSize() {
		frame.setBounds(0, 0, 400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}

	public void setupTopPanel() {
		JPanel topPanel = new JPanel();
		Border border1 = BorderFactory.createTitledBorder("TopPanel");
		topPanel.setBorder(border1);
		topPanel.setBounds(12, 12, 368, 100);
		topPanel.setLayout(null);

		lblTitle = new JLabel(title);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setBounds(140, 30, 300, 20);
		topPanel.add(lblTitle);

		frame.add(topPanel);
	}

	public void setupMiddlePanel() {
		JPanel middlePanel = new JPanel();
		Border border2 = BorderFactory.createTitledBorder("MiddlePanel");
		middlePanel.setBorder(border2);
		middlePanel.setBounds(12, 125, 368, 400);
		middlePanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		frame.add(middlePanel);

	}

	public void setTopTitleText(String title) {
		this.title = title;
	}

	public String getTopTitleText() {
		return title;
	}

	// public void setTopMenuIcon();

	// public void setTopPanelIcon();

	public void initializeGUI() {
		setBackgroundColor();
		setWindowSize();
		setupTopPanel();
		setupMiddlePanel();
	}
}

// public static void main(String[] args) {
// AbstractWindowUI ui = new AbstractWindowUI("TaskWindow");
//
>>>>>>> 908d4427e566931715f4262830255e57b7acdc91
