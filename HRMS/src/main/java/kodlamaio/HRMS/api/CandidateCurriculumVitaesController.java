package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.HRMS.business.abstracts.CandidateCurriculumVitaeService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateCurriculumVitae;

@RestController
@RequestMapping("/api/candidatecv")
public class CandidateCurriculumVitaesController {
	private CandidateCurriculumVitaeService candidateCurriculumVitaeService;

	@Autowired
	public CandidateCurriculumVitaesController(CandidateCurriculumVitaeService candidateCurriculumVitaeService) {
		super();
		this.candidateCurriculumVitaeService = candidateCurriculumVitaeService;
	}

	@GetMapping("/getall")
	public DataResult<List<CandidateCurriculumVitae>> getall() {
		return this.candidateCurriculumVitaeService.getAll();
	}

	@PostMapping(value = "/add")
	public Result add(@RequestBody CandidateCurriculumVitae candidateCurriculumVitae) {
		return this.candidateCurriculumVitaeService.add(candidateCurriculumVitae);
	}

}
