class ConsultaMedica(val mascota: Mascota, var diagnosticoMedico: String, var costoConsulta: Double) {
    var incluyeMedicacion: Boolean = false

    fun calcularCosto(): Double {
        return if (incluyeMedicacion) {
            costoConsulta * 1.15
        } else {
            costoConsulta
        }
    }

    fun mostrarConsulta() {
        println("""
            |MASCOTA: ${mascota.nombre}
            |DIAGNOSTICO: $diagnosticoMedico
            |Costo de la consulta: ${calcularCosto()}
            |MEDICACION: $incluyeMedicacion
        """.trimMargin())
    }
}