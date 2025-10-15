package com.senai.infob.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.infob.aula.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
    
}
