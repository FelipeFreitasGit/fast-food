package br.com.fiap.postech.fastfood.clean.domain.usecase

import br.com.fiap.postech.fastfood.clean.domain.repository.ProdutoRepository

class CadastrarProduto(
    private val produtoRepository: ProdutoRepository
) {

    fun execute() {

        produtoRepository.cadastrar()
    }
}