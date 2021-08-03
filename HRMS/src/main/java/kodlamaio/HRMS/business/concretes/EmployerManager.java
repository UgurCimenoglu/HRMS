package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao empolyerDao;

	public EmployerManager(EmployerDao empolyerDao) {
		super();
		this.empolyerDao = empolyerDao;
	}

	@Override
	public Result Add(Employer employer) {
		empolyerDao.save(employer);
		return new SuccessResult("Employer registration successful");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		var result = empolyerDao.findAll();
		return new SuccessDataResult<List<Employer>>(result, "Employers has been listed");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.empolyerDao.getById(id));
	}

}
