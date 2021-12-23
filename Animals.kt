/*
* Hacer un programa con entrada de inforación (teclado) ocupando lo siguiente
* Funciones
* Ciclo (do while)
* Imprimir algun dato
* Agregar información
* */
class Animal(
    var name: String = "",
    var sex: String = "",
    var color: String = "",
    var size: String = ""
) {
    public fun printAnimal() {
        println("El nombre es: $name")
        println("El sexo es: $sex")
        println("El color es: $color")
        println("El tamaño es: $size")
    }
}

var listAnimals: MutableList<Animal> = mutableListOf()

fun main() {
    var repeat: String = "S"
    do {
        repeat = get_menu()
    } while (repeat.uppercase() == "S")
}

fun get_menu(): String {
    println("Selecciona una opcion\n1)Ingresa un animal nuevo\n2)Muestra los animales existentes\n3)Eliminar animal\n4)Salir\n")
    val option = readln().toInt()
    var result: String = "S"
    when (option) {
        1 -> get_atributes()
        2 -> get_animals(true)
        3 -> remove_animal()
        4 -> result = "N"
        else -> println("Opcion incorrecta")
    }
    return result
}

fun get_atributes() {
    println("Ingresa el nombre del animal")
    val u_name = readLine().toString()
    println("Ingresa el sexo del animal\na) Macho \nb) Hembra")
    val u_sex = readLine().toString()
    println("Ingresa el color")
    val u_color = readLine().toString()
    println("Ingresa el tamaño\na) Grande\nb)Mediano\nc)Chico")
    val u_size = readLine().toString()

    val animal = Animal().apply {
        name = u_name
        sex = u_sex
        color = u_color
        size = u_size
    }.also {
        when (it.sex) {
            "a" -> it.sex = "Macho"
            "b" -> it.sex = "Hembra"
            else -> it.sex = "Desconocido"
        }
        when (it.size) {
            "a" -> it.size = "Grande"
            "b" -> it.size = "Mediano"
            "c" -> it.size = "Chico"
            else -> it.size = "Desconocido"
        }
        listAnimals.add(it)
        println("Se agrego el animal ${it.name}")
    }
}

fun get_animals(all:Boolean) {
    for (animal in listAnimals) {
        if (all) {
            animal.printAnimal()
        } else {
            println(animal.name)
        }
    }
}

fun remove_animal() {
    println("Ingresa el nombre del animal a eliminar:")
    get_animals(false)
    val u_name = readLine().toString()
    for (animal in listAnimals) {
        if (animal.name == u_name) {
            listAnimals.remove(animal)
            println("Se elimino $u_name")
        }
    }
}
