package kodlamaio.HRMS.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.utilities.Result;

public interface ImageService {
	Result add(MultipartFile file) throws IOException;
}
