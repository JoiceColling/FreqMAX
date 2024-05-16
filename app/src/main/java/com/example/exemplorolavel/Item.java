package com.example.exemplorolavel;

public class Item {
    private String nome;
    private int idade;
    private int frequenciaCardiaca;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca() {
        this.frequenciaCardiaca = 220 - getIdade();
    }
}
