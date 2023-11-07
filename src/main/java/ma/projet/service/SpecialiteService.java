package ma.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.dao.IDao;
import ma.projet.entities.Specialite;
import ma.projet.repositories.SpecialiteRepository;

@Service
public class SpecialiteService implements IDao<Specialite> {

	@Autowired
	private SpecialiteRepository repository;

	@Override
	public Specialite create(Specialite o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Specialite o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Specialite update(Specialite o) {
		return repository.save(o);
	}

	@Override
	public Specialite findById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Specialite> findAll() {
		return repository.findAll();
	}

}
