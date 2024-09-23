package edu.lawrence.college.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.college.entities.Academics;
import edu.lawrence.college.entities.College;

public interface AcademicsRepository extends JpaRepository<Academics, UUID>{
	@Query("select c from Academics c where c.college.collegeid=:collegeid")
	List<Academics> findAllByCollegeid(UUID collegeid);
	@Query("select c from Academics c where c.user.userid=:collegeid")
	Optional<Academics> findByUserid(UUID collegeid);
	@Query("select avg(r.advising) from Academics r where r.college.collegeid=:restaurantid")
    Double avgAdvising(UUID restaurantid);
	@Query("select avg(r.classselection) from Academics r where r.college.collegeid=:restaurantid")
    Double avgClassselection(UUID restaurantid);
	@Query("select avg(r.lectures) from Academics r where r.college.collegeid=:restaurantid")
    Double avgLectures(UUID restaurantid);
	@Query("select avg(r.opportunities) from Academics r where r.college.collegeid=:restaurantid")
    Double avgOpportunities(UUID restaurantid);
	@Query("select avg(r.ratio) from Academics r where r.college.collegeid=:restaurantid")
    Double avgRatio(UUID restaurantid);
	@Query("select avg(r.workload) from Academics r where r.college.collegeid=:restaurantid")
    Double avgWorkload(UUID restaurantid);

}
