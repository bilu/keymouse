package pl.biltec.keymouse.domain;

import java.util.Optional;

public class Area {

	private int top;
	private int left;
	private int width;
	private int height;
	private int mouseX;
	private int mouseY;
	private int splitLevel;
	private Orientation orientation;
	private Optional<Area> parent = Optional.empty();


	public Area(int left, int top, int width, int height, int splitLevel) {
		//TODO assert
		this.top = top;
		this.left = left;
		this.width = width;
		this.height = height;
		this.mouseX = left + width / 2;
		this.mouseY = top + height / 2;
		this.splitLevel = splitLevel;
		this.orientation = (width > height) ? Orientation.LANDSCAPE : Orientation.PORTRAIT;
	}

	Area(int left, int top, int width, int height, int splitLevel, Area parent) {
		//TODO assert
		this(left, top, width, height, splitLevel);
		this.parent = Optional.of(parent);
	}

	/**
	 * @param position <0; splitLevel)
	 * @return
	 */
	public Area fromLeftTop(int position) {
		int normPosition = position % splitLevel;

		if (orientation == Orientation.LANDSCAPE) {
			int newWidth = width / splitLevel;
			int newLeft = left + newWidth * normPosition;
			return new Area(newLeft, top, newWidth, height, splitLevel, this);
		} else {
			int newHeight = height / splitLevel;
			int newTop = top + newHeight * normPosition;
			return new Area(left, newTop, width, newHeight, splitLevel, this);
		}
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
		if (splitLevel != area.splitLevel) return false;
		return orientation == area.orientation;

	}

	public int getTop() {
		return top;
	}

	public int getLeft() {
		return left;
	}

	@Override
	public int hashCode() {
		int result = top;
		result = 31 * result + left;
		result = 31 * result + width;
		result = 31 * result + height;
		result = 31 * result + mouseX;
		result = 31 * result + mouseY;
		result = 31 * result + splitLevel;
		result = 31 * result + (orientation != null ? orientation.hashCode() : 0);
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
				", splitLevel=" + splitLevel +
				", orientation=" + orientation +
				", parent=" + parent +
				'}';
	}
}
