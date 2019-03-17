package com.roadTransport.RTDriver.repository.deletedRepository;

import com.roadTransport.RTDriver.entity.DeletedDriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface DeletedDriverRepository extends JpaRepository<DeletedDriverDetails, Long> {

    @Query("Select d from DeletedDriverDetails d where d.driverMobileNumber = :driverMobileNumber")
    public DeletedDriverDetails findByMdn(@PathVariable("driverMobileNumber") long driverMobileNumber);
}
