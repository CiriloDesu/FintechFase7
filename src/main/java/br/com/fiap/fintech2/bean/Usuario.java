package br.com.fiap.fintech2.bean;

public class Usuario {
    
    private int idUser; // Mudado de 'id' para 'idUser' para corresponder à tabela
    private String nmUser; // Mudado de 'nomeUser' para 'nmUser' para corresponder à tabela
    private String passUser;
    private String nome;
    private String urlAvatar;
    
    public Usuario() {
    }

    public Usuario(int idUser, String nmUser, String passUser, String nome, String urlAvatar) {
        super();
        this.idUser = idUser;
        this.nmUser = nmUser;
        this.passUser = passUser;
        this.nome = nome;
        this.urlAvatar = urlAvatar;
    }

    public int getIdUser() { // Mudado de 'getId' para 'getIdUser' para corresponder à tabela
        return idUser;
    }

    public void setIdUser(int idUser) { // Mudado de 'setId' para 'setIdUser' para corresponder à tabela
        this.idUser = idUser;
    }

    public String getNmUser() { // Mudado de 'getNomeUser' para 'getNmUser' para corresponder à tabela
        return nmUser;
    }

    public void setNmUser(String nmUser) { // Mudado de 'setNomeUser' para 'setNmUser' para corresponder à tabela
        this.nmUser = nmUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }
    
    @Override
    public String toString() {
        return "<%User '" + getNmUser() + "'>"; // Mudado de 'getNomeUser' para 'getNmUser' para corresponder à tabela
    }
    
}