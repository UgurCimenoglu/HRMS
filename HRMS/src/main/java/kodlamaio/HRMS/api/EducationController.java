package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.EducationService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.entities.concretes.Education;

@RestController
@RequestMapping("/api/education")
public class EducationController {

	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}

	@GetMapping("/getallbycviddesc")
	public DataResult<List<Education>> getAllByCvIdDesc(@RequestParam int id) {
		return this.educationService.getAllByCvIdDesc(id);
	}
}
