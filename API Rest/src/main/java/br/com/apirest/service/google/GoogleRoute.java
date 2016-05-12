package br.com.apirest.service.google;

import java.util.ArrayList;
import java.util.List;

import br.com.apirest.model.Coordinate;

public class GoogleRoute {

	private List<Routes> routes;

	public List<Routes> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Routes> routes) {
		this.routes = routes;
	}

	public List<Coordinate> getCoordinate() {
		List<Coordinate> coordinates = new ArrayList<>();
		for (Routes route : routes) {
			for (Leg leg : route.getLegs()) {
				coordinates.add(leg.getStart_location());
				coordinates.add(leg.getEnd_location());
			}
		}
		return coordinates;
	}
}