package hello;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class ParadasController {
	
	@Autowired
	private RotaRepository repository;

	Gson gson;
	Rota rota;

	public ParadasController() {
		// TODO Auto-generated constructor stub
		gson = new Gson();
		rota = new Rota();
	}

	@RequestMapping(value = "/rotas", method = RequestMethod.GET)
	public ResponseEntity<List<Rota>> findAll() {
		return new ResponseEntity<List<Rota>>(repository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/rotas", method = RequestMethod.POST)
	@ResponseBody
	public void post(@RequestBody String parada) {
	
		
		Paradas p = gson.fromJson(parada, Paradas.class);
		
		rota.setVehicleId(p.getVehicleId());
		rota.setRouteDate(new Date());
		rota.setParadas(Arrays.asList(p.getParada()));
		
		
		for (int i = 0; i < rota.getParadas().size(); i++) {
			rota.setName(rota.getParadas().get(i).getName());
			rota.addCoor(rota.getParadas().get(i).getPosition());
		}
		
		repository.save(rota);
	}
}
