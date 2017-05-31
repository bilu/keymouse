package pl.biltec.keymouse.ui.swing;

import pl.biltec.keymouse.application.Action;
import pl.biltec.keymouse.application.BasicActions;
import pl.biltec.keymouse.application.Key;
import pl.biltec.keymouse.application.KeyToActionMap;

import java.util.HashMap;
import java.util.Map;

public class DefaultKeyToActionMap implements KeyToActionMap {

	private Map<Key, Action> mapped = new HashMap<>();

	public DefaultKeyToActionMap() {
		this.mapped.put(new IntegerKey(27), BasicActions.EXIT); //esc
		this.mapped.put(new IntegerKey(8), BasicActions.UNDO); //backspace
		this.mapped.put(new IntegerKey(74), new IntegerMove(0)); //k
		this.mapped.put(new IntegerKey(75), new IntegerMove(1)); //j
		this.mapped.put(new IntegerKey(78), BasicActions.MOUSE_LEFT_CLICK); //n
		this.mapped.put(new IntegerKey(77), BasicActions.MOUSE_MIDDLE_CLICK); //m
		this.mapped.put(new IntegerKey(44), BasicActions.MOUSE_RIGHT_CLICK); //,
	}

	@Override
	public Action getAction(Key key) {
		return mapped.get(key);
	}
}