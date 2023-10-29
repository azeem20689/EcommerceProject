package com.azeem.entities;

import com.azeem.repo.RoleRepo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "UserTable")
public class User {



    @Id
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name= "USER_ROLE" , joinColumns = @JoinColumn(name = "USER_ID")
    , inverseJoinColumns = @JoinColumn(name = "USER_ROLE")
    )
    private Set<Role> role;

}
