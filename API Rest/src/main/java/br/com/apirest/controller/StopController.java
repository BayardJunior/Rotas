package br.com.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.model.Route;
import br.com.apirest.service.RouteService;

@RestController
public class StopController {
	
	@Autowired
	private RouteService routeService;
	
	@RequestMapping(value = "/rotas", method = RequestMethod.GET)
	public List<Route> findAll() {
		return routeService.findAll();
	}

	@RequestMapping(value = "/rotas", method = RequestMethod.POST)
	public void post(@RequestBody Route route) {
		routeService.make(route);
	}
}