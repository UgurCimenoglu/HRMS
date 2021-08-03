package kodlamaio.HRMS.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "working_time_id")
	private WorkingTime workingTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "working_type_id")
	private WorkingType workingType;

	@Column(name = "description")
	@NotNull
	@NotBlank
	private String description;

	@Column(name = "min_salary")
	private float minSalary;

	@Column(name = "max_salary")
	private float maxSalary;

	@Column(name = "open_position")
	private int openPosition;

	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "deadline")
	private Date deadline;

	@Column(name = "is_active")
	private boolean isActive;
}
