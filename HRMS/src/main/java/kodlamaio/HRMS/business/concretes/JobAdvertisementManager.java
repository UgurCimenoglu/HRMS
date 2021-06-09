package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Veriler Listelendi.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Is ilani eklendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByOrderByCreateDateDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByOrderByCreateDateDesc(),
				"Tarihe göre listelendi(Desc).");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByIsActive(isActive),
				"Yayinda olan ilanlar listelendi. ");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActiveAndEmployer_Id(boolean isActive,
			int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.findAllByIsActiveAndEmployer_Id(isActive, employerId),
				"Yayinda olan ilanlar listelendi. ");
	}

}
