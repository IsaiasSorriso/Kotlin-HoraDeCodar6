data class Pessoa(
    val nome : String,
    val endereco : String,
    val telefone : String
)

fun main(){
    val agenda = mutableListOf<Pessoa>()

    while (true){
        println("\n--- Agenda de Contatos ---")
        println("1. Cadastrar 10 registros")
        println("2. Pesquisar por nome")
        println("3. Classificar por nome")
        println("4. Exibir todos os registros")
        println("5. Sair")
        print("Escolha uma opção: ")

        when (readLine()?.toIntOrNull()){
            1 -> cadastrar(agenda)
            2 -> pesquisarnNome(agenda)
            3 -> classificaNome(agenda)
            4 -> exibir(agenda)
            5 -> {
                print("Sainda do Programa...")
                return
            }
            else -> println("Opção Inválida")
        }
    }
}

fun cadastrar(agenda: MutableList<Pessoa>){
    println("Cadastar Registros \n")
    for (i in 1..10){
        print("Cadastrando Pessoa $i: \n")
        print(("Nome: "))
        val nome = readLine() ?: ""
        print(("Endereço: "))
        val endereco = readLine() ?: ""
        print(("Telefone: "))
        val telefone = readLine() ?: ""

        agenda.add(Pessoa(nome, endereco, telefone))
    }
    print("Todos os 10 Registros Cadastrados!")
}

fun pesquisarnNome(agenda : List<Pessoa>){
    print("Digite o Nome: ")
    val nome = readLine() ?: ""

    var resultado = agenda.find { it.nome == nome }

    if (resultado != null){
        println("Registro Encontrado")
        println("Nome: ${resultado.nome} \n")
        println("Endereço: ${resultado.endereco} \n")
        println("Telefone: ${resultado.telefone} \n")
    }else
        print("Nenhum Registro sobre $nome")
}

fun classificaNome(agenda : MutableList<Pessoa>){
    agenda.sortBy { it.nome  }

    println("\n--- Contatos Classificados por Nome ---")
    exibir(agenda)
}

fun exibir(agenda: List<Pessoa>) {
    if (agenda.isEmpty()) {
        println("Nenhum Registro Encontrado.")
    } else {
        println("\n--- Todos os Alunos ---")
        for (Pessoa in agenda) {
            println("Nome: ${Pessoa.nome}")
            println("Endereço: ${Pessoa.endereco}")
            println("Tel: ${Pessoa.telefone}")
            println("-----------------------------")
        }
    }
}