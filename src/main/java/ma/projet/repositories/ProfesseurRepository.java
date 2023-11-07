package ma.projet.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import ma.projet.entities.Professeur;
import ma.projet.entities.Specialite;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {

	@Query("SELECT p FROM Professeur p WHERE p.dateEmbauche BETWEEN :dateDebut AND :dateFin")
	List<Professeur> professeursRecrutesEntreDeuxDates(Date dateDebut, Date dateFin);
	public List<Professeur> findBySpecialite(Specialite specialite);
	 
}
