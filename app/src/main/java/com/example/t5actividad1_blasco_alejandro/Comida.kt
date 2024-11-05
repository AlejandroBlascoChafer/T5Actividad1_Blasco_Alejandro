package com.example.t5actividad1_blasco_alejandro

class Comida(private var nombre:String, private var pais:String, private var iconId:Int) {

    fun getNombre(): String {
        return nombre
    }

    fun setNombre(nuevoNombre: String) {
        nombre = nuevoNombre
    }

    fun getPais(): String {
        return pais
    }

    fun setPais(nuevoPais: String) {
        pais = nuevoPais
    }

    fun getIcon():Int{
        return iconId
    }

    fun setIcon(nuevoIcon: Int){
        iconId = nuevoIcon
    }


}

class ComidaDatos {
    companion object {
        val COMIDAS = arrayListOf(
            Comida("Pizza", "Italia", R.drawable.ic_pizza),
            Comida("Paella", "España", R.drawable.ic_paella),
            Comida("Kebab", "Turquía", R.drawable.ic_kebab),
            Comida("Hamburguesa", "Estados Unidos", R.drawable.ic_burguer),
            Comida("Pasta", "Italia", R.drawable.ic_pasta)
        )
    }
}
