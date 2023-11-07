package ma.projet.service;

import java.sql.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.projet.dao.IDao;
import ma.projet.entities.Professeur;
import ma.projet.entities.Specialite;
import ma.projet.repositories.ProfesseurRepository;

@Service
public class ProfesseurService implements IDao<Professeur> {

	@Autowired
	private ProfesseurRepository repository;

	@Override
	public Professeur create(Professeur o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Professeur o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Professeur update(Professeur o) {
		return repository.save(o);
	}

	@Override
	public Professeur findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Professeur> findAll() {
		return repository.findAll();
	}

	public List<Professeur> findProfesseursEntreDeuxDates(Date dateDebut, Date dateFin) {
        return repository.professeursRecrutesEntreDeuxDates(dateDebut, dateFin);
    }
	
	public List<Professeur> finBySpecialite(Specialite specialite) {
		return repository.findBySpecialite(specialite);
	}
}
