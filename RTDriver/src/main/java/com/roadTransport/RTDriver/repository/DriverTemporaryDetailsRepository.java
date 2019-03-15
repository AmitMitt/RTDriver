package com.roadTransport.RTDriver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.roadTransport.RTDriver.entity.DriverTemporaryDetails;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface DriverTemporaryDetailsRepository extends JpaRepository<DriverTemporaryDetails, Long> {

    @Query("select d from DriverTemporaryDetails d where v.driverMobileNumber = :driverMobileNumber")
    public DriverTemporaryDetails findByMdn(@PathVariable("driverMobileNumber") long driverMobileNumber);
}
