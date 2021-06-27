package kodlamaio.HRMS.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidate_curriculum_vitaes")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@Valid
public class CandidateCurriculumVitae {

	@Id
	@Column(name = "id")
	private int id;

	
	@OneToOne
	@JsonBackReference
	@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
	private Candidate candidate;

	@JsonManagedReference
	@OneToMany(mappedBy = "candidateCurriculumVitaes", cascade = CascadeType.ALL)
	private List<Language> languages;

	@JsonManagedReference
	@OneToMany(mappedBy = "candidateCurriculumVitaes", cascade = CascadeType.ALL)
	private List<Skill> skills;

	@JsonManagedReference
	@OneToMany(mappedBy = "candidateCurriculumVitaes", cascade = CascadeType.ALL)
	private List<Education> educations;

	@JsonManagedReference
	@OneToMany(mappedBy = "candidateCurriculumVitaes", cascade = CascadeType.ALL)
	private List<Experience> experiences;

	@JsonManagedReference
	@OneToMany(mappedBy = "candidateCurriculumVitaes", cascade = CascadeType.ALL)
	private List<Link> links;

	@JsonManagedReference
	@OneToOne(mappedBy = "candidateCurriculumVitaes", cascade = CascadeType.ALL)
	private Image image;
	
	@Column(name = "cover_letter")
	@NotNull
	@NotBlank
	private String coverLetter;

	@Column(name = "create_date")
	private Date createDate;

}
