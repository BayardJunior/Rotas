package br.com.apirest.service;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.apirest.model.Route;
import br.com.apirest.repository.RouteRepository;

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
		getRouteFromGoogleDirections(route);
		repository.save(route);
	}

	private void getRouteFromGoogleDirections(Route route) {
		try {
			String url = "https://maps.googleapis.com/maps/api/directions/json";
			int z = 0;
			StringBuilder wayPoints = new StringBuilder();

			for (int i = 1; i < route.getStops().size() - 1; i++) {
				z = route.getStops().size() - 1;
				wayPoints.append(route.getStops().get(i).getPosition().getLat()).append(",");
				wayPoints.append(route.getStops().get(i).getPosition().getLng()).append("|");
				System.out.println("-> " + wayPoints.toString());
				System.out.println("\n");
			}
			/*
			 * Sempre a primeira coordenada do Json vai ser o ponto de inicio da
			 * minha rota O ultimo ponto do Json, será o ponto do parada.
			 */
			URI uri = UriComponentsBuilder.fromUriString(url)
					.queryParam("origin",
							route.getStops().get(0).getPosition().getLat() + ","
									+ route.getStops().get(0).getPosition().getLng()) // primeiro
					.queryParam("destination",
							route.getStops().get(z).getPosition().getLat() + ","
									+ route.getStops().get(z).getPosition().getLng()) // ultimo
					.queryParam("waypoints", wayPoints.toString())
					.queryParam("key", "AIzaSyBlF6yNQ_2gbJSyIaiDnz0cuslaWWjNs_Q").build().toUri();

			System.out.println(uri);
			String response = restTemplate.getForObject(uri, String.class);

			System.out.println(response);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public List<Route> findAll() {
		return repository.findAll();
	}
}
