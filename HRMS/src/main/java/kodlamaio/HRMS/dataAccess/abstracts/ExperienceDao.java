package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {

	List<Experience> getAllByCandidateCurriculumVitaes_IdOrderByLeaveDateDesc(int cvId);
}
