open class Mascota(val nombre:String, val especie: String, var edad: Int, var peso: Double) {


    open fun actualizarPeso(peso: Double){
        this.peso = peso;
    }

    open fun incrementarEdad(){
        edad+=1;
    }
    open fun describirMascota(){
        println("""DESCRIPCION MEDICA DE LA MASCOTA: ${nombre}
            |ESPECIE: ${especie}
            |EDAD: ${edad}
            |PESO: $peso
        """.trimMargin())
    }
}