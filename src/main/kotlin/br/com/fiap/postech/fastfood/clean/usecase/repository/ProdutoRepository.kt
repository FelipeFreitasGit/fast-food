package br.com.fiap.postech.fastfood.clean.usecase.repository

import br.com.fiap.postech.fastfood.clean.entity.Produto

interface ProdutoRepository {

    fun cadastrar(): Produto
}