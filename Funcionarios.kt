data class Funcionarios(
    val matricula: String,
    val nome: String,
    val salario: Double
)

fun main() {
    val func = mutableListOf<Funcionarios>()
    while (true) {
        println("\n--- Agenda de Contatos ---")
        println("1. Cadastrar 20 Funcionários")
        println("2. Pesquisar por Matricula")
        println("3. Exibir Funcionarios Ordenados (Abaixo de R$1.000,00)")
        println("4. Exibir Funcionarios Ordenados (Acima de R$1.000,00)")
        println("5. Exibir Funcionarios Ordenados (Igual a R$1.000,00)")
        println("6. Sair")
        print("Escolha uma opção: ")

        when (readLine()!!.toIntOrNull()) {
            1 -> cadastrarFunci(func)
            2 -> pesquisarMatricula(func)
            3 -> exibirMenores(func)
            4 -> exibirMaiores(func)
            5 -> exibirIgual(func)
            6 -> {
                println("Saindo...")
                return
            }
        }

    }
}

fun cadastrarFunci(func: MutableList<Funcionarios>) {
    println("--- Cadastrando Funcionario ---")

    for (i in 1..20) {
        println("Funcionario $i")

        print("Matricula: ")
        val matricula = readLine() ?: ""
        print("Nome: ")
        val nome = readLine() ?: ""
        print("Salário: ")
        val salario = readLine()!!.toDouble()

        func.add(Funcionarios(matricula, nome, salario))
    }
}

fun pesquisarMatricula(func: List<Funcionarios>){
    println("--- Pesquisar Funcionario ---")
    print("Digite a Matricula do Funcionario: ")
    val lerMatri = readLine()?:""

    val pesquisa = func.find { it.matricula == lerMatri }

    if (pesquisa != null){
        println("Funcionário Encontrado")
        println("Nome: ${pesquisa.nome}")
        println("Matricula: ${pesquisa.matricula}")
        println("Salario: ${pesquisa.salario}")
    }else{
        println("Funcionaio Não Existe")
    }
}



fun exibirMenores(func: List<Funcionarios>){
    if (func.isEmpty()) {
        println("Nenhum Registro Encontrado.")
    } else {
        val funcOrdenados = func.sortedBy { it.matricula }
        println("\n--- Todos Funcionarios Abaixo de R$1.000,00 ---")

        val menores = funcOrdenados.filter { it.salario < 1000 }

        if (menores.isNotEmpty()) {
            for (Funcionarios in menores) {
                println("Nome: ${Funcionarios.nome}")
                println("Matricula: ${Funcionarios.matricula}")
                println("Salário: ${Funcionarios.salario}")
                println("-----------------------------")
            }
        }
        else{
            println("Nenhuma Pessoa Menor que 1.5m Encontrada")
        }

    }
}

fun exibirMaiores(func: List<Funcionarios>){
    if (func.isEmpty()) {
        println("Nenhum Registro Encontrado.")
    } else {
        val funcOrdenados = func.sortedBy { it.matricula }
        println("\n--- Todos Funcionarios Abaixo de R$1.000,00 ---")

        val maiores = funcOrdenados.filter { it.salario > 1000 }

        if (maiores.isNotEmpty()) {
            for (Funcionarios in maiores) {
                println("Nome: ${Funcionarios.nome}")
                println("Matricula: ${Funcionarios.matricula}")
                println("Salário: ${Funcionarios.salario}")
                println("-----------------------------")
            }
        }
        else{
            println("Nenhuma Pessoa Menor que 1.5m Encontrada")
        }

    }
}

fun exibirIgual(func: List<Funcionarios>){
    if (func.isEmpty()) {
        println("Nenhum Registro Encontrado.")
    } else {
        val funcOrdenados = func.sortedBy { it.matricula }
        println("\n--- Todos Funcionarios Abaixo de R$1.000,00 ---")

        val igual = funcOrdenados.filter { it.salario == 1000.0 }

        if (igual.isNotEmpty()) {
            for (Funcionarios in igual) {
                println("Nome: ${Funcionarios.nome}")
                println("Matricula: ${Funcionarios.matricula}")
                println("Salário: ${Funcionarios.salario}")
                println("-----------------------------")
            }
        }
        else{
            println("Nenhuma Pessoa Menor que 1.5m Encontrada")
        }

    }

}
