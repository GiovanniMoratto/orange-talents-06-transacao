package br.com.zupacademy.giovannimoratto.desafiotransacao.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author giovanni.moratto
 */

@Component
public class TransactionListener {

    private final Logger logger = LoggerFactory.getLogger(TransactionListener.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransactionMessage message) {
        logger.info("----- Nova Transação! -----");
        logger.info("ID da transação: {}", message.getId());
        logger.info("Numero do cartão: {}", message.getCartaoId(message.getCartao()));
        logger.info("E-mail: {}", message.getCartaoEmail(message.getCartao()));
        logger.info("Valor: {}", message.getValor());
        logger.info("Efetuado em:  {}", message.getEfetivadaEm());
        logger.info("Nome do estabelecimento: {}", message.getEstabelecimentoNome(message.getEstabelecimento()));
        logger.info("Cidade do estabelecimento: {}", message.getEstabelecimentoCidade(message.getEstabelecimento()));
        logger.info(
                "Endereço do estabelecimento: {}",
                message.getEstabelecimentoEndereco(message.getEstabelecimento()));
    }

}