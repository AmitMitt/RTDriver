package com.roadTransport.RTDriver.repository;

import com.roadTransport.RTDriver.entity.DriverTemporaryDetails;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverTemporaryDetailsPageRepository extends PagingAndSortingRepository<DriverTemporaryDetails,Long> {
}
