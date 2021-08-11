package br.com.zupacademy.giovannimoratto.desafiotransacao.consulta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @Author giovanni.moratto
 */

@Entity
@Table(name = "tb_transacoes")
public class TransacaoModel {

    /* Attributes */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String codigoTransacao;
    private BigDecimal valor;
    private String estabelecimentoNome;
    private String estabelecimentoCidade;
    private String estabelecimentoEndereco;
    private String numeroCartao;
    private String email;
    private LocalDateTime efetivadaEm;

    /* Constructors */
    @Deprecated
    public TransacaoModel() {
    }

    public TransacaoModel(String id, BigDecimal valor, String estabelecimentoNome,
                          String estabelecimentoCidade, String estabelecimentoEndereco, String numeroCartao,
                          String email, LocalDateTime efetivadaEm) {
        this.codigoTransacao = id;
        this.valor = valor;
        this.estabelecimentoNome = estabelecimentoNome;
        this.estabelecimentoCidade = estabelecimentoCidade;
        this.estabelecimentoEndereco = estabelecimentoEndereco;
        this.numeroCartao = numeroCartao;
        this.email = email;
        this.efetivadaEm = efetivadaEm;
    }

    /* Getters */
    public Long getId() {
        return id;
    }

    public String getCodigoTransacao() {
        return codigoTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEstabelecimentoNome() {
        return estabelecimentoNome;
    }

    public String getEstabelecimentoCidade() {
        return estabelecimentoCidade;
    }

    public String getEstabelecimentoEndereco() {
        return estabelecimentoEndereco;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

}