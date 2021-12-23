class Animal(
    var name: String = "",
    var sex: String = "",
    var color: String = "",
    var size: String = ""
) {
    fun printAnimal() {
        println("El nombre es: $name")
        println("El sexo es: $sex")
        println("El color es: $color")
        println("El tamaño es: $size\n")
    }
}

var listAnimals: MutableList<Animal> = mutableListOf()

fun main() {
    var repeat: String
    do {
        repeat = getMenu()
    } while (repeat.uppercase() == "S")
}

fun getMenu(): String {
    println("Selecciona una opción\n1)Ingresa un animal nuevo\n2)Muestra los animales existentes\n3)Eliminar animal\n4)Salir\n")
    val option = readln().toInt()
    var result = "S"
    when (option) {
        1 -> getAttributes()
        2 -> getAnimals(true)
        3 -> removeAnimal()
        4 -> result = "N"
        else -> println("Opción incorrecta")
    }
    return result
}

fun getAttributes() {
    println("Ingresa el nombre del animal")
    val uName = readLine().toString()
    println("Ingresa el sexo del animal\na) Macho \nb) Hembra")
    val uSex = readLine().toString()
    println("Ingresa el color")
    val uColor = readLine().toString()
    println("Ingresa el tamaño\na) Grande\nb)Mediano\nc)Chico")
    val uSize = readLine().toString()

    val animal = Animal().apply {
        name = uName
        sex = uSex
        color = uColor
        size = uSize
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
    }
    println("Se agrego el animal ${animal.name}")
}

fun getAnimals(all: Boolean) {
    for (animal in listAnimals) {
        if (all) {
            animal.printAnimal()
        } else {
            println(animal.name)
        }
    }
}

fun removeAnimal() {
    println("Ingresa el nombre del animal a eliminar:")
    getAnimals(false)
    val uName = readLine().toString()
    for (animal in listAnimals) {
        if (animal.name == uName) {
            listAnimals.remove(animal)
            println("Se elimino $uName")
        }
    }
}
