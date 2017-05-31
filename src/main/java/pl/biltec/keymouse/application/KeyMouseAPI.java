package pl.biltec.keymouse.application;

public class KeyMouseAPI {

	private KeyToActionMap keyToActionMap;

	public KeyMouseAPI(KeyToActionMap keyToActionMap) {
		//TODO assert not null ect.
		this.keyToActionMap = keyToActionMap;
	}

	public Action findAction(Key key) {
		return keyToActionMap.getAction(key);
	}

}
