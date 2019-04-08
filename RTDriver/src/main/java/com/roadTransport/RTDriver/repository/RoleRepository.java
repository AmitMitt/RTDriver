package com.roadTransport.RTDriver.repository;

import com.roadTransport.RTDriver.entity.Role;
import com.roadTransport.RTDriver.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
