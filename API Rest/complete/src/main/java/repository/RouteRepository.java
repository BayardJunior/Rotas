
package repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import model.Route;

public interface RouteRepository extends MongoRepository<Route, Integer> {
	
	public List<Route> findAll();

}