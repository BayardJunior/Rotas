package br.com.apirest.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Route {

	@Id
	private String id;
	private Date routeDate;
	private Integer vehicleId;
	private List<Stop> stops;
	private List<Coordinate> position;

	public Route() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRouteDate() {
		return routeDate;
	}

	public void setRouteDate(Date routeDate) {
		this.routeDate = routeDate;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}

	public List<Coordinate> getPosition() {
		return position;
	}

	public void setPosition(List<Coordinate> position) {
		this.position = position;
	}
}