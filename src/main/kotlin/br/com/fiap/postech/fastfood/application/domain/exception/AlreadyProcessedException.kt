package br.com.fiap.postech.fastfood.application.domain.exception

class AlreadyProcessedException(s: String, exception: Exception?): Exception(s, exception) {
    constructor(s: String) : this(s, null)
}