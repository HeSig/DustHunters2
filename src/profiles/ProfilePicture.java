package profiles;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class ProfilePicture {
	private HashMap<String, ImageIcon> profilePictureMap = new HashMap<>();

	public ProfilePicture() {
		initialize();
	}
	
	private void initialize(){
		profilePictureMap.put("dammtuss", new ImageIcon("images/20x20Dammtuss.jpg"));
		profilePictureMap.put("ninja", new ImageIcon("images/NinjaReducedSize3.png"));
		profilePictureMap.put("cowboy", new ImageIcon("images/cowboy.png"));
		profilePictureMap.put("pirat", new ImageIcon("images/Pirat.png"));
		profilePictureMap.put("witch", new ImageIcon("images/witch.png"));
		profilePictureMap.put("astronaut", new ImageIcon("images/astronaut.png"));
	}
	
	public Image getImage(String str) {
		return profilePictureMap.get(str).getImage();
	}
}
