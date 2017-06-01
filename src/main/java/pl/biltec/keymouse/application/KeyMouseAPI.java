package pl.biltec.keymouse.application;

import java.util.Optional;

public class KeyMouseAPI {

	private KeyToActionMap keyToActionMap;

	public KeyMouseAPI(KeyToActionMap keyToActionMap) {
		//TODO assert not null ect.
		this.keyToActionMap = keyToActionMap;
	}

	public Optional<Action> findAction(Key key) {
		return Optional.ofNullable(keyToActionMap.getAction(key));
	}

}
