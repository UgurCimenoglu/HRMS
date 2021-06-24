package kodlamaio.HRMS.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateCurriculumVitae;

public interface CandidateCurriculumVitaeService {

	DataResult<List<CandidateCurriculumVitae>> getAll();

	Result add(MultipartFile file, CandidateCurriculumVitae candidateCurriculumVitae) throws IOException;

	DataResult<CandidateCurriculumVitae> getById(int id);
}
