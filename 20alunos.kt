data class Aluno(
    val nome: String,
    val notas: List<Float>,
    val media: Double,
    val situacao: String
)

fun main() {
    val escola = mutableListOf<Aluno>()

    while (true) {
        println("\n--- Menu ---")
        println("1. Cadastrar 10 Alunos")
        println("2. Pesquisar por nome")
        println("3. Classificar por nome")
        println("4. Exibir todos os Alunos")
        println("5. Sair")
        print("Escolha uma opção: ")

        when (readLine()?.toIntOrNull()) {
            1 -> cadastrar(escola)
            2 -> pesquisarNome(escola)
            3 -> classificaNome(escola)
            4 -> exibir(escola)
            5 -> {
                print("Saindo do Programa...")
                return
            }
            else -> println("\nOpção Inválida. Tente novamente.")
        }
    }
}

fun cadastrar(escola: MutableList<Aluno>) {
    print("\n--- Cadastrar Alunos ---\n")

    for (i in 1..3) {
        print("Cadastrar Aluno $i \n")
        print("Curso: Técnicas de Programação \n")
        print("Nome: ")
        val nome = readLine() ?: ""

        val notaAluno = mutableListOf<Float>()

        var notas = 1
        while (notas <= 4) {
            print("Vamos Colocar as Notas: \n")
            print("Nota $notas: ")
            val nota = readLine()?.toFloatOrNull()

            if (nota != null && nota in 0f..10f) {
                notaAluno.add(nota)
                notas++
            } else {
                print("Nota inválida. Digite um valor entre 0 e 10.\n")
            }
        }

        val media = notaAluno.average()
        val situacao: String
        if (media >= 5) {
            print("Aluno $nome Aprovado\n")
            situacao = "Aprovado"
        } else {
            print("Aluno $nome Reprovado\n")
            situacao = "Reprovado"
        }
        print("Média: $media \n")

        escola.add(Aluno(nome, notaAluno, media, situacao))
    }
}

fun pesquisarNome(escola: List<Aluno>) {
    print("\n--- Pesquisar Aluno ---\n")
    print("Digite o Nome do Aluno: ")
    val nome = readLine() ?: ""
    val pesquisa = escola.find { it.nome == nome } //Find é um "Pesquisar"

    if (pesquisa != null) {
        print("\n--- Aluno Encontrado ---\n")
        print("Aluno: ${pesquisa.nome}\n")
        print("Notas: ${pesquisa.notas.joinToString(", ")}\n") // Formata as notas
        print("Média: ${pesquisa.media}\n")
        print("Situação: ${pesquisa.situacao}\n")
    } else {
        print("Aluno não encontrado.\n")
    }
}

fun classificaNome(escola: MutableList<Aluno>) {
    escola.sortBy { it.nome } // Classifica a lista por nome
    println("\n--- Alunos Classificados por Nome ---")
    exibir(escola)
}

fun exibir(escola: List<Aluno>) {
    if (escola.isEmpty()) {
        println("Nenhum aluno cadastrado.")
    } else {
        println("\n--- Todos os Alunos ---")
        for (aluno in escola) {
            println("Nome: ${aluno.nome}")
            println("Notas: ${aluno.notas.joinToString(", ")}")
            println("Média: ${aluno.media}")
            println("Situação: ${aluno.situacao}\n")
            println("-----------------------------")
        }
    }
}