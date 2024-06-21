package com.desafioalura.literalura.principal;

import com.desafioalura.literalura.logica.Logica;

public class Principal   {
    Logica controlador;

    public void mostrarMenu(){
        System.out.println("""
                Bienvenido al sistema de consulta de libros!
                Que desea hacer?:
                1 - Consultar libro
                2 - Consultar autor
                """);
    }

    public void acciones(int opcion){
        switch(opcion){
            case 1:
                consultarLibre();
                break;
            case 2:
                consultarAutor();
                break;
            case 3:
                break;
        }
    }


}
