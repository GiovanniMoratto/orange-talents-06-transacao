package br.com.zupacademy.giovannimoratto.desafiotransacao.messages;

import br.com.zupacademy.giovannimoratto.desafiotransacao.consulta.TransacaoModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
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

    public TransactionMessage(TransacaoModel transacao) {
        this.id = transacao.getCodigoTransacao();
        this.valor = transacao.getValor();
        Map <String, String> estabelecimento = new HashMap <>();
        estabelecimento.put("nome", transacao.getEstabelecimentoNome());
        estabelecimento.put("cidade", transacao.getEstabelecimentoCidade());
        estabelecimento.put("endereco", transacao.getEstabelecimentoEndereco());
        this.estabelecimento = estabelecimento;
        Map <String, String> cartao = new HashMap <>();
        cartao.put("id", transacao.getNumeroCartao());
        cartao.put("email", transacao.getEmail());
        this.cartao = cartao;
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    /* Methods */
    public String getEstabNome(Map <String, String> estabelecimento) {
        return (String) estabelecimento.values().toArray()[0];
    }

    public String getEstabCidade(Map <String, String> estabelecimento) {
        return (String) estabelecimento.values().toArray()[1];
    }

    public String getEstabEndereco(Map <String, String> estabelecimento) {
        return (String) estabelecimento.values().toArray()[2];
    }

    public String getCartaoId(Map <String, String> cartao) {
        return (String) cartao.values().toArray()[0];
    }

    public String getCartaoEmail(Map <String, String> cartao) {
        return (String) cartao.values().toArray()[1];
    }

    public TransacaoModel ToModel() {
        return new TransacaoModel(
                this.id,
                this.valor,
                getEstabNome(this.estabelecimento),
                getEstabCidade(this.estabelecimento),
                getEstabEndereco(this.estabelecimento),
                getCartaoId(this.cartao),
                getCartaoEmail(this.cartao),
                this.efetivadaEm
        );
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