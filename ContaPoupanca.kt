package Aula13

class ContaPoupanca(override val numeroConta: Int, override var saldo: Double) : ContaBancaria(), Imprimivel {

    val limite: Double = 500.00

    override fun sacar(valor: Double) {
        when {
            (valor + this.limite) > this.saldo -> {
                println("Saldo insuficiente")
                println("---------------------------------------------")
            }
            else -> this.saldo -= valor
        }
    }

    override fun depositar(valor: Double) {
        this.saldo = valor
    }

    override fun mostrarDados() {
        println("Conta Poupança: $numeroConta\nSaldo: $saldo\nLimite de Crédito: $limite")
        println("---------------------------------------------")
    }

    override fun transferir(valor: Double, conta: ContaBancaria) {
        this.sacar(valor)
        conta.depositar(valor)
    }

}