package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer> {
	List<Skill> findAllBycandidateCurriculumVitaes_Id(int cvId);
}
