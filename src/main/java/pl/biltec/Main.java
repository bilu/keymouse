package pl.biltec;

import pl.biltec.keymouse.application.KeyMouseAPI;
import pl.biltec.keymouse.ui.swing.DefaultKeyToActionMap;
import pl.biltec.keymouse.ui.swing.SwingController;

public class Main {

	public static void main(String[] args) {

		KeyMouseAPI api = new KeyMouseAPI(new DefaultKeyToActionMap());
		new SwingController(api).start();


	}
}
