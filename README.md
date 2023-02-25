<h1 align="center">PG_C01 Monitorización del proceso de pruebas con Git-Travis-Codecov</h1>


[![Java CI](https://github.com/sdg1002/poolobject/actions/workflows/ci.yml/badge.svg)](https://github.com/sdg1002/poolobject/actions/workflows/ci.yml) [![Build Status](https://app.travis-ci.com/sdg1002/poolobject.svg?branch=master)](https://app.travis-ci.com/sdg1002/poolobject) [![codecov](https://codecov.io/gh/sdg1002/poolobject/branch/master/graph/badge.svg)](https://codecov.io/gh/sdg1002/poolobject)



## Autores:

- [Ana Salces Mansilla](https://github.com/AnaSalces)
- [Santiago Gómez Díaz-Guillamón](https://github.com/sdg1002)

## Índice

* [Título](https://github.com/sdg1002/poolobject/edit/master/README.md#pg_c01-monitorizaci%C3%B3n-del-proceso-de-pruebas-con-git-travis-codecov)
* [Autores](https://github.com/sdg1002/poolobject/edit/master/README.md#autores)
* [Índice](https://github.com/sdg1002/poolobject/edit/master/README.md#%C3%ADndice)
* [Objetivos de la práctica](https://github.com/sdg1002/poolobject/edit/master/README.md#objetivos-de-la-pr%C3%A1ctica) 
* [Enunciado](https://github.com/sdg1002/poolobject/edit/master/README.md#enunciado)
* [Software](https://github.com/sdg1002/poolobject/edit/master/README.md#software)


## Objetivos de la práctica

- Comprender los objetivos de medición relacionados con la caracterización y la evaluación de productos, procesos y recursos software
- Comprender, aplicar y analizar técnicas de medición sobre entidades de productos software relacionados con conjuntos de pruebas de software
- Comprender, aplicar y analizar medidas relacionadas sobre entidades de proceso y recursos de prueba del software

## Enunciado
En la práctica se va simular un pequeño desarrollo de un producto software para realizar mediciones sobre él. El objetivo es establecer un caso de estudio que sirva para caracterizar y evaluar tanto el producto
desarrollado como el proceso seguido.

  `(a) Descripción del producto`

Dado un código de ejemplo del patrón diseño creacional Pool Object, se debe crear una batería de pruebas tal que las coberturas de sus clases sean del 100%. El código de las clases se puede obtener en el repositorio
https://github.com/clopezno/poolobject . La batería de pruebas JUnit debe estar contenida en la clase ubu.gii.dass.test.c01.ReuseblePoolTest.java.

  `(b) Descripción del proceso`
  
El proceso de desarrollo de la batería de pruebas se va a gestionar utilizando el control de versiones del sistema Git proporcionado por el repositorio de proyectos GitHub ( https://github.com).
Los pasos para gestionar el procesos son los siguientes:
- 1. Cada miembro del equipo tiene que estar registrado en GitHub, Travis CI y Codecov.io.
- 2. Uno de los miembros tiene que realizar un fork del repositorio donde se encuentra el código que se quiere probar 
https://github.com/clopezno/poolobject. El nuevo repositorio tiene que ser público.
- 3. Invitar al resto de miembros del equipo para que puedan participar en el desarrollo de las pruebas.
- 4. Vincular el proyecto con Travis CI y Codecov.io.
- 5. Cada nuevo test realizado ejecutar un commit/push al repositorio del grupo. El texto del commit tiene que describir el caso de prueba añadido.
- 6. Verificar el resultado de las pruebas en el pipeline de integración continua y cómo la calidad del producto va mejorando con las sucesivas integraciones


## Preguntas

**¿Se ha realizado trabajo en equipo?**

**¿Tiene calidad el conjunto de pruebas disponibles?**

**¿Cuál es el esfuerzo invertido en realizar la actividad?**

**¿Cuál es el número de fallos encontrados en el código?**

## Software

