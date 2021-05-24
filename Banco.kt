package Aula13

class Banco(var contas: MutableList<ContaBancaria?> = mutableListOf()) : Imprimivel {

    fun inserir(conta: ContaBancaria): Unit {
        this.contas.add(conta)
    }

    fun remover(conta: ContaBancaria): Unit {
        var index = this.contas.indexOfFirst { it?.numeroConta == conta.numeroConta }

        if (index != -1) this.contas.removeAt(index) else println("Conta não encontrada")
    }

    fun procurarConta(numeroDaConta: Int): ContaBancaria? {
        if(this.contas.size > 0){
            return this.contas.filter{ it?.numeroConta == numeroDaConta }.single()
        }else{
            return null
        }
    }

    override fun mostrarDados() {
        this.contas.forEach { conta ->
            println("Conta: ${conta?.numeroConta}\nSaldo: ${conta?.saldo}")
        }
    }

}