package br.com.fiap.postech.fastfood.adapter.gateway.schema

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.CheckoutEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ClienteEntity
import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ProdutoEntity
import br.com.fiap.postech.fastfood.domain.valueObjets.StatusPedido
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode

@Entity(name="pedido")
data class PedidoSchema(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null,

    @OneToMany
    var itens: List<ItemPedidoSchema> = mutableListOf(),


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cliente_id", referencedColumnName = "id", insertable = false, updatable = false)
//    @Fetch(FetchMode.JOIN)
//    var cliente: ClienteEntity? = null,
//
//    @Column(name = "cliente_id")
//    var clienteId: UUID? = null,

    @Column
    var data: LocalDateTime?,

    @Column
    var status: StatusPedido?,

//    @OneToOne(mappedBy = "pedido")
//    var checkout: CheckoutEntity?,
)