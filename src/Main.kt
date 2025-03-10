fun main() {
    val mascotas = mutableListOf<Mascota>()
    val consultas = mutableListOf<ConsultaMedica>()

    var opcion: Int
    do {
        println(
            """
            1. Registrar Mascota
            2. Registrar consulta medica
            3. buscar historial
            4. editar peso
            5. incrementar edad de la mascota.
            6. mostrar todas las mascotas.
            7. Salir
        """.trimIndent()
        )
        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("\n--- REGISTRAR MASCOTA ---")
                print("Nombre: ")
                val nombre = readln()
                print("Especie: ")
                val especie = readln()
                print("Edad: ")
                val edad = readln().toInt()
                print("Peso: ")
                val peso = readln().toDouble()

                val mascota = Mascota(nombre, especie, edad, peso)
                mascotas.add(mascota)
                println("Mascota registrada exitosamente.")
            }

            2 -> {
                println("\n--- REGISTRAR CONSULTA MÉDICA ---")
                if (mascotas.isEmpty()) {
                    println("No hay mascotas registradas.")
                } else {
                    print("Nombre de la mascota: ")
                    val nombreMascota = readln()
                    val mascotaSeleccionada = mascotas.find { it.nombre == nombreMascota }
                    if (mascotaSeleccionada != null) {
                        print("Diagnóstico: ")
                        val diagnostico = readln()
                        print("Costo de la consulta: ")
                        val costo = readln().toDouble()
                        print("¿Incluye medicación? (true/false): ")
                        val incluyeMedicacion = readln().toBoolean()
                        val consulta = ConsultaMedica(mascotaSeleccionada, diagnostico, costo)
                        consulta.incluyeMedicacion = incluyeMedicacion
                        consultas.add(consulta)
                        println("Consulta registrada exitosamente.")
                    } else {
                        println("No se encontró una mascota con ese nombre.")
                    }
                }
            }

            3 -> {
                println("\n--- BUSCAR HISTORIAL MÉDICO ---")
                if (mascotas.isEmpty()) {
                    println("No hay mascotas registradas.")
                } else {
                    println("Seleccione una mascota:")
                    mascotas.forEachIndexed { index, mascota ->
                        println("${index + 1}. ${mascota.nombre} (${mascota.especie})")
                    }
                    print("Opción: ")
                    val opcionMascota = readln().toInt() - 1

                    if (opcionMascota in mascotas.indices) {
                        val mascotaSeleccionada = mascotas[opcionMascota]
                        val consultasMascota = consultas.filter { it.mascota == mascotaSeleccionada }

                        if (consultasMascota.isEmpty()) {
                            println("No hay consultas registradas para ${mascotaSeleccionada.nombre}.")
                        } else {
                            println("Historial de consultas para ${mascotaSeleccionada.nombre}:")
                            consultasMascota.forEach { it.mostrarConsulta() }
                        }
                    } else {
                        println("Opción no válida.")
                    }
                }
            }

            4 -> {
                println("\n--- EDITAR PESO DE MASCOTA ---")
                if (mascotas.isEmpty()) {
                    println("No hay mascotas registradas.")
                } else {
                    println("Seleccione una mascota:")
                    mascotas.forEachIndexed { index, mascota ->
                        println("${index + 1}. ${mascota.nombre} (${mascota.especie})")
                    }
                    print("Opción: ")
                    val opcionMascota = readln().toInt() - 1

                    if (opcionMascota in mascotas.indices) {
                        val mascotaSeleccionada = mascotas[opcionMascota]
                        print("Nuevo peso: ")
                        val nuevoPeso = readln().toDouble()

                        mascotaSeleccionada.actualizarPeso(nuevoPeso)
                        println("Peso actualizado exitosamente.")
                    } else {
                        println("Opción no válida.")
                    }
                }
            }

            5 -> {
                println("\n--- INCREMENTAR EDAD DE MASCOTA ---")
                if (mascotas.isEmpty()) {
                    println("No hay mascotas registradas.")
                } else {
                    println("Seleccione una mascota:")
                    mascotas.forEachIndexed { index, mascota ->
                        println("${index + 1}. ${mascota.nombre} (${mascota.especie})")
                    }
                    print("Opción: ")
                    val opcionMascota = readln().toInt() - 1

                    if (opcionMascota in mascotas.indices) {
                        val mascotaSeleccionada = mascotas[opcionMascota]
                        mascotaSeleccionada.incrementarEdad()
                        println("Edad incrementada exitosamente.")
                    } else {
                        println("Opción no válida.")
                    }
                }
            }

            6 -> {
                println("\n--- LISTA DE MASCOTAS ---")
                if (mascotas.isEmpty()) {
                    println("No hay mascotas registradas.")
                } else {
                    mascotas.forEach { it.describirMascota() }
                }
            }

            7 -> {
                println("ADIOOS...")
            }
        }
    } while (opcion != 7)
}