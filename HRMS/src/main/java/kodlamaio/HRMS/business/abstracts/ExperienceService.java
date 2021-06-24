package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.dataAccess.abstracts.ExperienceDao;
import kodlamaio.HRMS.entities.concretes.Experience;

public interface ExperienceService {

	DataResult<List<Experience>> getAllByCvIdDesc(int cvId);
}
