package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.WorkingTypeService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.entities.concretes.WorkingType;

@RestController
@RequestMapping("/api/workingtype")
@CrossOrigin("http://localhost:3000/")
public class WorkingTypeController {

	private WorkingTypeService workingTypeService;

	@Autowired
	public WorkingTypeController(WorkingTypeService workingTypeService) {
		super();
		this.workingTypeService = workingTypeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkingType>> getAll(){
		return this.workingTypeService.getAll();
	}
}
