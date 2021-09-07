package kodlamaio.HRMS.business.abstracts;

import java.util.List;


import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.Education;

public interface EducationService {
	DataResult<List<Education>> getAllByCvIdDesc(int cvId);
	Result add(Education education);
	Result deleteById(int id);
	
}
