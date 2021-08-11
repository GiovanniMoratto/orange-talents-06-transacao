package br.com.zupacademy.giovannimoratto.desafiotransacao.consulta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author giovanni.moratto
 */

@Repository
public interface TransacaoRepository extends JpaRepository <TransacaoModel, Long> {

    Page <TransacaoModel> findAllByNumeroCartao(String numeroCartao, Pageable pageable);

}
