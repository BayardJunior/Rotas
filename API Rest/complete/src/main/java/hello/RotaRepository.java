
package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RotaRepository extends MongoRepository<Rota, Integer> {
	
	public List<Rota> findAll();

}