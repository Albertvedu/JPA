package org.example;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class Menus {
    App app = new App();
    Mostrar mostrar = new Mostrar();
    ControlDeErrores control = new ControlDeErrores();

    int menu(Scanner sc, EntityManager manager){

        System.out.println("\n**********************   Data base Institut  **************************************\n");
        System.out.println("\t\t\t\t\t 1. Insertar datos\n" +
                "\t\t\t\t\t 2. Mostrar ordenado por institutos\n" +
                "\t\t\t\t\t 3. Mostrar con otro formato\n" +
                "\t\t\t\t\t 4. Buscar un alumno\n" +
                "\t\t\t\t\t 5. Salir");
        System.out.println("\n*************************************************************************************");

        app.actualizarNumeroAlumnos(manager);
        app.actualizarAlumnosInsti(manager);
        int opcion = control.leerOpcionMenu(sc, 6);

        switch (opcion) {
            case 1:
                mostrar.mostrarBBDD(manager);
                menuInsertarDatos(sc, manager);
                break;
            case 2:
                mostrar.mostrarOrdenado(manager);
                break;
            case 3:
                mostrar.mostrarBBDD(manager);
                break;
            case 4:
                app.buscarAlumno(manager,sc);
                break;
            case 5:
                break;
            default:
                break;
        }
        return opcion;
    }

    void menuInsertarDatos(Scanner sc, EntityManager manager){
        Insertar ins = new Insertar();

        while (true) {
            System.out.println("\n**********************   Data base Institut  **************************************\n");
            System.out.println("\t\t\t\t\t 1. Insertar Alumno\n" +
                    "\t\t\t\t\t 2. Insertar Clase\n" +
                    "\t\t\t\t\t 3. Insertar Instituto\n" +
                    "\t\t\t\t\t 4. Volver a menu ");
            System.out.println("\n*************************************************************************************");
            int opcion = control.leerOpcionMenu(sc, 5);
            app.actualizarNumeroAlumnos(manager);
            app.actualizarAlumnosInsti(manager);

            switch (opcion) {
                case 1:

                    ins.insertarAlumno(sc, manager);
                    break;
                case 2:

                    ins.insertarClasse(sc, manager);
                    break;
                case 3:
                    ins.insertarInstituto(sc, manager);
                    return;
                case 4:
                    return;
                default:
                    return;
            }
        }
    }
}
