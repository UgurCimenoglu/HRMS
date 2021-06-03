package kodlamaio.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateForRegisterDto {
	private String firstName;
	private String lastName;
	private String nationalityNumber;
	private String email;
	private String password;
	private String rePassword;
	private int birthDate;
}
