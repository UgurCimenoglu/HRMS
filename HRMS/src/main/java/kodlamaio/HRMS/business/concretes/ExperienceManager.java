package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ExperienceService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.ExperienceDao;
import kodlamaio.HRMS.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService{

	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<Experience>> getAllByCvIdDesc(int cvId) {
		return new SuccessDataResult<List<Experience>>(experienceDao.getAllByCandidateCurriculumVitaes_IdOrderByLeaveDateDesc(cvId),"İş deneyimleri listelendi.");
	}

}
