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

		this.mapped.put(new IntegerKey(85), new IntegerMove(0, 0)); //u
		this.mapped.put(new IntegerKey(73), new IntegerMove(1, 0)); //i
		this.mapped.put(new IntegerKey(79), new IntegerMove(2, 0)); //o
		this.mapped.put(new IntegerKey(74), new IntegerMove(0, 1)); //j
		this.mapped.put(new IntegerKey(75), new IntegerMove(1, 1)); //k
		this.mapped.put(new IntegerKey(76), new IntegerMove(2, 1)); //l
		this.mapped.put(new IntegerKey(77), new IntegerMove(0, 2)); //m
		this.mapped.put(new IntegerKey(44), new IntegerMove(1, 2)); //,
		this.mapped.put(new IntegerKey(46), new IntegerMove(2, 2)); //.

		this.mapped.put(new IntegerKey(83), BasicActions.MOUSE_LEFT_CLICK); //s
		this.mapped.put(new IntegerKey(68), BasicActions.MOUSE_MIDDLE_CLICK); //d
		this.mapped.put(new IntegerKey(70), BasicActions.MOUSE_RIGHT_CLICK); //f


		this.mapped.put(new IntegerKey(81), BasicActions.MOUSE_SCROLL_UP); //q
		this.mapped.put(new IntegerKey(65), BasicActions.MOUSE_SCROLL_DOWN); //a
	}

	@Override
	public Action getAction(Key key) {
		return mapped.get(key);
	}
}