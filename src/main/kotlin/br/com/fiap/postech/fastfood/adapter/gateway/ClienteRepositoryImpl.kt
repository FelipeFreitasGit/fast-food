package br.com.fiap.postech.fastfood.adapter.gateway

import br.com.fiap.postech.fastfood.adapter.gateway.jpa.ClienteRepositoryJpa
import br.com.fiap.postech.fastfood.adapter.gateway.schema.ClienteSchema
import br.com.fiap.postech.fastfood.adapter.presenter.toCliente
import br.com.fiap.postech.fastfood.adapter.presenter.toClienteScheme
import br.com.fiap.postech.fastfood.domain.entity.Cliente
import br.com.fiap.postech.fastfood.domain.repository.ClienteRepository
import java.util.*

class ClienteRepositoryImpl(
    private val clienteRepositoryJpa: ClienteRepositoryJpa
): ClienteRepository {

    override fun cadastrar(cliente: Cliente): Cliente {
        return clienteRepositoryJpa.save(cliente.toClienteScheme()).toCliente()
    }

    override fun buscarClientePorCpf(cpf: String): Cliente {
        return clienteRepositoryJpa.findByCpf(cpf).toCliente()
    }

    override fun buscarCPFouEmailDuplicado(cpf: String, email: String): Boolean {
        return clienteRepositoryJpa.existsCpfOrEmail(cpf, email)
    }

    override fun buscarPorId(id: UUID): Cliente? {
        val opCliente = clienteRepositoryJpa.findById(id)

        if(opCliente.isPresent){
            return opCliente.get().toCliente()
        }

        return null
    }
}