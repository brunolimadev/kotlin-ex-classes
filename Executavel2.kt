package Aula13

import java.util.*
import kotlin.random.Random

var banco = Banco()
var scanner: Scanner = Scanner(System.`in`)

fun main() {
    2
    menu()
}

fun menu() {
    println("1 -> Digite 1 para uma nova criar conta")
    println("2 -> Digite 2 para selecionar uma conta existente")
    println("3 -> Digite 3 para remover uma conta")
    println("4 -> Digite 4 para gerar relatório")
    println("5 -> Digite 5 para finalizar a operação")

    var result = scanner.nextInt()

    when (result) {
        1 -> opcao_1()
        2 -> opcao_2()
        3 -> opcao_3()
        4 -> opcao_4()
        5 -> {
            println("Obrigado por usar nosso sistema")
            return
        }
        else -> {
            println("Opção inválida, tente novamente")
            menu()
        }
    }
}

fun opcao_1() {
    println("1 -> Criar conta corrente");
    println("2 -> Criar conta poupança")

    var result = scanner.nextInt()

    when (result) {
        1 -> {
            var cc = ContaCorrente(Random.nextInt(0, 9999), 0.0)
            println("Conta corrente criada com sucesso!")
            banco.inserir(cc)
            menu()
        }
        2 -> {
            var cp = ContaPoupanca(Random.nextInt(10000, 50000), 0.0)
            println("Conta poupança criada com sucesso!")
            banco.inserir(cp)
            menu()
        }
        else -> {
            println("Opção Inválida")
            opcao_1()
        }
    }
}

fun opcao_2() {
    println("Por favor, digite o numero da conta:")
    var result = scanner.nextInt()
    var contraEncontrada = banco.procurarConta(result)

    if (contraEncontrada != null) {
        println("1 -> Depositar");
        println("2 -> Sacar")
        println("3 -> Transferir")
        println("4 -> Gerar relatório")
        println("5 --> Retornar ao menu anterior")
        var result = scanner.nextInt()

        when (result) {
            1 -> {
                println("Digite o valor desejado")
                var result = scanner.nextDouble()
                contraEncontrada.depositar(result)
                println("Depósito efetuado")
                menu()
            }
            2 -> {
                println("Digite o valor desejado")
                var result = scanner.nextDouble()
                contraEncontrada.sacar(result)
                println("Saque efetuado")
                menu()
            }
            3 -> {
                println("Digite o numero da conta de destino")
                var result = scanner.nextInt()
                var contaDestino = banco.procurarConta(result)
                if (contaDestino != null) {
                    println("Digite o valor desejado")
                    var result = scanner.nextDouble()
                    contraEncontrada.transferir(result, contaDestino)
                    println("Transferência efetuada")
                    menu()
                }

            }
            4 -> {
                println("Conta: ${contraEncontrada.numeroConta}\nSaldo: ${contraEncontrada.saldo}")
                println("---------------------------------------------")
                menu()
            }
            else -> {
                menu()
            }
        }
    } else {
        println("Conta inexistente")
        menu()
    }
}

fun opcao_3() {

    println("Por favor, digite o numero da conta:")
    var result = scanner.nextInt()
    var contraEncontrada = banco.procurarConta(result)

    if (contraEncontrada != null) {
        println("1 -> Remover conta");
        println("2 -> Sair")
        println("Por favor, digite o numero da conta")
        var result = scanner.nextInt()

        when (result) {
            1 -> {
                banco.remover(contraEncontrada)
                println("Conta removida com sucesso")
                menu()
            }
            else -> return
        }
    } else {
        println("Conta inexistente")
        menu()
    }

}

fun opcao_4() {
    banco.mostrarDados()
    menu()
}