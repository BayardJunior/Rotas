package hello;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Rota {

	@Id
	private String name;
	private Date routeDate;
	private Integer vehicleId;
	private Integer id;
	private List<Parada> paradas;
	private List<Coordenada> position;

	public Rota() {
		
		position = new ArrayList<Coordenada>();
		
	}

	public Rota(String nome, Integer id) {
		this.name = nome;
		this.vehicleId = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Parada> getParadas() {
		return paradas;
	}

	public void setParadas(List<Parada> paradas) {
		this.paradas = paradas;
	}

	public List<Coordenada> getPosition() {
		return position;
	}

	public void setPosition(List<Coordenada> position) {
		this.position = position;
	}

	public void addCoor(Coordenada c) {
		this.position.add(c);
	}

}
