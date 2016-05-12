package br.com.apirest.model;

public class Coordinate {

	private double lat;
	private double lng;

	public Coordinate() {

	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	@Override
	public String toString() {
		return String.format("%s,%s", this.getLat(), this.getLng());
	}
}
