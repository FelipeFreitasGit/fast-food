package br.com.fiap.postech.fastfood.clean.adapter.controller

import br.com.fiap.postech.fastfood.adapter.inbound.extension.toProdutoDTO
import br.com.fiap.postech.fastfood.adapter.inbound.extension.toProdutoResponse
import br.com.fiap.postech.fastfood.adapter.inbound.request.ProdutoRequest
import br.com.fiap.postech.fastfood.adapter.inbound.response.ProdutoResponse
import br.com.fiap.postech.fastfood.application.ports.interfaces.ProdutoServicePort
import br.com.fiap.postech.fastfood.clean.domain.usecase.CadastrarProduto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("produto/clean")
class ProdutoController (
    private val cadastrarProduto: CadastrarProduto,
    private val produtoServicePort: ProdutoServicePort
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarProduto(@RequestBody request: ProdutoRequest) =
        cadastrarProduto.execute()//produtoServicePort.cadastrar(request.toProdutoDTO()).toProdutoResponse()

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody request: ProdutoRequest) =
        produtoServicePort.atualizar(id, request.toProdutoDTO()).toProdutoResponse()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) {
        produtoServicePort.remover(id)
    }

    @GetMapping("/categoria")
    fun buscarPorCategoria(@RequestParam nome: String): List<ProdutoResponse>? {
        return produtoServicePort.buscarPorCategoria(nome)?.map { it.toProdutoResponse() }
    }
}