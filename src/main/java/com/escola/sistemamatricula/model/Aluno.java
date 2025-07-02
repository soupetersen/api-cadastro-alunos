package com.escola.sistemamatricula.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "idade")
    private Integer idade;
    
    @Column(name = "responsavel")
    private String responsavel;
    
    @Column(name = "turma")
    private String turma;
    
    @JsonIgnore
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    
    public Aluno() {}
    
    public Aluno(String nome, Integer idade, String responsavel, String turma) {
        this.nome = nome;
        this.idade = idade;
        this.responsavel = responsavel;
        this.turma = turma;
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
    
    public Integer getIdade() {
        return idade;
    }
    
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    public String getResponsavel() {
        return responsavel;
    }
    
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
    public String getTurma() {
        return turma;
    }
    
    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    @JsonIgnore
    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }
    
    @JsonIgnore
    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
    
    @JsonIgnore
    public boolean isDeleted() {
        return deletedAt != null;
    }
}
