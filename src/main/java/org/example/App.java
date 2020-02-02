package org.example;

import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    ControlDeErrores control = new ControlDeErrores();

    public static void main( String[] args ) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("damPersistence");
        EntityManager manager = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);
        App app = new App();
        Menus menus = new Menus();

        while (true) {

            int salir = menus.menu(sc, manager);

            if (salir == 5) break;
        }
        manager.close();

    }
    void buscarAlumno(EntityManager manager, Scanner sc){

        System.out.print("\n Introduce el nombre del alumno que estas buscando: ");
        String nombreAlumno = sc.nextLine();

        TypedQuery<Alumno> queryAlumo =
                manager.createQuery("SELECT a FROM Alumno a WHERE nombre like :nombre", Alumno.class);
        queryAlumo.setParameter("nombre", nombreAlumno);
        List<Alumno> lis = queryAlumo.getResultList();
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t*************************   ALUMNO ************************************");
        for (Alumno a : lis) {

            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tClase_id: " + a.getClasseId() + "\tNombre: " + a.getNombre() + "\tDNI: " + a.getDNI());
        }

        if (lis.size() == 0){
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo existe este alumno en la BBDD");
        }
    }

    void actualizarNumeroAlumnos(EntityManager manager){

        TypedQuery<Integer> queryClaseId =
                (TypedQuery<Integer>) manager.createQuery("SELECT id FROM Clase");
        List<Integer> resultsClases = queryClaseId.getResultList();

        for (Integer clasesId : resultsClases) {
            Query<Long> query =
                    (Query<Long>) manager.createQuery("SELECT  COUNT(*) FROM Alumno WHERE clase_id = ?1 ");
            query.setParameter(1, clasesId);
            //query.setParameter(2, institutoId);

            Long results = query.getSingleResult();
            Clase clase = manager.find(Clase.class, clasesId);

            clase.setNAlumnos(Math.toIntExact(results));

            manager.getTransaction().begin();
            manager.persist(clase);
            manager.getTransaction().commit();
        }
        //}


    }
    void actualizarAlumnosInsti(EntityManager manager){
        int suma = 0;
        TypedQuery<Integer> queryInstiId =
                (TypedQuery<Integer>) manager.createQuery("SELECT id FROM Instituto ");
        List<Integer> resultsInsti = queryInstiId.getResultList();

        for (Integer idInst: resultsInsti){
            Instituto instituto = manager.find(Instituto.class, idInst);
            TypedQuery<Clase> query =
                    manager.createQuery("SELECT c FROM Clase c WHERE instituto_id = ?1", Clase.class);
            query.setParameter(1,idInst);
            List<Clase> results = query.getResultList();

            for (Clase a: results){
                suma  += a.getNAlumnos();
            }
            instituto.setNumAlumnos((suma));
            manager.getTransaction().begin();
            manager.persist(instituto);
            manager.getTransaction().commit();
            suma = 0;
        }
    }

}