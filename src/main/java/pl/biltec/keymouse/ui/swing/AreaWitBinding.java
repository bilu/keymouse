package pl.biltec.keymouse.ui.swing;

import pl.biltec.keymouse.domain.Area;

public class AreaWitBinding {

	private Area area;
	private String binding;

	public AreaWitBinding(Area area, String binding) {
		this.area = area;
		this.binding = binding;
	}

	public Area getArea() {
		return area;
	}

	public String getBinding() {
		return binding;
	}
}
