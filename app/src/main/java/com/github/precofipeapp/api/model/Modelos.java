package com.github.precofipeapp.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Modelos implements Serializable {

    private List<Itens> modelos;

    public List<Itens> getModelos() {
        return modelos;
    }

    public class Itens {

        private String nome;
        private int codigo;

        public Itens() {

        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }


    }


}
