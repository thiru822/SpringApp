package com.ex.springboot.SpringBootCrudApp.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Component
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name="USERADDRESS")
    private String userAddress;
    @Column(name="USEREMAIL")
    private String userEmail;

    public Users() {
    }


}
