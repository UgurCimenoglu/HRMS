package kodlamaio.HRMS.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.AuthService;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.dtos.CandidateForRegisterDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/add")
	public Result candidateRegister(@RequestBody CandidateForRegisterDto candidateForRegisterDto) {
		return authService.candidateRegister(candidateForRegisterDto);
	};
}
