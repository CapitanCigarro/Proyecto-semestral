# Proyecto-semestral

Informacion estudiante:
    Nombre : Nícholas Fernando García Medina
    Grupo : 21

Como usar programa:
    Ejecutar programa
    Seleccionar filtros (Se pueden ignorar todos para mostrar lista de todos los buses)
    Seleccionar bus
    Seleccionar asientos
    Selecciona accion (Reservar o quitar reserva)
    En caso de reservar, seleccionar tipo de pasaje
    Presionar boton Realizar Accion
    Si desea seleccionar otro bus, presionar boton Reiniciar

Enunciado : 
    Tema 2: Sistema de reserva de asientos de autobús

    El sistema de reserva de asientos de autobús permite al personal de una empresa de autobús elegir y reservar asientos de forma conveniente por su cliente. Los usuarios pueden  visualizar una representación gráfica de los asientos disponibles en el  autobús y seleccionar los que deseen ocupar. El sistema muestra información detallada sobre cada asiento, como su ubicación, número y  categoría (por ejemplo, semi cama, Salón Cama).
    Una vez que los usuarios seleccionan los asientos deseados, el sistema verifica la disponibilidad y permite confirmar la reserva mostrando el precio a pagar. En caso de que algún asiento ya esté reservado por otro pasajero, se informa al usuario para que pueda elegir otro asiento disponible. El personal confirma el pago (no gestionado por el sistema) lo que reserva los asientos.
    El sistema debe gestionar varios tipos de autobuses (por ejemplo, con diferente número de plazas, o de 1 o 2 pisos...).
    El sistema debe mostrar un menú que permita seleccionar el autobús en función de su horario y recorrido (se supone que estos datos están disponibles con los autobuses vacíos cuando se lanza el software)


Patrones de diseño :
    Se utilizo el patron builder, puesto que encontre que seria mucho mas facil, 
    comodo y ordenado ir creando el bus, y su panel y relacionados por partes, y de a poco ir armandolo como 
    un objeto que contiene estas

    Se utilizo tambien el patron Singleton para el panel principal, empresa de buses y su gestor relacionado, puesto que pense
    que seria mas comodo usar solo una instancia de estos, y por como los programe no necesitaban en realidad mas de una instancia

Desiciones :
    Decidi hacer el proyecto solo por no recibir respuesta de mi compañero
    Decidi que los buses se creen de forma aleatoria, con esto me refiero a sus recorridos y hora de salida
    Para filtrar los tipos de buses decidi usar 3 JComboBox diferentes, para ir filtrando segun quiera el usuario
    Decidi que una parte del codigo se encargara de crear cada bus, los cuales se arman "solos"
    Preferi usar colores oscuros principalmente, puesto que a mi preferencia es mas comodo visualmente

Problemas encontrados :
    Si bien no senti que tuve dificultades mayores, tuve problemas al mostrar las partes de la interfaz visual, 
    en multiples ocasiones tuve que estar un buen rato viendo una parte del codigo para que se mostrara como 
    queria la interfaz grafica, tambien siento que pude haber mejorado la organizacion en esa parte

