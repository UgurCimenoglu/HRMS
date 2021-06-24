package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateCurriculumVitaeService;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateCurriculumVitaeDao;
import kodlamaio.HRMS.entities.concretes.CandidateCurriculumVitae;

@Service
public class CandidateCurriculumVitaeManager implements CandidateCurriculumVitaeService {

	private CandidateCurriculumVitaeDao candidateCurriculumVitaeDao;

	@Autowired
	public CandidateCurriculumVitaeManager(CandidateCurriculumVitaeDao candidateCurriculumVitaeDao) {
		super();
		this.candidateCurriculumVitaeDao = candidateCurriculumVitaeDao;
	}

	@Override
	public DataResult<List<CandidateCurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CandidateCurriculumVitae>>(candidateCurriculumVitaeDao.findAll(),
				"Cv'ler listelendi.");
	}

	@Override
	public Result add(CandidateCurriculumVitae candidateCurriculumVitae) {
		this.candidateCurriculumVitaeDao.save(candidateCurriculumVitae);
		return new SuccessResult("Cv eklendi.");
	}

	@Override
	public DataResult<CandidateCurriculumVitae> getById(int id) {
		return new SuccessDataResult<CandidateCurriculumVitae>(this.candidateCurriculumVitaeDao.getById(id),"CV Id'ye göre listelendi.");
	}

}
