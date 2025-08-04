package com.christianrondon.ecommerce.repository;

import com.christianrondon.ecommerce.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByName(String name);
    List<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.name = :new_name WHERE u.id = :id_user")
    int patchUserName(@Param("id_user")Long id, @Param("new_name")String newName);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.email = :new_email WHERE u.id =:id_user")
    int patchUserEmail(@Param("id_user")Long id, @Param("new_email")String newEmail);
}
