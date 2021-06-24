package kodlamaio.HRMS.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identity_number")
	private String nationalityNumber;

	@Column(name = "birth_year")
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
