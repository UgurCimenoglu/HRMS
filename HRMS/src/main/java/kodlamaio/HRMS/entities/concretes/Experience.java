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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "experiences")
@AllArgsConstructor
@NoArgsConstructor
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "candidate_cv_id", referencedColumnName = "id")
	private CandidateCurriculumVitae candidateCurriculumVitaes;

	@Column(name = "workplace_name")
	@NotNull
	@NotBlank
	private String workplaceName;

	@Column(name = "position_name")
	@NotNull
	@NotBlank
	private String positionName;

	@Column(name = "start_date")
	@NotNull
	@NotBlank
	private Date startDate;

	@Column(name = "leave_date")
	private Date leaveDate;
}
