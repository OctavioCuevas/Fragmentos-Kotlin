private var arreglo = mutableMapOf<Any, Any>()
fun main() {
    realizar_operacion()
}

fun realizar_operacion() {
    print("Elige el tipo de operación:\n a) Suma\n b) Resta\n c) División\n d) Multiplicación\n e) Ver historial\n f) Salir\n")
    val tipo = readLine()!!.toString()
    if (tipo != "f") {
        if (tipo != "e") {
            println("Ingresa el primer número")
            val x = readLine()!!.toFloat()

            println("Ingresa el segundo número")
            val y = readLine()!!.toFloat()

            var res =
                when (tipo) {
                    in "a" -> sumar(x, y)
                    in "b" -> restar(x, y)
                    in "c" -> dividir(x, y)
                    in "d" -> multiplicar(x, y)
                    else -> "Adios"
                }
            var signo =
                when (tipo) {
                    in "a" -> "+"
                    in "b" -> "-"
                    in "c" -> "/"
                    in "d" -> "*"
                    else -> "x_x"
                }
            if (res != "Adios") {
                println("El resultado es: $res")
                arreglo.put("$x $signo $y", res)
            }
            realizar_operacion()

        } else {
            mostrarHistorial()
        }
    }
}

fun sumar(x:Float, y:Float) :Float {
    return x.plus(y)
}

fun restar(x:Float, y:Float) :Float {
    return x.minus(y)
}

fun multiplicar(x:Float, y:Float) :Float {
    return x.times(y)
}

fun dividir(x:Float, y:Float) :Float {
    return x.div(y)
}

fun mostrarHistorial() {
    val listView = arreglo.map { " El resultado de ${it.key}  es igual a ${it.value}" }
    listView.forEach { println(it) }
    realizar_operacion()
}
