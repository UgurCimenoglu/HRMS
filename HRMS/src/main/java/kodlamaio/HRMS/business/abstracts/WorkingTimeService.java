package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.entities.concretes.WorkingTime;

public interface WorkingTimeService {
	
	DataResult<List<WorkingTime>> getAll();
}
