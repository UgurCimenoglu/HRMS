package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.Employer;

public interface EmployerService {
	Result Add(Employer employer);

	DataResult<List<Employer>> getAll();
}
