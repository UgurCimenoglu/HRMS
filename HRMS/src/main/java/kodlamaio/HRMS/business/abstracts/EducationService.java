package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.entities.concretes.Education;

public interface EducationService {
	DataResult<List<Education>> getAllByCvIdDesc(int cvId);
}
