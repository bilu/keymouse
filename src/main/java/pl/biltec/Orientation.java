package pl.biltec;

enum Orientation {

	PORTRAIT,
	LANDSCAPE;

	//TODO uzywane?
	public Orientation next() {
		return (this == PORTRAIT) ? LANDSCAPE : PORTRAIT;
	}
}
