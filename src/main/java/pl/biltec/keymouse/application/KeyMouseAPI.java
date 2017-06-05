package pl.biltec.keymouse.application;

import pl.biltec.keymouse.domain.Area;

import java.util.Optional;

public class KeyMouseAPI {

	private KeyToActionBinding keyToActionBinding;

	public KeyMouseAPI(KeyToActionBinding keyToActionBinding) {
		//TODO assert not null ect.
		this.keyToActionBinding = keyToActionBinding;
	}

	public Optional<Action> findAction(Key key) {
		return Optional.ofNullable(keyToActionBinding.getAction(key));
	}

	public Area getInitialArea() {
		return new Area(0, 0, 1920, 1080, 3, 3);
	}

	//TODO rething api
	public KeyToActionBinding getKeyToActionBinding() {

		return keyToActionBinding;
	}
}
