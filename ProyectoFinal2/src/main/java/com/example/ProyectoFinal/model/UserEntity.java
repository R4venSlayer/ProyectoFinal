package com.example.ProyectoFinal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
public class UserEntity {
    public UserEntity(Long id, String first_name, String last_name, String username, String password, String b_date, List<Authority> authorities) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.b_date = b_date;
        this.authorities = authorities;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String b_date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name= "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="authority_id",referencedColumnName = "id"))

    private List<Authority> authorities;

}
