package com.github.precofipeapp.api.model;

import java.io.Serializable;

public class Anos implements Serializable {

    private String nome;
    private String codigo;

    public Anos() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
