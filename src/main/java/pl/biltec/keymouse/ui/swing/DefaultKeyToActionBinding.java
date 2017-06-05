package pl.biltec.keymouse.ui.swing;

import pl.biltec.keymouse.application.Action;
import pl.biltec.keymouse.application.BasicActions;
import pl.biltec.keymouse.application.Key;
import pl.biltec.keymouse.application.KeyToActionBinding;

import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DefaultKeyToActionBinding implements KeyToActionBinding, Iterable<Key> {

	private Map<Key, Action> mapped = new HashMap<>();

	public DefaultKeyToActionBinding() {
		this.mapped.put(new CodeKey(27), BasicActions.EXIT); //esc
		this.mapped.put(new CodeKey(8), BasicActions.UNDO); //backspace

		this.mapped.put(new CodeKey(85), new MatrixMove(0, 0)); //u
		this.mapped.put(new CodeKey(73), new MatrixMove(1, 0)); //i
		this.mapped.put(new CodeKey(79), new MatrixMove(2, 0)); //o
		this.mapped.put(new CodeKey(74), new MatrixMove(0, 1)); //j
		this.mapped.put(new CodeKey(75), new MatrixMove(1, 1)); //k
		this.mapped.put(new CodeKey(76), new MatrixMove(2, 1)); //l
		this.mapped.put(new CodeKey(77), new MatrixMove(0, 2)); //m
		this.mapped.put(new CodeKey(44), new MatrixMove(1, 2)); //,
		this.mapped.put(new CodeKey(46), new MatrixMove(2, 2)); //.

		this.mapped.put(new CodeKey(83), BasicActions.MOUSE_LEFT_CLICK); //s
		this.mapped.put(new CodeKey(68), BasicActions.MOUSE_MIDDLE_CLICK); //d
		this.mapped.put(new CodeKey(70), BasicActions.MOUSE_RIGHT_CLICK); //f


		this.mapped.put(new CodeKey(81), BasicActions.MOUSE_SCROLL_UP); //q
		this.mapped.put(new CodeKey(65), BasicActions.MOUSE_SCROLL_DOWN); //a
	}

	@Override
	public Action getAction(Key key) {
		return mapped.get(key);
	}

	@Override
	public String getKeyName(Action action) {
		Key key = mapped.keySet().stream().filter(k -> mapped.get(k).equals(action)).findFirst().orElseThrow(() -> new RuntimeException("WTF"));
		return getKeyName(key);
	}

	@Override
	public String getKeyName(Key key) {
		if (key instanceof CodeKey) {
			return "" + (char)KeyStroke.getKeyStroke(((CodeKey) key).getCode(), 0).getKeyCode();
//			return String.valueOf(KeyStroke.getKeyStroke(((CodeKey) key).getCode(), 0).getKeyChar());
		}
		return "UPS!";
	}

	@Override
	public Iterator<Key> iterator() {
		return mapped.keySet().iterator();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName()).append("\n");
		this.forEach(k -> {
			sb.append(String.format("\t%20s\t->\t%s\n", this.getKeyName(k), this.getAction(k)));

		});
		return sb.toString();
	}
}