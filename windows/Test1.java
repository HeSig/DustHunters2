package windows;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JPanel;

public class Test1 extends AbstractWindowUI {

	public Test1(String title) {
		super(title);
		this.initializeGUI();
		setBackgroundColor();
	}

	public void setBackgroundColor() {
		setBackground(Color.YELLOW);
	}
	
	
	public static void main(String[] args) {
		Test1 t = new Test1("Syssla 1");
	}
}
