package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ExperienceService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

	private ExperienceService experienceService;

	@Autowired
	public ExperienceController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}

	@GetMapping("/getallbycviddesc")
	public DataResult<List<Experience>> getAllByCvIdDesc(@RequestParam int cvId) {
		return experienceService.getAllByCvIdDesc(cvId);
	}
}
