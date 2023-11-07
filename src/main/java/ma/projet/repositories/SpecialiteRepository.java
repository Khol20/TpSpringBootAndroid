package ma.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.entities.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {

}
