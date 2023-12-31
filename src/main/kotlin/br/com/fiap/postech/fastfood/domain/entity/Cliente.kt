package br.com.fiap.postech.fastfood.domain.entity

import br.com.fiap.postech.fastfood.domain.valueObjets.CPF
import br.com.fiap.postech.fastfood.domain.valueObjets.Email
import br.com.fiap.postech.fastfood.domain.valueObjets.Nome
import java.util.UUID

data class Cliente (

    var id: UUID? = null,
    var cpf: CPF? = null,
    var nome: Nome? = null,
    var email: Email? = null
)