package br.com.fiap.fintech2.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Despesa2 implements Serializable{
    
	private String nomeUser;
	private int id_user;
    private int id_despesa2;
    private String nome_despesa2;
    private String vl_despesa2;
    private String ds_despesa2;

    
    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }
    
    public int getIdUser() {
        return id_user;
    }

    public void setIdUser(int id_user) {
        this.id_user = id_user;
    }
    
    public int getId_despesa2() {
        return id_despesa2;
    }

    public void setId_despesa2(int id_despesa2) {
        this.id_despesa2 = id_despesa2;
    }

    public String getNome_despesa2() {
        return nome_despesa2;
    }

    public void setNome_despesa2(String nome_despesa2) {
        this.nome_despesa2 = nome_despesa2;
    }

    public String getVl_despesa2() {
        return vl_despesa2;
    }

    public void setVl_despesa2(String vl_despesa2) {
        this.vl_despesa2 = vl_despesa2;
    }

    public String getDs_despesa2() {
        return ds_despesa2;
    }

    public void setDs_despesa2(String ds_despesa2) {
        this.ds_despesa2 = ds_despesa2;
    }
}