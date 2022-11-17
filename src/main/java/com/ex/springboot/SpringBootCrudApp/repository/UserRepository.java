package com.ex.springboot.SpringBootCrudApp.repository;

import com.ex.springboot.SpringBootCrudApp.bean.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

    @Query(value = "select * from Users u where concat(u.id,' ',u.username,' ',u.useremail,' ',u.useraddress) like %:keyword%",nativeQuery = true )
     List<Users> search(@Param("keyword") String keyword);
}
