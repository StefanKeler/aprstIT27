package msdelete.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import msdelete.jpa.Proizvodjac;
import msdelete.jpa.Racun;
import msdelete.jpa.StavkaRacuna;
import msdelete.reps.ProizvodRepository;
import msdelete.reps.ProizvodjacRepository;
import msdelete.reps.RacunRepository;
import msdelete.reps.StavkaRacunaRepository;



@RestController
public class DeleteRestController {
	@Autowired
	private ProizvodjacRepository proizvodjacRepository;
	@Autowired
	private ProizvodRepository proizvodRepository;
	@Autowired
	private RacunRepository racunRepository;
	@Autowired
	private StavkaRacunaRepository stavkaRacunaRepository;
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("proizvodjac/{id}")
	public ResponseEntity<Proizvodjac> deleteProizvodjac(@PathVariable("id") Integer id){
		if(proizvodjacRepository.existsById(id)){
			proizvodjacRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("proizvod/{id}")
	public ResponseEntity<HttpStatus> deleteProizvod(@PathVariable("id") Integer id){
		if(proizvodRepository.existsById(id)){
			proizvodRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@CrossOrigin
	@Transactional
	@DeleteMapping("racun/{id}")
	public ResponseEntity<Racun> deleteRacun(@PathVariable("id") Integer id){
		if(racunRepository.existsById(id)){
			racunRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@CrossOrigin
	@DeleteMapping ("stavkaRacuna/{id}")
	public ResponseEntity<StavkaRacuna> deleteStavkaRacuna(@PathVariable("id") Integer id){
		if(!stavkaRacunaRepository.existsById(id))
			return new ResponseEntity<StavkaRacuna>(HttpStatus.NO_CONTENT);
		stavkaRacunaRepository.deleteById(id);
		return new ResponseEntity<StavkaRacuna>(HttpStatus.OK);
	}
}
