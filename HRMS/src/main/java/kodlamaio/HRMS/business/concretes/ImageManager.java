package kodlamaio.HRMS.business.concretes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.ImageService;
import kodlamaio.HRMS.core.adapters.FileUpload.CloudinaryAdapter;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ImageDao;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;

	@Autowired
	public ImageManager(ImageDao imageDao) {
		super();
		this.imageDao = imageDao;
	}

	@Override
	public Result add(MultipartFile file) throws IOException {
		var result = CloudinaryAdapter.upload(file);
		return new SuccessResult(result.getData().toString());
	}

}
