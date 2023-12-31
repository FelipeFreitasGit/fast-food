package br.com.fiap.postech.fastfood.domain.valueObjets


class CPF(val cpf: String) {
    init {
        var regex = Regex("^\\d{11}")
        require(!cpf.isNullOrEmpty()) {
            "CPF deve ser informado"
        }
        require(regex.containsMatchIn(cpf)) {
            "CPF deve ser válido"
        }
    }

    override fun toString(): String {
        return cpf
    }
}

class Nome(val nome: String) {
    init {
        require(!nome.isNullOrEmpty()) {
            "Nome deve ser informado"
        }
    }

    override fun toString(): String {
        return nome
    }
}

class Email(val email: String) {
    var regex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
    init {
        require(!email.isNullOrEmpty()) {
            "E-mail deve ser informado"
        }
        require(regex.containsMatchIn(email)) {
            "E-mail deve ser válido"
        }
    }

    override fun toString(): String {
        return email
    }
}