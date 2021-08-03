package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.WorkingTimeService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.entities.concretes.WorkingTime;

@RestController
@RequestMapping("/api/workingtime")
@CrossOrigin("http://localhost:3000/")
public class WorkingTimeController {
	private WorkingTimeService workingTimeService;

	@Autowired
	public WorkingTimeController(WorkingTimeService workingTimeService) {
		super();
		this.workingTimeService = workingTimeService;
	}

	@GetMapping("/getall")
	public DataResult<List<WorkingTime>> getAll() {
		return workingTimeService.getAll();
	}
}
