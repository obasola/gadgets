package com.kumasi;

public enum Rating {
	G, PG, PG_13, NC_17, R, MA;

	public String getRating() {
		switch (this) {
		case G:
			return "G";
		case PG:
			return "PG";
		case PG_13:
			return "PG-13";
		case NC_17:
			return "NC-17";
		case R:
			return "R";
		case MA:
			return "MA";
		default:
			return null;
		}
	}
}
