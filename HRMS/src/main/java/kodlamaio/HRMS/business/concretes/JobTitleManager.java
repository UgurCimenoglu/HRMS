package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobTitleService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.ErrorResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobTitleDao;
import kodlamaio.HRMS.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll(), "Job titles has been listed.");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		var result = checkIfJobTitleExist(jobTitle.getTitle());
		if (!result.isSuccess()) {
			jobTitleDao.save(jobTitle);
			return new SuccessResult("Job title has been added.");
		}
		return new ErrorResult("Job title could not added, because this title has already been added");

	}

	// Business Rules

	public Result checkIfJobTitleExist(String title) {
		var jobTitle = jobTitleDao.getByTitle(title);
		if (jobTitle != null) {
			System.out.println(jobTitle);
			return new SuccessResult("Job title has been found.");
		}
		return new ErrorResult("Job title not found");
	}
}
