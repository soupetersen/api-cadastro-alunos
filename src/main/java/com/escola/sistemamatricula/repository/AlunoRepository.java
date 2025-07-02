package com.escola.sistemamatricula.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.escola.sistemamatricula.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
    @Query("SELECT a FROM Aluno a WHERE a.deletedAt IS NULL")
    List<Aluno> findAllActive();
    
    @Query("SELECT a FROM Aluno a WHERE a.id = :id AND a.deletedAt IS NULL")
    Optional<Aluno> findActiveById(@Param("id") Long id);
}
