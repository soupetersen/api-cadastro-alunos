package com.escola.sistemamatricula.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.sistemamatricula.dto.AlunoDTO;
import com.escola.sistemamatricula.dto.ApiResponse;
import com.escola.sistemamatricula.model.Aluno;
import com.escola.sistemamatricula.service.AlunoService;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;
    
    @PostMapping
    public ApiResponse create(@RequestBody AlunoDTO alunoDTO) {
        try {
            Aluno aluno = alunoService.save(alunoDTO);
            return new ApiResponse(true, "Student created successfully", aluno);
        } catch (Exception e) {
            return new ApiResponse(false, "Error creating student: " + e.getMessage(), null);
        }
    }
    
    @GetMapping
    public ApiResponse findAll() {
        try {
            List<Aluno> alunos = alunoService.findAll();
            return new ApiResponse(true, "Students listed successfully", alunos);
        } catch (Exception e) {
            return new ApiResponse(false, "Error listing students: " + e.getMessage(), null);
        }
    }
    
    @GetMapping("/{id}")
    public ApiResponse findById(@PathVariable Long id) {
        try {
            Optional<Aluno> alunoOptional = alunoService.findById(id);
            if (alunoOptional.isPresent()) {
                return new ApiResponse(true, "Student found", alunoOptional.get());
            } else {
                return new ApiResponse(false, "Student not found", null);
            }
        } catch (Exception e) {
            return new ApiResponse(false, "Error finding student: " + e.getMessage(), null);
        }
    }
    
    @PutMapping("/{id}")
    public ApiResponse update(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO) {
        try {
            Aluno aluno = alunoService.update(id, alunoDTO);
            if (aluno != null) {
                return new ApiResponse(true, "Student updated successfully", aluno);
            } else {
                return new ApiResponse(false, "Student not found", null);
            }
        } catch (Exception e) {
            return new ApiResponse(false, "Error updating student: " + e.getMessage(), null);
        }
    }
    
    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Long id) {
        try {
            if (alunoService.existsById(id)) {
                alunoService.delete(id);
                return new ApiResponse(true, "Student disabled successfully", null);
            } else {
                return new ApiResponse(false, "Student not found", null);
            }
        } catch (Exception e) {
            return new ApiResponse(false, "Error disabling student: " + e.getMessage(), null);
        }
    }
    
    @DeleteMapping("/{id}/delete")
    public ApiResponse hardDelete(@PathVariable Long id) {
        try {
            if (alunoService.existsById(id)) {
                alunoService.hardDelete(id);
                return new ApiResponse(true, "Student permanently deleted", null);
            } else {
                return new ApiResponse(false, "Student not found", null);
            }
        } catch (Exception e) {
            return new ApiResponse(false, "Error permanently deleting student: " + e.getMessage(), null);
        }
    }
}
