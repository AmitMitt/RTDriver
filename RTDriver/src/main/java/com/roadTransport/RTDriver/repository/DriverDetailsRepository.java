package com.roadTransport.RTDriver.repository;

import com.roadTransport.RTDriver.entity.DriverDetails;
import com.roadTransport.RTDriver.entity.DriverTemporaryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface DriverDetailsRepository extends JpaRepository<DriverDetails, Long> {

    @Query("select d from DriverTemporaryDetails d where d.driverMobileNumber = :driverMobileNumber")
    public DriverDetails findByMdn(@PathVariable("driverMobileNumber") long driverMobileNumber);

}
