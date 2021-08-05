package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.Language;

public interface LanguageService{

	DataResult<List<Language>> getAllByCvId(int cvId);
	Result add(Language language);
}
