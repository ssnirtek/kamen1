import kotlin.random.Random

fun main() {
    println("Добро пожаловать в игру Камень-Ножницы-Бумага")

    while (true) {
        println("Выберите ваш ход:")
        println("1 - Камень")
        println("2 - Ножницы")
        println("3 - Бумага")
        println("4 - Выход")

        val playerChoice = readLine()?.toIntOrNull() ?: 0

        if (playerChoice == 4) {
            println("Досвидания!")
            break
        }

        if (playerChoice !in 1..3) {
            println("Некорректный ввод. Пожалуйста, введите число от 1 до 3.")
            continue
        }

        val computerChoice = Random.nextInt(1, 4)

        println("Ваш выбор: ${getChoiceName(playerChoice)}")// getChoiceName функция преобразует число в текст
        println("Выбор компьютера: ${getChoiceName(computerChoice)}")

        val result = determineWinner(playerChoice, computerChoice)// опред победителя, сохраняет в результ

        when (result) {
            1 -> println("Вы победили!")
            2 -> println("Компьютер победил!")
            3 -> println("Ничья!")
        }
    }
}

fun getChoiceName(choice: Int): String {
    return when (choice) {
        1 -> "Камень"
        2 -> "Ножницы"
        3 -> "Бумага"
        else -> "Ошибка"
    }
}

fun determineWinner(playerChoice: Int, computerChoice: Int): Int {
    if (playerChoice == computerChoice) {
        return 3 // Ничья
    } else if (
        (playerChoice == 1 && computerChoice == 3) ||
        (playerChoice == 2 && computerChoice == 1) ||
        (playerChoice == 3 && computerChoice == 2)
    ) {
        return 1 // Игрок победил
    } else {
        return 2 // Компьютер победил
    }
}