package get.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import get.reps.ProizvodjacRepository;
import get.jpa.StavkaRacuna;
import get.reps.StavkaRacunaRepository;
import get.jpa.Racun;
import get.reps.RacunRepository;
import get.jpa.Proizvod;
import get.reps.ProizvodRepository;
import get.jpa.Proizvodjac;


@RestController
public class GETRestController {

	@Autowired
	private ProizvodjacRepository proizvodjacRepository;
	@Autowired
	private ProizvodRepository proizvodRepository;
	@Autowired
	private RacunRepository racunRepository;
	@Autowired
	private StavkaRacunaRepository stavkaRacunaRepository;

	@GetMapping("proizvodjac")
	public Collection<Proizvodjac> getProizvodjaci(){
		return proizvodjacRepository.findAll();
	}
	
	@GetMapping("proizvodjac/{id}")
	public Proizvodjac getProizvodjac(@PathVariable("id") Integer id){
		return proizvodjacRepository.getOne(id);
	}
	
	@GetMapping("proizvodjacNaziv/{naziv}")
	public Collection<Proizvodjac> getProizvodjacByNaziv(@PathVariable("naziv") String naziv){
		return proizvodjacRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@GetMapping("proizvod")
	public Collection<Proizvod> getProizvodi(){
		return proizvodRepository.findAll();
	}
	
	@GetMapping("proizvod/{id}")
	public Proizvod getProizvod(@PathVariable("id") Integer id){
		return proizvodRepository.getOne(id);
	}
	
	@GetMapping("proizvodNaziv/{naziv}")
	public Collection<Proizvod> getProizvodByNaziv(@PathVariable("naziv") String naziv){
		return proizvodRepository.findByNazivContainingIgnoreCase(naziv);
	}
	@GetMapping("racun")
	public Collection<Racun> getRacuni(){
		return racunRepository.findAll();
	}
	
	@GetMapping("racun/{id}")
	public Racun getRacun(@PathVariable("id") Integer id){
		return racunRepository.getOne(id);
	}
	
	@GetMapping("stavkaRacuna")
	public Collection<StavkaRacuna> getStavkeRacuna(){
		return stavkaRacunaRepository.findAll();
	}

	@GetMapping("stavkaRacuna/{id}")
	public ResponseEntity<StavkaRacuna> getStavkaRacuna(@PathVariable("id") Integer id){
		StavkaRacuna stavkaRacuna = stavkaRacunaRepository.getOne(id);
		return new ResponseEntity<StavkaRacuna>(stavkaRacuna, HttpStatus.OK);
	}

	@GetMapping("stavkeZaRacun/{id}")
	public Collection<StavkaRacuna> stavkaPoPorudzbiniId(@PathVariable("id") int id){
		Racun p = racunRepository.getOne(id);
		return stavkaRacunaRepository.findByRacun(p);
	}
	
}
