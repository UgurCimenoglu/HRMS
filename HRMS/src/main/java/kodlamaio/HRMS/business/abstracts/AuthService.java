package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.dtos.CandidateForRegisterDto;

public interface AuthService {
	Result candidateRegister(CandidateForRegisterDto candidateForRegisterDto);
}
