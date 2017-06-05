package pl.biltec.keymouse.application;

public interface KeyToActionBinding {

	Action getAction(Key key);

	String getKeyName(Action action);

	String getKeyName(Key key);
}