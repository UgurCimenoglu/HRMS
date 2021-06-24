package kodlamaio.HRMS.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.ImageService;
import kodlamaio.HRMS.core.utilities.Result;

@RestController
@RequestMapping("/api/image")
public class ImageController {

	private ImageService imageService;

	@Autowired
	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}

	@PostMapping("/upload")
	public Result upload(@RequestPart(name = "file") MultipartFile file) throws IOException {
		return this.imageService.add(file);

	}

}
