package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> findAllByIsActive (boolean isActive);
	List<JobAdvertisement> findAllByOrderByCreateDateDesc();
	List<JobAdvertisement> findAllByIsActiveAndEmployer_Id(boolean isActive, int employerId);
}
