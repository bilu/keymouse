package pl.biltec.keymouse.ui.swing;

import pl.biltec.keymouse.application.Move;

public class MatrixMove implements Move {
	private int horizontal;
	private int vertical;

	public MatrixMove(int horizontal, int vertical) {
		this.horizontal = horizontal;
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
		return "MatrixMove{" +
				"horizontal=" + horizontal +
				", vertical=" + vertical +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MatrixMove that = (MatrixMove) o;

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
