package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class ControlDeErrores {
    boolean verificaridClaseAlumno(EntityManager manager, int idclaseAlum){

        if ( manager.find(Clase.class, idclaseAlum) == null) {
            System.out.println("No existe este id de clase");
            System.out.println("Introduce un valor válido");
        }else return false;
        return true;
    }
    boolean verificarDni(EntityManager manager, int dni){
        if ( manager.find(Alumno.class, dni) != null) {
            System.out.println("Este alumno ya esta registrado");
            System.out.println("Introduce un valor válido");
        }else return false;
        return true;
    }
    boolean verificarIdClase(EntityManager manager, int id){

        if (manager.find( Clase.class, id ) != null){
            System.out.println("Este valor ya existe ");
            return true;
        }else return false;
    }
    boolean verificarIdInstituto(EntityManager manager, int idInsti){

        if (manager.find( Instituto.class, idInsti ) == null){
            System.out.println("Este instituto no esta en la BBDD ");
            return true;
        }else return false;
    }
    boolean verificarInsertInsti(EntityManager manager, int idInsti){

        if (manager.find( Instituto.class, idInsti ) != null){
            System.out.println("Este instituto ya figura en la BBDD ");
            return true;
        }else return false;
    }
    boolean verificarNombreInst(EntityManager manager, String nombre){

//        TypedQuery<Instituto> queryty =
//                manager.createQuery("SELECT i FROM Instituto i WHERE i.nombre like :nombre", Instituto.class);
//        queryty.setParameter("nombre", nombre);
//        List<Instituto> results = queryty.getResultList();
//
//        if ( results.size() == 0){
//            System.out.println("ok");
            return false;
//        }else{
//            System.out.println("eroror");
//            return true;
//        }
    }
    int leerInt( Scanner sc, String texto){
        int numero= 0;

        while (true){

            try {
                System.out.print(texto);
                String tex = sc.nextLine();
                numero = Integer.parseInt(tex);
                return numero;

            }catch (NumberFormatException e){
                System.out.println("Inserta un valor válido");
            }
        }
    }
    int leerOpcionMenu(Scanner sc, int numeroDeOpciones){
        boolean repetir= true;
        String texto = "";
        int numero = 0;

        while (repetir) {
            try {
                System.out.print(  "\t\t\t\n\nElige una opción: ");
                texto = sc.nextLine();
                numero = Integer.parseInt(texto);

                if (numero > 0 && numero < numeroDeOpciones) {
                    repetir = false;
                }else System.out.println("Introduce un valor válido");
            } catch (NumberFormatException e) {
                System.out.println("Ese valor no es válido");
            }
        }
        return numero;
    }
}
