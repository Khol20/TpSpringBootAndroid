package ma.projet.controller;

import java.sql.Date;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.projet.entities.Professeur;
import ma.projet.entities.Specialite;
import ma.projet.service.ProfesseurService;
import ma.projet.service.SpecialiteService;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

	@Autowired
	private ProfesseurService service;
	private SpecialiteService serviceSpecialite;

	@GetMapping
	public List<Professeur> findAllProfesseur() {
		return service.findAll();
	}

	@PostMapping
	public Professeur createProfesseur(@RequestBody Professeur professeur) {
		professeur.setId(0);
		return service.create(professeur);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Professeur professeur = service.findById(id);
		if (professeur == null) {
			return new ResponseEntity<Object>("Professeur avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(professeur);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProfesseur(@PathVariable int id, @RequestBody Professeur newProfesseur) {
		Professeur oldProfesseur = service.findById(id);
		if (oldProfesseur == null) {
			return new ResponseEntity<Object>("Professeur avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newProfesseur.setId(id);
			return ResponseEntity.ok(service.update(newProfesseur));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProfesseur(@PathVariable int id) {
		Professeur professeur = service.findById(id);
		if (professeur == null) {
			return new ResponseEntity<Object>("Professeur avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			service.delete(professeur);
			return ResponseEntity.ok("professeur supprimé");
		}
	}
	
	@GetMapping("/{dateDebut}/{dateFin}")
	public List<Professeur> getProfesseursRecrutesEntreDeuxDates(@PathVariable Date dateDebut,@PathVariable Date dateFin){
		return service.findProfesseursEntreDeuxDates(dateDebut, dateFin);
	}
	
	@GetMapping("/specialites")
	public List<Professeur> findBySpecialite(@RequestBody Specialite specialite) {
	
		return service.finBySpecialite(specialite);
	}
	
}
