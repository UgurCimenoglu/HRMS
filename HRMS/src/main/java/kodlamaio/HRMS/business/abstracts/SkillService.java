package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.Skill;

public interface SkillService {
	public Result add(Skill skill);
	public DataResult<List<Skill>> getByCvId(int cvId);
	
}
