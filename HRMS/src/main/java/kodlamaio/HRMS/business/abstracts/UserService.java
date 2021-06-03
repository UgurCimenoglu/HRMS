package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.User;

public interface UserService {

	Result add(User user);

	DataResult<User> getByEmail(String email);
}
