package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {
	List<Education> findAllByCandidateCurriculumVitaes_IdOrderByGraduateDateDesc(int cvId);
}
