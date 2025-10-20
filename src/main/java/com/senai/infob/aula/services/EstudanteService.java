package com.senai.infob.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.aula.models.Estudante;
import com.senai.infob.aula.repositories.EstudanteRepository;

@Service
public class EstudanteService {
    
    @Autowired
    public EstudanteRepository estudanteRepository;

    public Long count() {
        return estudanteRepository.count();
    }

    public Estudante salvar(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public boolean delete(Integer id) {
        Estudante estudante = estudanteRepository.findById(id).get();
        if(estudante != null) {
            estudanteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public String login(String email, String senha) {
        Estudante estudante = estudanteRepository.findByEmail(email);
        if(estudante != null && senha.equals(estudante.getSenha())) {
            return "Login efetuado com sucesso";
        }
        return "Falha ao realizar login";
    }
}
