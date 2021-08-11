package br.com.zupacademy.giovannimoratto.desafiotransacao.consulta;

import br.com.zupacademy.giovannimoratto.desafiotransacao.messages.TransactionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author giovanni.moratto
 */

@RestController
@RequestMapping("/api")
public class TransacaoController {

    @Autowired
    private TransacaoRepository repository;

    @GetMapping("/transacoes/{numeroCartao}")
    public ResponseEntity <?> listaDezUltimasCompras(@PathVariable("numeroCartao") String numeroCartao,
                                                     @PageableDefault(page = 0, size = 10, sort = "efetivadaEm",
                                                             direction = Sort.Direction.DESC) Pageable pageable) {

        Page <TransacaoModel> transacoes = repository.findAllByNumeroCartao(numeroCartao, pageable);
        if (!transacoes.isEmpty()) {
            return ResponseEntity.ok(transacoes.map(TransactionMessage::new));
        }
        return ResponseEntity.notFound().build();
    }
}
