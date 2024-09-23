package edu.lawrence.college.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.college.entities.Academics;
import edu.lawrence.college.entities.College;
import edu.lawrence.college.entities.Studentlife;

public interface StudentlifeRepository extends JpaRepository<Studentlife, UUID>{
	@Query("select c from Studentlife c where c.college.collegeid=:collegeid")
	List<Studentlife> findAllByCollegeid(UUID collegeid);
	@Query("select c from Studentlife c where c.user.userid=:userid")
	Optional<Studentlife> findByUserid(UUID userid);
	@Query("select avg(r.adminhelp) from Studentlife r where r.college.collegeid=:restaurantid")
    Double avgAdminhelp(UUID restaurantid);
	@Query("select avg(r.cafequality) from Studentlife r where r.college.collegeid=:restaurantid")
    Double avgCafequality(UUID restaurantid);
	@Query("select avg(r.campusenv) from Studentlife r where r.college.collegeid=:restaurantid")
    Double avgCampusenv(UUID restaurantid);
	@Query("select avg(r.clubs) from Studentlife r where r.college.collegeid=:restaurantid")
    Double avgClubs(UUID restaurantid);
	@Query("select avg(r.greeklife) from Studentlife r where r.college.collegeid=:restaurantid")
    Double avgGreeklife(UUID restaurantid);
	@Query("select avg(r.studentorgs) from Studentlife r where r.college.collegeid=:restaurantid")
    Double avgStudentorgs(UUID restaurantid);

}
