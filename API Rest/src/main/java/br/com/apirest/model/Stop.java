package br.com.apirest.model;

public class Stop {

	private String name;
	private Coordinate position;

	public Stop() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinate getPosition() {
		return position;
	}

	public void setPosition(Coordinate position) {
		this.position = position;
	}
}
