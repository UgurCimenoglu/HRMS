package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.entities.concretes.WorkingType;

public interface WorkingTypeService {
 DataResult<List<WorkingType>> getAll();
}
