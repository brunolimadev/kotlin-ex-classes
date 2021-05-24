package Aula13

fun main(){

    val cp1 = ContaPoupanca(123,0.0)
    val cc1 = ContaCorrente(1122, 0.0)

    cp1.depositar(1000.00)
    cc1.depositar(5000.00)

    cp1.sacar(2000.00)
    cc1.sacar(500.00)

    val relatorio = Relatorio()

    relatorio.gerarRelatorio(cp1)
    relatorio.gerarRelatorio(cc1)

    val banco = Banco()
    banco.inserir(cc1)
    banco.inserir(cp1)



}