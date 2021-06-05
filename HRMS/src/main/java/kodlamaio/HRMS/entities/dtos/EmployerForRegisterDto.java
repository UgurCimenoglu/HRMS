package kodlamaio.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForRegisterDto {

	private String email;
	private String password;
	private String rePassword;
	private String companyName;
	private String webAddress;
	private String phoneNumber;

}
