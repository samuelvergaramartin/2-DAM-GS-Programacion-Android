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

}