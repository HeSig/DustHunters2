package locations;

import javax.swing.ImageIcon;

/**
 * 
 * @author Henrik Sigeman
 *
 */
public abstract class Location {
	protected String locationName;
	protected ImageIcon locationIcon;

	public String getLocationName() {
		return locationName;
	}

	public ImageIcon getLocationIcon() {
		return locationIcon;
	}

}
