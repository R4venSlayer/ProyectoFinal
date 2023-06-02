package com.example.ProyectoFinal.repository;

import com.example.ProyectoFinal.model.Authority;
import com.example.ProyectoFinal.utils.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    Optional<Authority> findByName(AuthorityName name);
}
