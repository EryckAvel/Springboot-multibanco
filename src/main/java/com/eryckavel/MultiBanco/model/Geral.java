package com.eryckavel.MultiBanco.model;

import javax.persistence.*;

@Entity
@Table(name = "geral")
public class Geral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resposta;

    public Geral() {
    }

    public Geral(Long id, String resposta) {
        this.id = id;
        this.resposta = resposta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
