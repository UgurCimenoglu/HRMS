package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.Result;

public interface VerificationService {
	Result sendVerificationCode(String email);
}
