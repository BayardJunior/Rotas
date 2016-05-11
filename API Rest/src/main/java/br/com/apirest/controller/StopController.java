package br.com.apirest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.model.Route;
import br.com.apirest.repository.RouteRepository;

@RestController
public class StopController {
	
	@Autowired
	private RouteRepository repository;

	@RequestMapping(value = "/rotas", method = RequestMethod.GET)
	public List<Route> findAll() {
		return repository.findAll();
	}

	@RequestMapping(value = "/rotas", method = RequestMethod.POST)
	public void post(@RequestBody Route route) {
		route.setRouteDate(new Date());
		repository.save(route);
	}
}