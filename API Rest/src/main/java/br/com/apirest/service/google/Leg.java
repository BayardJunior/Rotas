package br.com.apirest.service.google;

import br.com.apirest.model.Coordinate;

public class Leg {

	private Coordinate start_location;
	private Coordinate end_location;

	public Leg() {

	}

	public Coordinate getStart_location() {
		return start_location;
	}

	public void setStart_location(Coordinate start_location) {
		this.start_location = start_location;
	}

	public Coordinate getEnd_location() {
		return end_location;
	}

	public void setEnd_location(Coordinate end_location) {
		this.end_location = end_location;
	}

}