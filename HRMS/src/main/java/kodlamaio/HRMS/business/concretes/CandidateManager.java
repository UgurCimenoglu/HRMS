package kodlamaio.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;
import kodlamaio.HRMS.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public Result Add(Candidate candidate) {
		candidateDao.save(candidate);
		return new SuccessResult("Candidate registration successful");
	}

	@Override
	public DataResult<Candidate> getByNationalityNumber(String nationalityNumber) {
		var result = candidateDao.getByNationalityNumber(nationalityNumber);
		if (result != null) {
			return new SuccessDataResult<Candidate>(result, "User available for nationality number.");
		}
		return new ErrorDataResult<Candidate>("No user found with this number");
	}

}
