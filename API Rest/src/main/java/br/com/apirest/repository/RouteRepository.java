package br.com.apirest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.apirest.model.Route;

public interface RouteRepository extends MongoRepository<Route, String> {
	
}