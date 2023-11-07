package ma.projet.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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

import ma.projet.entities.Specialite;
import ma.projet.service.SpecialiteService;

@RestController
@RequestMapping("/api/specialites")
public class SpecialiteController {

	@Autowired
	private SpecialiteService service;

	@GetMapping
	public List<Specialite> findAllSpecialite() {
		return service.findAll();
	}

	@PostMapping
	public Specialite createSpecialite(@RequestBody Specialite specialite) {
		specialite.setId(0);
		return service.create(specialite);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Specialite specialite = service.findById(id);
		if (specialite == null) {
			return new ResponseEntity<Object>("Specialite avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(specialite);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateSpecialite(@PathVariable int id, @RequestBody Specialite newSpecialite) {
		Specialite oldSpecialite = service.findById(id);
		if (oldSpecialite == null) {
			return new ResponseEntity<Object>("Specialite avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			newSpecialite.setId(id);
			return ResponseEntity.ok(service.update(newSpecialite));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSpecialite(@PathVariable int id) {
		Specialite specialite = service.findById(id);
		if (specialite == null) {
			return new ResponseEntity<Object>("Specialite avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			service.delete(specialite);
			return ResponseEntity.ok("specialite supprimée");
		}
	}
}
