package kodlamaio.HRMS.core.adapters.FileUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;

public class CloudinaryAdapter {

	static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "dg6wsaypq", 
			"api_key","436554978638323", 
			"api_secret", "po75ikA6LIqs7AD4XkRShi1dm0U"));

	public static SuccessDataResult<Map> upload(MultipartFile file) throws IOException {
		Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
		return new SuccessDataResult<Map>(uploadResult);
	}

	public static Result delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return new SuccessResult(result.toString());
	}

}