package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.LanguageService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.LanguageDao;
import kodlamaio.HRMS.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAllByCvId(int cvId) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getAllBycandidateCurriculumVitaes_Id(cvId),
				"Diller Listelendi.");
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Dil Eklendi.");
	}

}
