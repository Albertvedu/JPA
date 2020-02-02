package org.example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Mostrar {
    void mostrarOrdenado(EntityManager manager){
        TypedQuery<Instituto> queryInsti =
                manager.createQuery("SELECT i FROM Instituto i ORDER BY id", Instituto.class);
        List<Instituto> resultsInsti = queryInsti.getResultList();

        for (Instituto inst: resultsInsti) {
            System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t###############################   INSTITUTO  ######################################");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\tid: " + inst.getId() + "\tinstituto: " + inst.getNombre() + "\tNúmero de alumnos: " + inst.getNumAlumnos());
            TypedQuery<Clase> query =
                    manager.createQuery("SELECT c FROM Clase c WHERE instituto_id = ?1 ORDER BY id", Clase.class);
            query.setParameter(1, inst);
            List<Clase> results = query.getResultList();

            for (Clase c : results) {
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t*********************   CLASE "+c.getNombre()+ " ************************************");

                System.out.println("\t\t\t\t\t\t\t\t\t\t\tid: " + c.getId() + "\tinstituto id: " + c.getIdInstituto() + "\tNombre: " + c.getNombre()
                        + "\tNúmero Alumnos: " + c.getNAlumnos() + "\tRama: " + c.getRama());
                int cosas = c.getId();
                TypedQuery<Alumno> queryAlum =
                        manager.createQuery("SELECT a FROM Alumno a WHERE clase_id = ?1 ", Alumno.class);
                queryAlum.setParameter(1, cosas);

                List<Alumno> resultsAlum = queryAlum.getResultList();
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t*************************   ALUMNOS ***********************************");

                for (Alumno a : resultsAlum) {

                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tClase_id: " + a.getClasseId() + "\tNombre: " + a.getNombre() + "\tDNI: " + a.getDNI());
                }
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t***********************************************************************");

            }
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t###################################################################################");

        }
    }
    void mostrarBBDD(EntityManager manager){
        TypedQuery<Instituto> queryInsti =
                manager.createQuery("SELECT i FROM Instituto i ORDER BY id", Instituto.class);
        List<Instituto> resultsInsti = queryInsti.getResultList();
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t###############################   INSTITUTO  ######################################");

        for (Instituto inst: resultsInsti) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\tid: " + inst.getId() + "\tinstituto: " + inst.getNombre() + "\tNúmero de alumnos: " + inst.getNumAlumnos());
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t###################################################################################");

        TypedQuery<Clase> query =
                manager.createQuery("SELECT c FROM Clase c  ORDER BY id", Clase.class);
        List<Clase> results = query.getResultList();
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t*************************   CLASES ************************************");

        for (Clase c : results) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\tid: " + c.getId() + "\tinstituto id: " + c.getIdInstituto() + "\tNombre: " + c.getNombre()
                    + "\tNúmero Alumnos: " + c.getNAlumnos() + "\tRama: " + c.getRama());
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t***********************************************************************************");

        TypedQuery<Alumno> queryAlum =
                manager.createQuery("SELECT a FROM Alumno a ORDER BY id ", Alumno.class);
        List<Alumno> resultsAlum = queryAlum.getResultList();
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t*************************   ALUMNO ************************************");

        for (Alumno a : resultsAlum) {

            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tClase_id: " + a.getClasseId() + "\tNombre: " + a.getNombre() + "\tDNI: " + a.getDNI());
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t***********************************************************************************");
    }
}
