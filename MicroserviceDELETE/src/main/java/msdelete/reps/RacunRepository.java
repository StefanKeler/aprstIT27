package msdelete.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import msdelete.jpa.Racun;

public interface RacunRepository extends JpaRepository<Racun, Integer>{
	Collection<Racun> findByNacinPlacanjaContainingIgnoreCase(String NacinPlacanja);
}
