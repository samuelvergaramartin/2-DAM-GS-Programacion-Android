fun main() {
    var miVariable : Int;
    miVariable = 3

    println(miVariable)

    miVariable = 5;

    println(miVariable)

    val miVariable2 : String;

    miVariable2 = "Modificada";

    println(miVariable2)

    val test : String = "Ok";

    var test2 = null;

    var test3 : String? = null;

    test3 = "Tambien puede ser string";

    val num = 4;
    val cadena = num.toString();
    val nombre = "Pepa Marcos"
    println("La inicial del nombre es: " + nombre.get(0))
    println("La inicial del nombre es: " + nombre[0])

    println("Su nombre es $nombre")
    println("Y... ${nombre}")

    val texto = """
        QUE GUAPO!!!
        MULTILINEA! COMO EN JAVA!!! 
        
        VAMOS!!!
    """;

    println(texto)

    val mensaje = """
Kotlin es un moderno lenguaje de programación que permite el uso de
cadenas multilínea que imprimen caracteres especiales como saltos de
línea, ', ", $ y otros caracteres especiales sin que tengan que ser
escapados.
"""
    println(mensaje)

    /*print("Introduzca su nombre: ")
    val nombre2 = readLine();

    println(nombre2)*/

    val rangoNumerico: IntRange = 1..10
    val rangoCaracteres: CharRange = 'a'..'z'

    println("Esto es un rango numérico: " + rangoNumerico)
    println("Esto es un rango de caracteres: " + rangoCaracteres)

    val rangoNumérico2: IntRange = 1.rangeTo(10)
    println(rangoNumérico2)

    val rango: IntProgression = 1..10 step 2 // 1, 3, 5, 7, 9
    println(rango)
    val rango3: CharProgression = 'm' downTo 'a' step 2 // m, k, i, g, e, c, a
    val rango4: IntProgression = 5 until 10 // 5, 6, 7, 8, 9

    println(5 in rangoNumerico) // true
    println(5 !in rangoNumerico) // false
    println(5 in rango)

    val cadena2 = "Hola mundo!"
    println("${cadena2 is String}") // true

    /*print("Introduce tu edad: ")
    val edad = readLine()?.toIntOrNull()

    println(edad)*/

    /*print("Introduce tu edad: ")
    val edad2 = readLine()?.toIntOrNull() ?: 18
    println(edad2)*/

    val cadena3: String? = "Hola, mundo!"
    val longitud: Int = cadena3!!.length

    println(longitud)

    val a = arrayOf(1, 2, 3, 4) // [1, 2, 3, 4]
    println(a.contentToString());

    val b = Array(5) { 0 } // [0, 0, 0, 0, 0]
    println(b.contentToString())

    val c = Array(5) { it * 2 }
    println(c.contentToString())

    val d = arrayOfNulls<String>(3) // [null, null, null]
    println(d.contentToString())

    d[1] = "Hola";
    println(d.contentToString())

    println(d.size)

    val e = IntArray(5)
// pasamos el tamaño al constructor e inicializa el array con el valor por
// defecto que, para los tipos numéricos es 0.
// [0, 0, 0, 0, 0]
    val f = BooleanArray(3)
// para el tipo Boolean el valor por defecto es false.
// [false, false, false]

    println(e.contentToString())
    println(f.contentToString())

    val g = floatArrayOf(12.5f, 24.2f, 2.1f, 30.4f)
// pasamos el valor de cada elemento
// [12.5, 24.2, 2.1, 30.4]
    val h = ByteArray(5) { (it * 2).toByte() }
// pasamos el tamaño e indicamos en la lambda el valor de inicialización
// teniendo en cuenta que it es un entero y la función debe retornar un
// valor de tipo Byte.
// [0, 2, 4, 6, 8]

    println(g.contentToString())
    println(h.contentToString())

    val i = CharArray(4)
    println(i.contentToString())
}