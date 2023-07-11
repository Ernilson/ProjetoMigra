package br.com.ProjetoMigra.entities;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Objects;

@Entity
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String ender;
    @Column
    private int fone;
    @Column
    private String email;

    public Formulario() {
        // TODO Auto-generated constructor stub
    }

    public Formulario(Long id, String nome, String ender, int fone, String email) {
        this.id = id;
        this.nome = nome;
        this.ender = ender;
        this.fone = fone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnder() {
        return ender;
    }

    public void setEnder(String ender) {
        this.ender = ender;
    }

    public int getFone() {
        return fone;
    }

    public void setFone(int fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formulario that)) return false;
        return getFone() == that.getFone() && Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getEnder(), that.getEnder()) && Objects.equals(getEmail(), that.getEmail());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getEnder(), getFone(), getEmail());
    }

    @Override
    public String toString() {
        return "Formulario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ender='" + ender + '\'' +
                ", fone=" + fone +
                ", email='" + email + '\'' +
                '}';
    }
}
