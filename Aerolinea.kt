import java.util.*

// Clase que representa un vuelo.
data class Vuelo(val destino: String, val costo: Int, val distancia: Int)

// Clase que representa un aeropuerto.
data class Aeropuerto(val nombre: String)

// Clase que representa un grafo de aerolínea con aeropuertos y vuelos.
class GrafoAerolinea {
    private val vertices: MutableMap<String, MutableList<Vuelo>> = HashMap()

    // Método para agregar un aeropuerto al grafo.
    fun agregarAeropuerto(aeropuerto: String) {
        // Agrega un aeropuerto al grafo con una lista de vuelos vacía.
        vertices[aeropuerto] = ArrayList()
    }

    // Método para agregar un vuelo al grafo.
    fun agregarVuelo(origen: String, destino: String, costo: Int, distancia: Int) {
        // Verifica si el aeropuerto de origen existe en el grafo.
        if (!vertices.containsKey(origen)) {
            // Imprime un mensaje de error si el aeropuerto de origen no se encuentra y retorna.
            println("Aeropuerto de origen no encontrado. Por favor, agregue el aeropuerto primero.\n")
            return
        }

        // Crea un objeto Vuelo y lo agrega a la lista de vuelos del aeropuerto de origen.
        val vuelo = Vuelo(destino, costo, distancia)
        vertices[origen]!!.add(vuelo)
    }

    // Método para obtener la lista de vuelos de un aeropuerto.
    fun obtenerVuelos(aeropuerto: String): List<Vuelo>? {
        // Devuelve la lista de vuelos desde un aeropuerto dado.
        return vertices[aeropuerto]
    }
}

// Clase principal que contiene el método main para ejecutar el programa.
fun main() {
    // Crea una instancia de GrafoAerolinea para gestionar aeropuertos y vuelos.
    val grafoAerolinea = GrafoAerolinea()

    // Utiliza un Scanner para gestionar la entrada del usuario.
    val scanner = Scanner(System.`in`)

    // Bucle principal que muestra un menú y procesa la opción seleccionada por el usuario.
    while (true) {
        // Muestra el menú de opciones.
        println("Menú:")
        println("1. Agregar Aeropuerto")
        println("2. Agregar Vuelo")
        println("3. Mostrar Vuelos de un Aeropuerto")
        println("4. Salir")
        print("Seleccione una opción: ")

        // Lee la opción seleccionada por el usuario y consume la nueva línea.
        val opcion = scanner.nextInt()
        scanner.nextLine()

        // Realiza acciones según la opción seleccionada.
        when (opcion) {
            1 -> {
                // Agrega un nuevo aeropuerto al grafo.
                print("Ingrese el nombre del aeropuerto: ")
                val nombreAeropuerto = scanner.nextLine()
                grafoAerolinea.agregarAeropuerto(nombreAeropuerto)
                println("Aeropuerto agregado correctamente.\n")
            }

            2 -> {
                // Agrega un nuevo vuelo al grafo.
                print("Ingrese el aeropuerto de origen: ")
                val origen = scanner.nextLine()
                print("Ingrese el aeropuerto de destino: ")
                val destino = scanner.nextLine()
                print("Ingrese el costo del vuelo: ")
                val costo = scanner.nextInt()
                print("Ingrese la distancia del vuelo: ")
                val distancia = scanner.nextInt()
                grafoAerolinea.agregarVuelo(origen, destino, costo, distancia)
                println("Vuelo agregado correctamente.\n")
            }

            3 -> {
                // Muestra los vuelos de un aeropuerto específico.
                print("Ingrese el nombre del aeropuerto para mostrar sus vuelos: ")
                val nombreAeropuertoMostrar = scanner.nextLine()
                val vuelos = grafoAerolinea.obtenerVuelos(nombreAeropuertoMostrar)
                if (vuelos != null) {
                    for (vuelo in vuelos) {
                        println("Destino: ${vuelo.destino}, Costo: ${vuelo.costo}, Distancia: ${vuelo.distancia}")
                    }
                } else {
                    println("Aeropuerto no encontrado.\n")
                }
            }

            4 -> {
                // Sale del programa.
                println("Saliendo del programa.")
                System.exit(0)
            }

            else -> {
                // Muestra un mensaje de error si la opción no es válida.
                println("Opción no válida. Intente de nuevo.\n")
            }
        }
    }
}
