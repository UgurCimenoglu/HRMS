package kodlamaio.HRMS.api;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.AuthService;
import kodlamaio.HRMS.core.utilities.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.dtos.CandidateForRegisterDto;
import kodlamaio.HRMS.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/registercandidate")
	public Result candidateRegister(@Valid @RequestBody CandidateForRegisterDto candidateForRegisterDto) {
		return authService.candidateRegister(candidateForRegisterDto);
	};

	@PostMapping("/registeremployer")
	public Result employerRegister(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
		return authService.employerRegister(employerForRegisterDto);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Dogrulama Hatalari...");
		return errors;
	}
}
