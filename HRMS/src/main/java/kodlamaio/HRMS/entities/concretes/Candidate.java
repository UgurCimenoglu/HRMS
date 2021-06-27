package kodlamaio.HRMS.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidates")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class Candidate extends User {

	@OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
	@JsonManagedReference
	private CandidateCurriculumVitae candidateCurriculumVitae;

	@Column(name = "first_name")
	@NotNull
	@NotBlank
	private String firstName;

	@Column(name = "last_name")
	@NotNull
	@NotBlank
	private String lastName;
	
	@Column(name = "identity_number")
	@NotNull
	@Length(min = 11,max = 11)
	private String nationalityNumber;

	@Column(name = "birth_year")
	@NotNull
	private int birthDate;

	public Candidate(String email, String password, String firstName, String lastName, String nationalityNumber,
			int birthDate) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityNumber = nationalityNumber;
		this.birthDate = birthDate;
	}
}
