package kodlamaio.HRMS.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.EducationService;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.Education;

@RestController
@RequestMapping("/api/education")
@CrossOrigin("http://localhost:3000/")
public class EducationController {

	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}

	@GetMapping("/getallbycvidgraduatedesc")
	public ResponseEntity<?> getAllByCvIdDesc(@RequestParam int id) {
		return ResponseEntity.ok(this.educationService.getAllByCvIdDesc(id));
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		return this.educationService.add(education);	
	}
	
	@DeleteMapping("delete")
	public Result deleteById(@RequestParam int id) {
		return this.educationService.deleteById(id);
	}
}
