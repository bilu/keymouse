package pl.biltec.keymouse.domain;

enum Orientation {

	PORTRAIT,
	LANDSCAPE;

	//TODO uzywane?
	public Orientation next() {
		return (this == PORTRAIT) ? LANDSCAPE : PORTRAIT;
	}
}
