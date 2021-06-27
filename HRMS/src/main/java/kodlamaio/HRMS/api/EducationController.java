package kodlamaio.HRMS.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.EducationService;

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
	public ResponseEntity<?> getAllByCvIdDesc(@RequestParam int id) {
		return ResponseEntity.ok(this.educationService.getAllByCvIdDesc(id));
	}
}
