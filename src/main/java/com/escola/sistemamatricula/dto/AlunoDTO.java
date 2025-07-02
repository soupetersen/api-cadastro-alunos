package com.escola.sistemamatricula.dto;

public class AlunoDTO {
    private String nome;
    private Integer idade;
    private String responsavel;
    private String turma;
    
    public AlunoDTO() {}
    
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
}
