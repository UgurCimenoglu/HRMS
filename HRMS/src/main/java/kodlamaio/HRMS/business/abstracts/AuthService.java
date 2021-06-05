package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.dtos.CandidateForRegisterDto;
import kodlamaio.HRMS.entities.dtos.EmployerForRegisterDto;

public interface AuthService {
	Result candidateRegister(CandidateForRegisterDto candidateForRegisterDto);
	Result employerRegister(EmployerForRegisterDto employerForRegisterDto);
}
