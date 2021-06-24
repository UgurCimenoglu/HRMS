package kodlamaio.HRMS.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	@PostMapping(value = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public Result add(@RequestPart(name = "file", required = false) MultipartFile file,
			@RequestPart("cv") String candidateCurriculumVitae) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		CandidateCurriculumVitae cv = new CandidateCurriculumVitae();
		cv = mapper.readValue(candidateCurriculumVitae, CandidateCurriculumVitae.class);
		return this.candidateCurriculumVitaeService.add(file, cv);
	}

	@GetMapping("/geybyid")
	public DataResult<CandidateCurriculumVitae> getById(@RequestParam int id) {
		return this.candidateCurriculumVitaeService.getById(id);
	}

}
