package br.com.fiap.postech.fastfood.clean.usecase

import br.com.fiap.postech.fastfood.clean.usecase.repository.ProdutoRepository

class CadastrarProduto(
    private val produtoRepository: ProdutoRepository
) {

    fun execute() {

        produtoRepository.cadastrar()
    }
}