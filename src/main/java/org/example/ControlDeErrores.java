package org.example;

import javax.persistence.EntityManager;

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

      //  try {
            if (manager.find(Instituto.class, nombre) != null) {
                System.out.println("Este instituto ya figura en la BBDD ");
                return true;
            } else return false;
//        }catch (Exception e){
//            System.out.println("erroorrrrr");
//            return true;
//        }
    }
}
