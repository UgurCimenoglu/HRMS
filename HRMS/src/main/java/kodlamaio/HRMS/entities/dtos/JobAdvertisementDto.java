package kodlamaio.HRMS.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {
	private String employerName;
	private String jobTitle;
	private int openPosition;
	private Date createDate;
	private Date deadline;
}
