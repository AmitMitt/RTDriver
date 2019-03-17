package com.roadTransport.RTDriver.serviceImpl;

import com.roadTransport.RTDriver.entity.DeletedDriverDetails;
import com.roadTransport.RTDriver.repository.deletedRepository.DeletedDriverPageRepository;
import com.roadTransport.RTDriver.repository.deletedRepository.DeletedDriverRepository;
import com.roadTransport.RTDriver.service.DeletedDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DeletedDriverServiceImpl implements DeletedDriverService {

   @Autowired
   private DeletedDriverPageRepository deletedDriverPageRepository;

   @Autowired
   private DeletedDriverRepository deletedDriverRepository;

    @Override
    public Page<DeletedDriverDetails> listAllByPage(Pageable pageable) {
        return deletedDriverPageRepository.findAll(pageable);
    }

    @Override
    public DeletedDriverDetails findByMdn(long driverMobileNumber) throws Exception {

        DeletedDriverDetails deletedDriverDetails = deletedDriverRepository.findByMdn(driverMobileNumber);
        if(deletedDriverDetails == null){
            throw new Exception("Data not Exist.");
        }

        return deletedDriverDetails;
    }
}
