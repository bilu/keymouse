package pl.biltec.keymouse.ui.swing;

import pl.biltec.keymouse.application.Key;

public class IntegerKey implements Key {

	private int code;

	public IntegerKey(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		IntegerKey that = (IntegerKey) o;

		return code == that.code;

	}

	@Override
	public int hashCode() {
		return code;
	}
}
