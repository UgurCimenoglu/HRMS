package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.LanguageService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.Language;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Language language) {
		return this.languageService.add(language);
	}

	@GetMapping("/getallbycvid")
	public DataResult<List<Language>> getByCvId(int cvId) {
		return this.languageService.getAllByCvId(cvId);
	}

}
