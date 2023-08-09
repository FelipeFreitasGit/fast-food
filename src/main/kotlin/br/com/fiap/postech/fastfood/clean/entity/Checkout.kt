package br.com.fiap.postech.fastfood.clean.entity

import br.com.fiap.postech.fastfood.application.domain.valueObjets.StatusCheckout
import java.time.LocalDateTime
import java.util.*

data class Checkout (
    var id: UUID? = null,
    var pedido: Pedido? = null,
    var status: StatusCheckout? = null,
    var pagamento: Pagamento? = null,
    var data: LocalDateTime? = null
)