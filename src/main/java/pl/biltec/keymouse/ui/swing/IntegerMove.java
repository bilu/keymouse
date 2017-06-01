package pl.biltec.keymouse.ui.swing;

import pl.biltec.keymouse.application.Move;

public class IntegerMove implements Move {
	private int horizontal;
	private int vertical;

	public IntegerMove(int horizotal, int vertical) {
		this.horizontal = horizotal;
		this.vertical = vertical;
	}

	public int getHorizontal() {
		return horizontal;
	}

	@Override
	public int vertical() {
		return vertical;
	}

	@Override
	public int horizontal() {
		return horizontal;
	}

	@Override
	public String toString() {
		return "IntegerMove{" +
				"horizontal=" + horizontal +
				", vertical=" + vertical +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		IntegerMove that = (IntegerMove) o;

		if (horizontal != that.horizontal) return false;
		return vertical == that.vertical;

	}

	@Override
	public int hashCode() {
		int result = horizontal;
		result = 31 * result + vertical;
		return result;
	}
}
