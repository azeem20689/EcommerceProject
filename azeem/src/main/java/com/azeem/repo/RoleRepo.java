package com.azeem.repo;

import com.azeem.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, String> {

    @Query(value = "select * from role where role =:role ",nativeQuery = true)
    Role getByRole(@Param("role") String role);
}
