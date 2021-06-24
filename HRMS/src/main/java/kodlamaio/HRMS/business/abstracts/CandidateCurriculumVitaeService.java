package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateCurriculumVitae;

public interface CandidateCurriculumVitaeService {

	DataResult<List<CandidateCurriculumVitae>> getAll();

	Result add(CandidateCurriculumVitae candidateCurriculumVitae);
	
	DataResult<CandidateCurriculumVitae> getById(int id);
}
