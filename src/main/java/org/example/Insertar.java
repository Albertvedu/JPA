package org.example;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class Insertar {
    ControlDeErrores control = new ControlDeErrores();

    void insertarAlumno(Scanner sc, EntityManager manager) {
        boolean existe = true;
        int idclaseAlum = 0;
        int dni = 0;
        String nombreAlumno = "";
        System.out.println("\n**********************   INSERTAR ALUMNO  **************************************\n");

        // while para verificar si existe el id de la clase
        while (existe){
            idclaseAlum = control.leerInt( sc, "\t\tId Clase: ");
            existe = control.verificaridClaseAlumno(manager, idclaseAlum);
        }
        existe = true;
        System.out.print("\t\t 1. Nombre del alumno: ");
        nombreAlumno = sc.nextLine();

        // While para verificar si el DNI ya existe
        while(existe) {
            dni = control.leerInt( sc, "\t\t DNI: ");
            existe = control.verificarDni(manager, dni);
        }
        System.out.println("\n*************************************************************************************");

        try {
            Alumno alumno = new Alumno();
            alumno.setClasseId(idclaseAlum);
            alumno.setNombre(nombreAlumno);
            alumno.setDNI(dni);

            manager.getTransaction().begin();
            manager.persist(alumno);
            manager.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Hubo algun problema en la conexión");
        }
    }

    void insertarClasse(Scanner sc, EntityManager manager){
        boolean existe = true;
        int idclase = 0;
        int idInstClase = 0;
        System.out.println("\n**********************   INSERTAR CLASE  **************************************\n");

        while(existe) {
            idclase = control.leerInt( sc, "\t\tId Clase: ");
            existe = control.verificarIdClase(manager, idclase);
        }
        existe = true;
        System.out.print("\t\tNombre de la clase: ");
        String nombreClase = sc.nextLine();
        System.out.print("\t\t 1. Rama: ");
        String rama = sc.nextLine();

        while(existe) {
            idInstClase = control.leerInt( sc, "\t\tId instituto: ");
            existe = control.verificarIdInstituto(manager, idInstClase);
        }
        System.out.println("\n*************************************************************************************");

        try {
            Clase clase = new Clase();
            clase.setId(idclase);
            clase.setNombre(nombreClase);
            clase.setRama(rama);
            clase.setNAlumnos(0);
            clase.setIdInstituto(idInstClase);
            manager.getTransaction().begin();
            manager.persist(clase);
            manager.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Hubo algun problema en la conexión");
        }
    }

    void insertarInstituto(Scanner sc, EntityManager manager){
        boolean existe = true;
        int idInst = 0;
        String nombreInst = "";
        System.out.println("\n**********************   INSERTAR INSTITUTO  **************************************\n");

        while(existe) {
            idInst = control.leerInt( sc, "\t\tId instituto: ");
            existe = control.verificarInsertInsti(manager, idInst);
        }
        existe = true;

        while(existe) {
            System.out.print("\t\t 1. Nombre instituto: ");
            nombreInst = sc.nextLine();

            existe = control.verificarNombreInst(manager, nombreInst);
        }

        try {
            Instituto puig = new Instituto();
            puig.setId(idInst);
            puig.setNombre(nombreInst);
            puig.setNumAlumnos(0);
            manager.getTransaction().begin();
            manager.persist(puig);
            manager.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Hubo algun problema en la conexión");
        }

    }

}
