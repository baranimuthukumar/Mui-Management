package com.user.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.user.Model.AdditionDetails;

@Repository
public interface AdditionDetailsRepository extends JpaRepository<AdditionDetails, Long>{
	
	@Query("SELECT ads FROM AdditionDetails ads WHERE ads.adminId = :adminId")
	List<AdditionDetails> findAllByAdminId(@Param("adminId")long adminId);
	
	@Query("SELECT ads FROM AdditionDetails ads WHERE ads.adminId = :adminId order by CAST(ads.amountdetails AS int) desc")
	List<AdditionDetails> findAllByAdminIdSorting(@Param("adminId")long adminId);
	
	@Query("SELECT ads FROM AdditionDetails ads WHERE ads.additionDetailsId = :additionDetailsId")
	AdditionDetails findAllByAdminDetailsId(@Param("additionDetailsId")long additionDetailsId);

}

