package br.com.fiap.postech.fastfood.application.ports.repositories

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ProdutoEntity
import br.com.fiap.postech.fastfood.application.domain.models.Produto
import java.util.UUID

interface ProdutoRepositoryPort {
    fun cadastrar(produto: Produto): ProdutoEntity
    fun existeProduto(id: UUID): Boolean
    fun atualizar(produto: Produto): ProdutoEntity
}