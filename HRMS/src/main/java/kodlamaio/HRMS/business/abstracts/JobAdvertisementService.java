package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();

	Result add(JobAdvertisement jobAdvertisement);

	DataResult<List<JobAdvertisement>> findAllByOrderByCreateDateDesc();
	
	DataResult<List<JobAdvertisement>> findAllByIsActive (boolean isActive);
	
	DataResult<List<JobAdvertisement>> findAllByIsActiveAndEmployer_Id(boolean isActive, int employerId);
	
}
