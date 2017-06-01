package pl.biltec.keymouse.domain;

import java.util.Optional;

public class Area {

	private int top;
	private int left;
	private int width;
	private int height;
	private int mouseX;
	private int mouseY;
	private int splitHorizontal;
	private int splitVertical;
	private Optional<Area> parent = Optional.empty();


	public Area(int left, int top, int width, int height, int splitHorizontal, int splitVertical) {
		//TODO assert
		this.top = top;
		this.left = left;
		this.width = width;
		this.height = height;
		this.mouseX = left + width / 2;
		this.mouseY = top + height / 2;
		this.splitHorizontal = splitHorizontal;
		this.splitVertical = splitVertical;
	}

	Area(int left, int top, int width, int height, int splitHorizontal, int splitVertical, Area parent) {
		//TODO assert
		this(left, top, width, height, splitHorizontal, splitVertical);
		this.parent = Optional.of(parent);
	}

	public Area move(int vertical, int horizontal) {
		int nVertical = vertical % splitVertical;
		int nHorizontal = horizontal % splitHorizontal;

		int newWidth = width / splitHorizontal;
		int newHeight = height / splitVertical;
		int newLeft = left + newWidth * nHorizontal;
		int newTop = top + newHeight * nVertical;

		return new Area(newLeft, newTop, newWidth, newHeight, splitHorizontal, splitVertical, this);
	}


	public Area back() {
		return parent.orElse(this);
	}


	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public int getTop() {
		return top;
	}

	public int getLeft() {
		return left;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Area area = (Area) o;

		if (top != area.top) return false;
		if (left != area.left) return false;
		if (width != area.width) return false;
		if (height != area.height) return false;
		if (mouseX != area.mouseX) return false;
		if (mouseY != area.mouseY) return false;
		if (splitHorizontal != area.splitHorizontal) return false;
		if (splitVertical != area.splitVertical) return false;
		return parent != null ? parent.equals(area.parent) : area.parent == null;

	}

	@Override
	public int hashCode() {
		int result = top;
		result = 31 * result + left;
		result = 31 * result + width;
		result = 31 * result + height;
		result = 31 * result + mouseX;
		result = 31 * result + mouseY;
		result = 31 * result + splitHorizontal;
		result = 31 * result + splitVertical;
		result = 31 * result + (parent != null ? parent.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Area{" +
				"top=" + top +
				", left=" + left +
				", width=" + width +
				", height=" + height +
				", mouseX=" + mouseX +
				", mouseY=" + mouseY +
				", splitHorizontal=" + splitHorizontal +
				", splitVertical=" + splitVertical +
				", parent=" + parent +
				'}';
	}
}

