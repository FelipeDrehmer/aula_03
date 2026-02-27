package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.model.Autor;
import com.exemplo.biblioteca.model.Funcionario;
import com.exemplo.biblioteca.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().isBlank()) {
            throw new ResponseStatusException(BAD_REQUEST, "Nome do funcionario não pode vazio");
        }
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Funcionario não encontrado"));
    }

    public void removerFuncionario(Long id) {
        buscarPorId(id);
        funcionarioRepository.deleteById(id);
    }

}
