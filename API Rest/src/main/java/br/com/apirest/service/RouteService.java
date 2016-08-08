package br.com.apirest.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.apirest.model.Coordinate;
import br.com.apirest.model.Route;
import br.com.apirest.repository.RouteRepository;
import br.com.apirest.service.google.GoogleRoute;

@Service
public class RouteService {

	private final RestTemplate restTemplate;
	private final RouteRepository repository;

	@Autowired
	public RouteService(RouteRepository repository) {
		this.restTemplate = new RestTemplate();
		this.repository = repository;
	}

	public void make(Route route) {
		
		route.setRouteDate(new Date());
		route.setPosition(getRouteFromGoogleDirections(route));
		repository.save(route);
	}

	private List<Coordinate> getRouteFromGoogleDirections(Route route) {
		try {
			String url = "https://maps.googleapis.com/maps/api/directions/json";

			List<String> wayPoints = new ArrayList<>();
			for (int i = 1; i < route.getStops().size() - 1; i++) {
				Coordinate current = route.getStops().get(i).getPosition();
				wayPoints.add(current.toString());
			}
			Coordinate primeiro = route.getStops().get(0).getPosition();
			Coordinate ultimo = route.getStops().get(route.getStops().size() - 1).getPosition();

			URI uri = UriComponentsBuilder.fromUriString(url).queryParam("origin", primeiro.toString())
					.queryParam("destination", ultimo.toString()).queryParam("waypoints", String.join("|", wayPoints))
					.queryParam("key", "AIzaSyBlF6yNQ_2gbJSyIaiDnz0cuslaWWjNs_Q").build().toUri();

			GoogleRoute googleRoute = restTemplate.getForObject(uri, GoogleRoute.class);

			return googleRoute.getCoordinate();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	public List<Route> findAll() {
		return repository.findAll();
	}
}
