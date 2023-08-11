package br.com.fiap.postech.fastfood.clean.adapter.gateway

import br.com.fiap.postech.fastfood.application.domain.valueObjets.Categoria
import br.com.fiap.postech.fastfood.application.domain.valueObjets.Descricao
import br.com.fiap.postech.fastfood.application.domain.valueObjets.Preco
import br.com.fiap.postech.fastfood.clean.domain.entity.Produto
import br.com.fiap.postech.fastfood.clean.domain.repository.ProdutoRepository
import java.math.BigDecimal

class ProdutoDbGateway: ProdutoRepository {

    //chama JPARepository
    override fun cadastrar(): Produto {

        return Produto(null, Descricao("teste"), Categoria("teste"), Preco(BigDecimal.TEN))
    }
}