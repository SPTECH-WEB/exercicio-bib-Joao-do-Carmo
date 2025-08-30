package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public String getNome(){
        return nome;
    }

    public Double getMultaDiaria(){
        return multaDiaria;
    }

    public Integer getQtdLivros(){
        return qtdLivros;
    }

    public Boolean getAtiva(){
        return ativa;
    }

    public Biblioteca(String nome, Double multaDiaria){
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        this.qtdLivros = 0;
        this.ativa = true;
    }

    public void registrarLivro(Integer quantidade){
        if (quantidade != null && quantidade > 0 && ativa){
            qtdLivros += quantidade;
        }
    }

    public Integer emprestar(Integer quantidade){
        if (quantidade != null && quantidade > 0 && quantidade <= qtdLivros && ativa){
            qtdLivros -= quantidade;
            return quantidade;
        } else {
            return null;
        }
    }

    public Integer devolver(Integer quantidade){
        if (quantidade != null && quantidade > 0 && ativa){
            qtdLivros += quantidade;
            return quantidade;
        } else {
            return null;
        }
    }

    public Integer desativar(){
        if (!ativa){
            return null;
        } else {
            ativa = false;
            int qtdAnterior = qtdLivros;
            qtdLivros = 0;
            return qtdAnterior;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade){
        if ((this.ativa == true && destino.ativa == true) && (this.qtdLivros > quantidade)){
            this.qtdLivros -= quantidade;
            destino.qtdLivros += quantidade;
        }
    }

    public Boolean reajustarMulta(Double percentual){
        if (percentual != null && percentual > 0){
            multaDiaria = multaDiaria * (1 + percentual);
            return true;
        } else {
            return false;
        }
    }


}
