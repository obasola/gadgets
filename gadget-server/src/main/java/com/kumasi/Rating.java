package com.kumasi;

public enum Rating {
	G, PG, PG_13, NC_17, R, MA;

	public Object getRating() {
		switch (this) {
		case G:
			return Rating.G;
		case PG:
			return Rating.PG;
		case PG_13:
			return Rating.PG_13;
		case NC_17:
			return Rating.NC_17;
		case R:
			return Rating.R;
		case MA:
			return Rating.MA;
		default:
			return null;
		}
	}
}
