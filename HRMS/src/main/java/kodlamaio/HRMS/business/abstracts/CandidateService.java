package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<Candidate> getByNationalityNumber(String nationalityNumber);
	Result Add(Candidate candidate);
}
