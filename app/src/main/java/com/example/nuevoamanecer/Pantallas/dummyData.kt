package com.example.nuevoamanecer.Pantallas

data class Usuario(

    val id: Int,
    val firstName: String,
    val lastName: String,
    val level: Int
)


fun getData(): List<Usuario>{

    return listOf(
        Usuario(1, "Nicolea", "Smallshaw", 2),
        Usuario(2, "Keven", "Norree", 4),
        Usuario(3, "Suzy", "Grimsdith", 2),
        Usuario(4, "Alex", "Murrish", 2),
        Usuario(5, "Margeaux", "Jurca", 2),
        Usuario(6, "Karina", "Datte", 2),
        Usuario(7, "Jeremy", "Morkham", 2),
        Usuario(8, "Locke", "Munks", 1),
        Usuario(9, "Astrid", "Mangeon", 2),
        Usuario(10, "Marge", "McAreavey", 2),
        Usuario(11, "Corey", "Brabender", 3),
        Usuario(12, "Dolli", "Bettaney", 4),
        Usuario(13, "Andris", "Arno", 4),
        Usuario(14, "Riva", "Cutler", 4),
        Usuario(15, "Garvin", "Viner", 2)
    )

}