package com.escola.sistemamatricula.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.sistemamatricula.dto.AlunoDTO;
import com.escola.sistemamatricula.model.Aluno;
import com.escola.sistemamatricula.repository.AlunoRepository;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    public List<Aluno> findAll() {
        return alunoRepository.findAllActive();
    }
    
    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findActiveById(id);
    }
    
    public Aluno save(AlunoDTO alunoDTO) {
        Aluno aluno = convertToEntity(alunoDTO);
        return alunoRepository.save(aluno);
    }
    
    public Aluno update(Long id, AlunoDTO alunoDTO) {
        Optional<Aluno> existingAluno = alunoRepository.findActiveById(id);
        if (existingAluno.isPresent()) {
            Aluno aluno = existingAluno.get();
            aluno.setNome(alunoDTO.getNome());
            aluno.setIdade(alunoDTO.getIdade());
            aluno.setResponsavel(alunoDTO.getResponsavel());
            aluno.setTurma(alunoDTO.getTurma());
            return alunoRepository.save(aluno);
        }
        return null;
    }
    
    public void delete(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findActiveById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setDeletedAt(LocalDateTime.now());
            alunoRepository.save(aluno);
        }
    }
    
    public void hardDelete(Long id) {
        alunoRepository.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return alunoRepository.findActiveById(id).isPresent();
    }
    
    private Aluno convertToEntity(AlunoDTO alunoDTO) {
        return new Aluno(
            alunoDTO.getNome(),
            alunoDTO.getIdade(),
            alunoDTO.getResponsavel(),
            alunoDTO.getTurma()
        );
    }
}
