package dev.iesfranciscodelosrios.psp_async_navidad.Services;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.DAO.RevisionDAO;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.*;

import java.util.Random;

/**
 * La clase Simulacion se encarga de simular el proceso de revisión de un vehículo en una ITV.
 * Utiliza distintos métodos para simular cada prueba de la revisión y guarda los resultados en la base de datos.
 * Esta clase sigue el patrón Singleton, asegurando una única instancia durante la ejecución de la aplicación.
 */
public class Simulacion {
    private static Simulacion _instance;
    private int sleepMS = 500;
    private Random random = new Random();

    private Simulacion() {}

    /**
     * Obtiene la única instancia de la clase Simulacion (Singleton).
     *
     * @return La instancia única de Simulacion.
     */
    public static Simulacion getInstance() {
        if (_instance == null) {
            _instance = new Simulacion();
        }
        return _instance;
    }

    /**
     * Inicia la simulación completa de una revisión, ejecutando cada prueba en orden y guardando los resultados en la base de datos.
     *
     * @param revision La revisión del vehículo que se va a simular.
     * @return El número total de pruebas realizadas durante la simulación.
     */
    public int startSimulacion(Revision revision) {
        int contadorTotalPruebas = 0;

        contadorTotalPruebas += identificacion(revision.getIdentificacion());
        contadorTotalPruebas += interior(revision.getInterior());
        contadorTotalPruebas += exterior(revision.getExterior());
        contadorTotalPruebas += alineacion(revision.getAlineacion());
        contadorTotalPruebas += emisores(revision.getEmisores());

        // Guardar los datos en la base de datos a través de los DAOs
        RevisionDAO revisionDAO = new RevisionDAO();
        revisionDAO.addRevision(revision);

        System.out.println("Total de pruebas realizadas: " + contadorTotalPruebas);
        return contadorTotalPruebas;
    }

    private int identificacion(Identificacion identificacion) {
        System.out.println("Realizando prueba de Identificación...");
        sleep();
        boolean aprobada = random.nextBoolean();
        identificacion.setContador(identificacion.getContador() + 1);
        System.out.println("Prueba de Identificación completada. Aprobada: " + aprobada);
        return identificacion.getContador();
    }

    private int interior(Interior interior) {
        System.out.println("Realizando prueba de Interior...");
        sleep();
        boolean aprobada = random.nextBoolean();
        interior.setContador(interior.getContador() + 1);
        System.out.println("Prueba de Interior completada. Aprobada: " + aprobada);
        return interior.getContador();
    }

    private int exterior(Exterior exterior) {
        System.out.println("Realizando prueba de Exterior...");
        sleep();
        boolean aprobada = random.nextBoolean();
        exterior.setContador(exterior.getContador() + 1);
        System.out.println("Prueba de Exterior completada. Aprobada: " + aprobada);
        return exterior.getContador();
    }

    private int alineacion(Alineacion alineacion) {
        System.out.println("Realizando prueba de Alineación...");
        sleep();
        boolean aprobada = random.nextBoolean();
        alineacion.setContador(alineacion.getContador() + 1);
        System.out.println("Prueba de Alineación completada. Aprobada: " + aprobada);
        return alineacion.getContador();
    }

    private int emisores(Emisores emisores) {
        System.out.println("Realizando prueba de Emisores...");
        sleep();
        boolean aprobada = random.nextBoolean();
        emisores.setContador(emisores.getContador() + 1);
        System.out.println("Prueba de Emisores completada. Aprobada: " + aprobada);
        return emisores.getContador();
    }

    /**
     * Simula una pausa en la ejecución del hilo.
     */
    private void sleep() {
        try {
            Thread.sleep(sleepMS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


