package put.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import put.reps.ProizvodRepository;
import put.reps.ProizvodjacRepository;
import put.reps.RacunRepository;
import put.reps.StavkaRacunaRepository;
import put.jpa.Proizvod;
import put.jpa.Proizvodjac;
import put.jpa.Racun;
import put.jpa.StavkaRacuna;



@RestController
public class PUTRestController {
	@Autowired
	private ProizvodjacRepository proizvodjacRepository;
	@Autowired
	private ProizvodRepository proizvodRepository;
	@Autowired
	private RacunRepository racunRepository;
	@Autowired
	private StavkaRacunaRepository stavkaRacunaRepository;
	
	@CrossOrigin
	@PutMapping("proizvodjac")
	public ResponseEntity<Proizvodjac> updateProizvodjac(@RequestBody Proizvodjac proizvodjac){
		if(proizvodjacRepository.existsById(proizvodjac.getId())){
			proizvodjacRepository.save(proizvodjac);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@PutMapping("proizvod")
	@ApiOperation(value = "Modifikuje postojeći proizvod iz bazu podataka")
	public ResponseEntity<HttpStatus> updateProizvod(@RequestBody Proizvod proizvod){
		if(proizvodRepository.existsById(proizvod.getId())){
			proizvodRepository.save(proizvod);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@PutMapping("racun")
	public ResponseEntity<Racun> updateRacun(@RequestBody Racun racun){
		if(racunRepository.existsById(racun.getId())){
			racunRepository.save(racun);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@PutMapping(value = "stavkaRacuna")
	public ResponseEntity<Void> updateStavkaRacuna(@RequestBody StavkaRacuna stavkaRacuna){
		if(!stavkaRacunaRepository.existsById(stavkaRacuna.getId()))
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		stavkaRacunaRepository.save(stavkaRacuna);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
