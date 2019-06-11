package post.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import post.jpa.Proizvodjac;
import post.reps.ProizvodjacRepository;
import post.jpa.Proizvod;
import post.jpa.Racun;
import post.jpa.StavkaRacuna;
import post.reps.ProizvodRepository;
import post.reps.RacunRepository;
import post.reps.StavkaRacunaRepository;


@RestController
public class PostRestController {
	
	
	@Autowired
	private ProizvodjacRepository proizvodjacRepository;
	@Autowired
	private ProizvodRepository proizvodRepository;
	@Autowired
	private RacunRepository racunRepository;
	@Autowired
	private StavkaRacunaRepository stavkaRacunaRepository;
	
	@CrossOrigin
	@PostMapping("proizvodjac")
	public ResponseEntity<Proizvodjac> insertProizvodjac(@RequestBody Proizvodjac proizvodjac){
		if(proizvodjacRepository.existsById(proizvodjac.getId()))
				return new ResponseEntity<>(HttpStatus.CONFLICT);
		proizvodjacRepository.save(proizvodjac);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@CrossOrigin
	@PostMapping("proizvod")
	public ResponseEntity<HttpStatus> insertProizvod(@RequestBody Proizvod proizvod){
		if(proizvodRepository.existsById(proizvod.getId()))
				return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		proizvodRepository.save(proizvod);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	

	@CrossOrigin
	@PostMapping("racun")
	public ResponseEntity<Racun> insertRacun(@RequestBody Racun racun){
		if(racunRepository.existsById(racun.getId()))
				return new ResponseEntity<>(HttpStatus.CONFLICT);
		racunRepository.save(racun);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("stavkaRacuna")
	public ResponseEntity<Void> insertStavkaRacuna(@RequestBody StavkaRacuna stavkaRacuna){
		System.out.println("uso ");
		if(stavkaRacunaRepository.existsById(stavkaRacuna.getId()))
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		stavkaRacuna.setRedniBroj(stavkaRacunaRepository.nextRBr(stavkaRacuna.getRacun().getId()));
		System.out.println(stavkaRacuna.getRacun().getId());
		System.out.println(stavkaRacunaRepository.nextRBr(stavkaRacuna.getRacun().getId()));
		stavkaRacunaRepository.save(stavkaRacuna);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
