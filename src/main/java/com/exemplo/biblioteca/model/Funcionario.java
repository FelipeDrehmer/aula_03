package com.exemplo.biblioteca.model;

public class Funcionario {

    private Long id;
    private String nome;
    private int idCargo;
    private double salario;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, int idCargo, double salario) {
        this.id = id;
        this.nome = nome;
        this.idCargo = idCargo;
        this.salario = salario;
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

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
