package kodlamaio.HRMS.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import kodlamaio.HRMS.business.abstracts.CandidateCurriculumVitaeService;
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
	public ResponseEntity<?> getall() {
		return ResponseEntity.ok(this.candidateCurriculumVitaeService.getAll());
	}

	@PostMapping(value = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<?> add(@RequestPart(name = "file", required = false) MultipartFile file,
			@RequestPart("cv") String candidateCurriculumVitae) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		CandidateCurriculumVitae cv = new CandidateCurriculumVitae();
		cv = mapper.readValue(candidateCurriculumVitae, CandidateCurriculumVitae.class);
		return ResponseEntity.ok(this.candidateCurriculumVitaeService.add(file, cv));
	}

	@GetMapping("/geybyid")
	public ResponseEntity<?> getById(@RequestParam int id) {
		return ResponseEntity.ok(this.candidateCurriculumVitaeService.getById(id));
	}

}
