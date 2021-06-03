package kodlamaio.HRMS.core.adapters.mernis;

import java.rmi.RemoteException;
import java.util.Locale;

import kodlamaio.HRMS.entities.dtos.CandidateForRegisterDto;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisAdapter {

	public static boolean validate(CandidateForRegisterDto candidateForRegisterDto) {

		KPSPublicSoap kpsPublicSoapProxy = new KPSPublicSoapProxy();
		boolean result = false;

		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(
					Long.parseLong(candidateForRegisterDto.getNationalityNumber()),
					candidateForRegisterDto.getFirstName().toUpperCase(new Locale("TR")),
					candidateForRegisterDto.getLastName().toUpperCase(new Locale("TR")),
					candidateForRegisterDto.getBirthDate());
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
		}

		return result;

	}

}
