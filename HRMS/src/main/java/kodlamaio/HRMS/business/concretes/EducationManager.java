package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EducationService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EducationDao;
import kodlamaio.HRMS.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAllByCvIdDesc(int cvId) {
		return new SuccessDataResult<List<Education>>(
				this.educationDao.findAllByCandidateCurriculumVitaes_IdOrderByGraduateDateDesc(cvId));
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Eğitim Bilgisi Eklendi.");
	}

	@Override
	public Result deleteById(int id) {
		this.educationDao.deleteById(id);
		return new SuccessResult("Eğitim Bilgisi Silindi.");
	}

}
