package com.roadTransport.RTDriver.repository;

import com.roadTransport.RTDriver.entity.DriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface DriverDetailsRepository extends JpaRepository<DriverDetails, Long> {

    @Query("select d from DriverDetails d where d.mobileNumber = :mobileNumber and d.deleted = false")
    public DriverDetails findByMdn(@PathVariable("mobileNumber") String mobileNumber);

}
