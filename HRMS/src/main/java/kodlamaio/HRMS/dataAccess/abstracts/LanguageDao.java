package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
	List<Language> getAllBycandidateCurriculumVitaes_Id(int cvId);
}
