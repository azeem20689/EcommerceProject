package com.azeem.repo;

import com.azeem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, String> {

    @Query(value = "select  *  from user_table where username =:username",nativeQuery = true)
    User getByUsername(@Param("username") String username);

}
