package pl.biltec.keymouse.ui.swing;

import pl.biltec.keymouse.application.Move;

public class IntegerMove implements Move {
	private int number;

	public IntegerMove(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		IntegerMove that = (IntegerMove) o;

		return number == that.number;

	}

	@Override
	public String toString() {
		return "IntegerMove{" +
				"number=" + number +
				'}';
	}

	@Override
	public int hashCode() {


		return number;
	}
}
