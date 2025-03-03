data class NomeAltura(
    val nome: String,
    val altura: Double
)

fun main(){
    val data = mutableListOf<NomeAltura>()

    while (true){
        println("\n--- Agenda de Contatos ---")
        println("1. Cadastrar 10 Pessoas")
        println("2. Pessoas Menores que 1.5M")
        println("3. Pessoas Maiores que 1.5M")
        println("4. Pessoas Maiores que 1.5M e Menores que 2.0M")
        println("5. Média das Alturas")
        println("6. Sair")
        print("Escolha uma opção: ")

        when(readLine()!!.toIntOrNull()){
            1 -> cadastrarPessoa(data)
            2 -> exibirMenores(data)
            3 -> exibirMaiores(data)
            4 -> exibirEntre(data)
            5 -> media(data)
            6 -> {
                println("Saindo...")
                return
            }
        }
    }

}

fun cadastrarPessoa(data: MutableList<NomeAltura>){
    print("\n --- Cadastrar Pessoa --- \n")

    for (i in 1..10){
        print("Cadatrando Pessoa $i \n")
        print("Nome: ")
        val nome = readLine()?:""
        print("Altura em Metros: ")
        val altura = readLine()!!.toDouble()

        data.add(NomeAltura(nome, altura))
    }
    print("\n Todas as 10 pessoas foram Cadastradas!!\n")
}

fun exibirMenores(data: List<NomeAltura>){
    if (data.isEmpty()) {
        println("Nenhum Registro Encontrado.")
    } else {
        println("\n--- Todas as Pessoas Menores de 1.5M ---")

        val menores = data.filter { it.altura < 1.5 }

        if (menores.isNotEmpty()) {
            for (Pessoa in menores) {
                println("Nome: ${Pessoa.nome}")
                println("Altura: ${Pessoa.altura}")
                println("-----------------------------")
            }
        }
        else{
            println("Nenhuma Pessoa Menor que 1.5m Encontrada")
        }

    }
}

fun exibirMaiores(data: List<NomeAltura>){
    if (data.isEmpty()) {
        println("Nenhum Registro Encontrado.")
    } else {
        println("\n--- Todas as Pessoas Maiores de 1.5M ---")

        val maiores = data.filter { it.altura > 1.5 }

        if (maiores.isNotEmpty()) {
            for (Pessoa in maiores) {
                println("Nome: ${Pessoa.nome}")
                println("Altura: ${Pessoa.altura}")
                println("-----------------------------")
            }
        }else{
            println("Nenhuma Pessoa Maior que 1.5m Encontrada")
        }

    }
}

fun exibirEntre(data: List<NomeAltura>){
    if (data.isEmpty()) {
        println("Nenhum Registro Encontrado.")
    } else {
        println("\n--- Todas as Pessoas Maiores de 1.5M ---")

        val entre = data.filter { it.altura > 1.5 && it.altura < 2.0}

        if (entre.isNotEmpty()) {
            for (Pessoa in entre) {
                println("Nome: ${Pessoa.nome}")
                println("Altura: ${Pessoa.altura}")
                println("-----------------------------")
            }
        }else{
            println("Nenhuma Pessoa Maior que 1.5m e Menor que 2m Encontrada")
        }

    }
}

fun media(data: List<NomeAltura>){

    if (data.isEmpty()){
        println("--- Nenhuma Pessoa Encontrada --- ")
    }else{
        val somaAltura = data.sumOf { it.altura }

        val media = somaAltura / data.size

        println("A Média das Alturas é de $media")
    }

}