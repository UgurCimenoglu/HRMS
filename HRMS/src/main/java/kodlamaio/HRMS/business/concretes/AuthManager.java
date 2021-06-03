package kodlamaio.HRMS.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.AuthService;
import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.business.abstracts.VerificationService;
import kodlamaio.HRMS.core.adapters.mernis.MernisAdapter;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.ErrorResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.User;
import kodlamaio.HRMS.entities.dtos.CandidateForRegisterDto;

@Service
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private ModelMapper modelMapper;
	private UserService userService;
	private VerificationService verificationService;

	@Autowired
	public AuthManager(CandidateService candidateService, ModelMapper modelMapper, UserService userService,
			VerificationService verificationService) {
		super();
		this.candidateService = candidateService;
		this.modelMapper = modelMapper;
		this.userService = userService;
		this.verificationService = verificationService;
	}

	@Override
	public Result candidateRegister(CandidateForRegisterDto candidateForRegisterDto) {

		if (!checkMernis(candidateForRegisterDto).isSuccess()) {
			return new ErrorResult("Mernis user not found.");
		}
		if (checkIfEmailExist(candidateForRegisterDto.getEmail()).isSuccess()) {
			return new ErrorResult("Email already exists");
		}
		if (checkIfNationalityNumberExist(candidateForRegisterDto.getNationalityNumber()).isSuccess()) {
			return new ErrorResult("Nationality number already exists");
		}
		
		var emailVerification = verificationService.sendVerificationCode(candidateForRegisterDto.getEmail());
		System.out.println(emailVerification);
		Candidate candidateMap = modelMapper.map(candidateForRegisterDto, Candidate.class);
		return this.candidateService.Add(candidateMap);
	}

	// Business Rules

	private Result checkMernis(CandidateForRegisterDto candidateForRegisterDto) {
		var result = MernisAdapter.validate(candidateForRegisterDto);
		if (result) {
			return new SuccessResult("Mernis User found.");
		}
		return new ErrorResult("Mernis user not found.");
	}

	private DataResult<User> checkIfEmailExist(String email) {
		return userService.getByEmail(email);
	}

	private DataResult<Candidate> checkIfNationalityNumberExist(String nationalityNumber) {
		return candidateService.getByNationalityNumber(nationalityNumber);
	}
}
