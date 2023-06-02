package com.example.ProyectoFinal.model;

import com.example.ProyectoFinal.utils.AuthorityName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)

    @Getter @Setter
    private AuthorityName name;

    public Authority(AuthorityName authorityName){this.name = authorityName;}

}
