package kodlamaio.HRMS.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.VerificationService;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessResult;

@Service
public class VerificationManager implements VerificationService{

	@Override
	public Result sendVerificationCode(String email) {
	
		return new SuccessResult(email +" verification code sent to email address."); 
		
	}

}
