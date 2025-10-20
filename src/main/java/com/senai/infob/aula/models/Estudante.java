package com.senai.infob.aula.models;

import java.time.LocalDate;
import java.util.Set;

import com.senai.infob.aula.enums.TipoAparencia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="estudante")
public class Estudante {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="email")
    private String email;

    @Column(name="data_nascimento")
    private LocalDate dataNascimento;

    @Column(name="matricula")
    private String matricula;

    @Column(name="senha")
    private String senha;

    @ManyToMany
    @JoinTable(
        name = "estudante_unidade_curricular",
        joinColumns = @JoinColumn(name = "estudante_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "unidade_curricular_id", referencedColumnName = "id")
    )
    private Set<UnidadeCurricular> unidadesCurriculares;

    @Enumerated(EnumType.STRING)
    @Column(name="cor")
    private TipoAparencia tipoAparencia;

    public Estudante() {
    }

    public Estudante(Integer id, String nome, String email, LocalDate dataNascimento, String matricula,
            Set<UnidadeCurricular> unidadesCurriculares, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
        this.unidadesCurriculares = unidadesCurriculares;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Set<UnidadeCurricular> getUnidadesCurriculares() {
        return unidadesCurriculares;
    }

    public void setUnidadesCurriculares(Set<UnidadeCurricular> unidadesCurriculares) {
        this.unidadesCurriculares = unidadesCurriculares;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
