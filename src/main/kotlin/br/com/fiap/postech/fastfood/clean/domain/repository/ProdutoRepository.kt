package br.com.fiap.postech.fastfood.clean.domain.repository

import br.com.fiap.postech.fastfood.clean.domain.entity.Produto

interface ProdutoRepository {

    fun cadastrar(): Produto
}