package com.roadTransport.RTDriver.repository.deletedRepository;

import com.roadTransport.RTDriver.entity.DeletedDriverDetails;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeletedDriverPageRepository extends PagingAndSortingRepository<DeletedDriverDetails, Long> {
}
