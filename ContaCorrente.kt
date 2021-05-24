package Aula13

import Aula9.Conta

class ContaCorrente(override val numeroConta: Int, override var saldo: Double) : ContaBancaria(), Imprimivel {

    val taxaDeOperacao: Double = 15.00

    override fun sacar(valor: Double) {
        when {
            valor + taxaDeOperacao > this.saldo -> {
                println("Saldo insuficiente")
                println("---------------------------------------------")
            }
            else -> this.saldo -= valor
        }
    }

    override fun depositar(valor: Double) {
        this.saldo = valor - taxaDeOperacao
    }

    override fun mostrarDados() {
        println("Conta: $numeroConta\nSaldo:$saldo\nTaxa de Operação: $taxaDeOperacao")
        println("---------------------------------------------")
    }

    override fun transferir(valor: Double, conta: ContaBancaria) {
        this.sacar(valor)
        conta.depositar(valor)
    }

}