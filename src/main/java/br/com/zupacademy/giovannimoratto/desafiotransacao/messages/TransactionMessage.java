package br.com.zupacademy.giovannimoratto.desafiotransacao.messages;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @Author giovanni.moratto
 */

public class TransactionMessage {

    /* Attributes */
    private String id;
    private BigDecimal valor;
    private Map <String, String> estabelecimento;
    private Map <String, String> cartao;
    private LocalDateTime efetivadaEm;

    /* Constructors */
    @Deprecated
    public TransactionMessage() {
    }

    public TransactionMessage(String id, BigDecimal valor, Map <String, String> estabelecimento,
                              Map <String, String> cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    /* Methods */
    public String getCartaoId(Map <String, String> cartao) {
        return (String) cartao.values().toArray()[0];
    }

    public String getCartaoEmail(Map <String, String> cartao) {
        return (String) cartao.values().toArray()[1];
    }

    public String getEstabelecimentoNome(Map <String, String> estabelecimento) {
        return (String) estabelecimento.values().toArray()[0];
    }

    public String getEstabelecimentoCidade(Map <String, String> estabelecimento) {
        return (String) estabelecimento.values().toArray()[1];
    }

    public String getEstabelecimentoEndereco(Map <String, String> estabelecimento) {
        return (String) estabelecimento.values().toArray()[2];
    }

    /* Getters */
    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Map <String, String> getEstabelecimento() {
        return estabelecimento;
    }

    public Map <String, String> getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

}