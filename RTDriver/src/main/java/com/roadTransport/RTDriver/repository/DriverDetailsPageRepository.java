package com.roadTransport.RTDriver.repository;

import com.roadTransport.RTDriver.entity.DriverDetails;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDetailsPageRepository extends PagingAndSortingRepository<DriverDetails, Long> {
}
