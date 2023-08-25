package br.com.fiap.postech.fastfood.adapter.controller


import br.com.fiap.postech.fastfood.adapter.presenter.*
import br.com.fiap.postech.fastfood.domain.usecase.checkout.IniciarCheckoutUseCase
import br.com.fiap.postech.fastfood.domain.usecase.pedido.*
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("pedidos")
class PedidoController (
    private val listarPedidoUseCase: ListarPedidoUseCase,
    private val iniciarCheckoutUseCase: IniciarCheckoutUseCase,
    private val mudarStatusPedidoUseCase: MudarStatusPedidoUseCase,
    private val listarTodosPedidosUseCase: ListarTodosPedidosUseCase
) {

    @PostMapping("/checkout")
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrar(@RequestBody pedidoRequest: PedidoRequest) =
        iniciarCheckoutUseCase.executa(pedidoRequest.toPedido()).toResponse()

    @GetMapping("/{id}")
    fun listar(@PathVariable id: UUID): PedidoResponse {
        return listarPedidoUseCase.execute(id).toResponse()
    }

    @GetMapping()
    fun listarTodosPedidos(): List<StatusPedidoResponse> {
        return listarTodosPedidosUseCase.execute()
    }

    @GetMapping("/{id}/status")
    fun consultarStatus(@PathVariable id: UUID): StatusPedidoResponse {
        return listarPedidoUseCase.execute(id).toStatusResponse()
    }

    @PutMapping("/{id}/mudar-status/preparacao")
    fun prepararPedido(@PathVariable id: UUID) =
        mudarStatusPedidoUseCase.executa(id, StatusPedido.EM_PREPARACAO).toResponse()

    @PutMapping("/{id}/mudar-status/pronto")
    fun pedidoPronto(@PathVariable id: UUID) =
        mudarStatusPedidoUseCase.executa(id, StatusPedido.PRONTO).toResponse()

    @PutMapping("/{id}/mudar-status/confirmar-entrega")
    fun confirmarEntrega(@PathVariable id: UUID) =
        mudarStatusPedidoUseCase.executa(id, StatusPedido.FINALIZADO).toResponse()
}