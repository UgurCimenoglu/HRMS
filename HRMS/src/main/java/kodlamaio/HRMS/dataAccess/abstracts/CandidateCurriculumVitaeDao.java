package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.CandidateCurriculumVitae;

public interface CandidateCurriculumVitaeDao extends JpaRepository<CandidateCurriculumVitae, Integer>{
	CandidateCurriculumVitae getById(int id);
}
