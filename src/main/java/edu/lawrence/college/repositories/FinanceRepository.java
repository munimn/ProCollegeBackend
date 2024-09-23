package edu.lawrence.college.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.college.entities.Academics;
import edu.lawrence.college.entities.College;
import edu.lawrence.college.entities.Finances;
import edu.lawrence.college.entities.Studentlife;

public interface FinanceRepository extends JpaRepository<Finances, UUID>{
	@Query("select c from Finances c where c.college.collegeid=:collegeid")
	List<Finances> findAllByCollegeid(UUID collegeid);
	@Query("select c from Finances c where c.user.userid=:userid")
	Optional<Finances> findByUserid(UUID userid);
	@Query("select avg(r.financialaid) from Finances r where r.college.collegeid=:restaurantid")
    Double avgFinancialaid(UUID restaurantid);
	@Query("select avg(r.grants) from Finances r where r.college.collegeid=:restaurantid")
    Double avgGrant(UUID restaurantid);
	@Query("select avg(r.fees) from Finances r where r.college.collegeid=:restaurantid")
    Double avgFees(UUID restaurantid);
	@Query("select avg(r.scholarship) from Finances r where r.college.collegeid=:restaurantid")
    Double avgScholarship(UUID restaurantid);
	@Query("select avg(r.tution) from Finances r where r.college.collegeid=:restaurantid")
    Double avgTution(UUID restaurantid);
	@Query("select avg(r.roomandboards) from Finances r where r.college.collegeid=:restaurantid")
    Double avgRoomandboards(UUID restaurantid);

}