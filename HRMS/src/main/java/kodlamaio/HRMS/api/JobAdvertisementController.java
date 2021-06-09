package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementController {
	private JobAdvertisementService advertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService advertisementService) {
		super();
		this.advertisementService = advertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.advertisementService.getAll();
	}

	@GetMapping("getallbydatedesc")
	public DataResult<List<JobAdvertisement>> findAllByOrderByCreateDateDesc() {
		return this.advertisementService.findAllByOrderByCreateDateDesc();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.advertisementService.add(jobAdvertisement);
	}

	@GetMapping("/findAllByIsActive")
	public DataResult<List<JobAdvertisement>> findAllByIsActive(@RequestParam boolean isActive) {
		return this.advertisementService.findAllByIsActive(isActive);
	}

	@GetMapping("/findAllByIsActiveAndEmployerId")
	public DataResult<List<JobAdvertisement>> findAllByIsActiveAndEmployerId(@RequestParam boolean isActive,
			@RequestParam int employerId) {
		return this.advertisementService.findAllByIsActiveAndEmployer_Id(isActive, employerId);
	}
}
