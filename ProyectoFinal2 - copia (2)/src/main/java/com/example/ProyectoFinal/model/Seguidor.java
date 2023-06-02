package com.example.ProyectoFinal.model;


import jakarta.persistence.*;


@Entity
@Table(name="seguidor")
public class Seguidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seguidor",nullable = false,length = 50)
    private String seguidor;

    @Column(name = "seguido",nullable = false,length = 50)
    private String seguido;

    public Seguidor() {

    }

    public Seguidor(String seguidor, String seguido) {
        this.id = id;
        this.seguidor = seguidor;
        this.seguido = seguido;
    }
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(String seguidor) {
        this.seguidor = seguidor;
    }

    public String getSeguido() {
        return seguido;
    }

    public void setSeguido(String seguido) {
        this.seguido = seguido;
    }

    @Override
    public String toString() {
        return "Seguidor{" +
                "id=" + id +
                ", seguidor ='" + seguidor + '\'' +
                ", seguido='" + seguido + '\'' +
                '}';
    }
}
