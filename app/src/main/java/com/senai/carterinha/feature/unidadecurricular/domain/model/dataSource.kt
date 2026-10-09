package com.senai.carterinha.feature.unidadecurricular.domain.model

fun dataSource (): List<UnidadeCurricular> {
    return listOf(
        UnidadeCurricular(id = "1",nome = "Matematica",professor = "Dr. Manuel Gomes",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "2",nome = "Portugues",professor = "Dr. House",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "3",nome = "Volei",professor = "Dr. sla",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "4",nome = "Ciencias",professor = "Dr. Sheldon",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "5",nome = "Fisica",professor = "Dr. Leonard",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "6",nome = "Biologia",professor = "Dr. ricky",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "7",nome = "Matemática 2",professor = "Dr. Brendo Gays",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
        UnidadeCurricular(id = "8",nome = "Farmar aura",professor = "Dr. da Silva",nota1 = 8.5,nota2 = 7.0,media = 7.75,faltas = 2),
    )
}