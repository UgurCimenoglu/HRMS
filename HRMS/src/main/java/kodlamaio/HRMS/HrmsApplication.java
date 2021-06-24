package kodlamaio.HRMS;

import java.rmi.RemoteException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kodlamaio.HRMS.core.adapters.mernis.MernisAdapter;
import kodlamaio.HRMS.entities.dtos.CandidateForRegisterDto;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);

		//CandidateForRegisterDto c = new CandidateForRegisterDto("ugur", "cimen", "12345678901", "a@a.com", "123123", "123123", 1997);
		//var result = MernisAdapter.validate(c);
		//System.out.println("bennsssss" + result);
		
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dg6wsaypq",
				"api_key", "436554978638323",
				"api_secret", "po75ikA6LIqs7AD4XkRShi1dm0U"));
		
		KPSPublicSoap kps = new KPSPublicSoapProxy();
		try {
			kps.TCKimlikNoDogrula(Long.parseLong("12312312312"), "ugur", "cimen", 1997);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	// Burada modelmapper'a strict olarak çalış yani her hücreni birebir eşleştir
	// diyoruz
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}