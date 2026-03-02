package com.exemplo.biblioteca.repository;

import com.exemplo.biblioteca.model.Funcionario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FuncionarioRepository {

    private final List<Funcionario> funcionarios = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public FuncionarioRepository() {
        save(new Funcionario(null, "Pedro", 1, 2000.00));
        save(new Funcionario(null, "Davi", 2, 4000.00));
        save(new Funcionario(null, "Felipe", 3, 10020.00));
        save(new Funcionario(null, "Antonio", 3, 10320.00));
        save(new Funcionario(null, "Jaca", 1, 13200.00));
        save(new Funcionario(null, "Felps", 2, 15400.00));
        save(new Funcionario(null, "Eduardo", 3, 13100.00));
    }

    public Funcionario save(Funcionario funcionario) {
        if (funcionario.getId() == null) {
            funcionario.setId(sequence.incrementAndGet());
            funcionarios.add(funcionario);
            return funcionario;
        }

        deleteById(funcionario.getId());
        funcionarios.add(funcionario);
        return funcionario;
    }

    public List<Funcionario> findAll() {
        return new ArrayList<>(funcionarios);
    }

    public Optional<Funcionario> findById(Long id) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {
        funcionarios.removeIf(funcionario -> funcionario.getId().equals(id));
    }

    public List<Funcionario> findByNome(String nome) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getNome()
                        .toLowerCase()
                        .contains(nome.toLowerCase()))
                .toList();
    }

    public List<Funcionario> findByIdCargo(int idCargo) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getIdCargo() == idCargo)
                .toList();
    }

}
