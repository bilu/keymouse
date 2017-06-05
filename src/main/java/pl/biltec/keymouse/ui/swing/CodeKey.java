package pl.biltec.keymouse.ui.swing;

import pl.biltec.keymouse.application.Key;

public class CodeKey implements Key {

	private int code;

	public CodeKey(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CodeKey that = (CodeKey) o;

		return code == that.code;

	}

	@Override
	public int hashCode() {
		return code;
	}
}
