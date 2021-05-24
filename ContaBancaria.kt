package Aula13

abstract class ContaBancaria {
    abstract val numeroConta: Int
    abstract var saldo: Double

    abstract fun sacar(valor: Double)
    abstract fun depositar(valor: Double)
    abstract fun transferir(valor: Double, conta: ContaBancaria)
}