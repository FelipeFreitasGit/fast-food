package br.com.fiap.postech.fastfood.domain.repository

import br.com.fiap.postech.fastfood.domain.entity.Produto
import br.com.fiap.postech.fastfood.domain.valueObjets.CategoriaProduto
import java.util.*

interface ProdutoRepository {

    fun cadastrar(produto: Produto): Produto
    fun atualizar(id: UUID, produto: Produto): Produto
    fun buscarPorCategoria(categoria: CategoriaProduto): List<Produto>
    fun existeProduto(id: UUID): Boolean
    fun deletaProduto(id: UUID)
    fun buscaPorId(id: UUID): Produto?
}