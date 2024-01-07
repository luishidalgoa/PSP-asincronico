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
        RevisionDAO revisionDAO = RevisionDAO.getInstance();
        revisionDAO.addRevision(revision);

        System.out.println("Total de pruebas realizadas: " + contadorTotalPruebas);
        return contadorTotalPruebas;
    }

    /**
     * Realiza la prueba de identificación del vehículo.
     *
     * @param identificacion El objeto de Identificacion que representa la prueba.
     * @return El número de atributos aprobados durante la prueba.
     */
    private int identificacion(Identificacion identificacion) {
        System.out.println("Realizando prueba de Identificación...");

        int contador = 0;

        // Lógica de identificación, por ejemplo, con un 90% de probabilidad de ser aprobado
        sleep();
        boolean identificacionAprobada = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        contador += identificacionAprobada ? 1 : 0;
        System.out.println("Identificación: " + identificacionAprobada);

        // Incrementar el contador específico de la clase Identificacion
        identificacion.setContador(identificacion.getContador() + contador);

        System.out.println("Prueba de Identificación completada. Aprobada: " + identificacionAprobada);
        return contador;
    }

    /**
     * Realiza la prueba de interior del vehículo.
     *
     * @param interior El objeto de Interior que representa la prueba.
     * @return El número de atributos aprobados durante la prueba.
     */

    private int interior(Interior interior) {
        System.out.println("Realizando prueba de Interior...");

        int contador = 0;

        // Atributo antirobo
        sleep();
        boolean antiroboAprobado = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        interior.setAntirobo(antiroboAprobado);
        contador += antiroboAprobado ? 1 : 0;
        System.out.println("Antirobo: " + antiroboAprobado);

        // Atributo antideslizante
        sleep();
        boolean antideslizanteAprobado = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        interior.setAntideslizante(antideslizanteAprobado);
        contador += antideslizanteAprobado ? 1 : 0;
        System.out.println("Antideslizante: " + antideslizanteAprobado);

        // Atributo frenado
        sleep();
        boolean frenadoAprobado = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        interior.setFrenado(frenadoAprobado);
        contador += frenadoAprobado ? 1 : 0;
        System.out.println("Frenado: " + frenadoAprobado);

        // Incrementar el contador específico de la clase Interior
        interior.setContador(interior.getContador() + contador);

        System.out.println("Prueba de Interior completada. Total de atributos aprobados: " + contador);
        return contador;
    }
    /**
     * Realiza la prueba de exterior del vehículo.
     *
     * @param exterior El objeto de Exterior que representa la prueba.
     * @return El número de atributos aprobados durante la prueba.
     */

    private int exterior(Exterior exterior) {
        System.out.println("Realizando prueba de Exterior...");

        int contador = 0;

        // Lógica de prueba de LimpiaParabrisas
        sleep();
        boolean testLimpiaParabrisasAprobado = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        exterior.setTestLimpiaParabrisas(testLimpiaParabrisasAprobado);
        contador += testLimpiaParabrisasAprobado ? 1 : 0;
        System.out.println("Test Limpia Parabrisas: " + testLimpiaParabrisasAprobado);

        // Lógica de prueba de Luces
        sleep();
        boolean testLucesAprobado = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        exterior.setTestLuces(testLucesAprobado);
        contador += testLucesAprobado ? 1 : 0;
        System.out.println("Test Luces: " + testLucesAprobado);

        // Lógica de prueba de Cinturones
        sleep();
        boolean testCinturonesAprobado = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        exterior.setTestCinturones(testCinturonesAprobado);
        contador += testCinturonesAprobado ? 1 : 0;
        System.out.println("Test Cinturones: " + testCinturonesAprobado);

        // Lógica de prueba de Depósito
        sleep();
        boolean testDepositoAprobado = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        exterior.setTestDeposito(testDepositoAprobado);
        contador += testDepositoAprobado ? 1 : 0;
        System.out.println("Test Depósito: " + testDepositoAprobado);

        // Incrementar el contador específico de la clase Exterior
        exterior.setContador(exterior.getContador() + contador);

        System.out.println("Prueba de Exterior completada. Total de atributos aprobados: " + contador);
        return contador;
    }
    /**
     * Realiza la prueba de alineacion del vehículo.
     *
     * @param alineacion El objeto de Alineacion que representa la prueba.
     * @return El número de atributos aprobados durante la prueba.
     */
    private int alineacion(Alineacion alineacion) {
        System.out.println("Realizando prueba de Alineación...");

        int contador = 0;

        // Lógica de prueba de Volante
        sleep();
        boolean volanteAprobado = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        alineacion.setVolante(volanteAprobado);
        contador += volanteAprobado ? 1 : 0;
        System.out.println("Test Volante: " + volanteAprobado);

        // Lógica de prueba de Fugas
        sleep();
        boolean testFugasAprobado = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        alineacion.setTestFugas(testFugasAprobado);
        contador += testFugasAprobado ? 1 : 0;
        System.out.println("Test Fugas: " + testFugasAprobado);

        // Lógica de prueba de Dirección
        sleep();
        boolean testDireccionAprobado = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        alineacion.setTestDireccion(testDireccionAprobado);
        contador += testDireccionAprobado ? 1 : 0;
        System.out.println("Test Dirección: " + testDireccionAprobado);

        // Lógica de prueba de Amortiguación
        sleep();
        boolean amortiguacionAprobado = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        alineacion.setAmortiguacion(amortiguacionAprobado);
        contador += amortiguacionAprobado ? 1 : 0;
        System.out.println("Test Amortiguación: " + amortiguacionAprobado);

        // Incrementar el contador específico de la clase Alineacion
        alineacion.setContador(alineacion.getContador() + contador);

        System.out.println("Prueba de Alineación completada. Total de atributos aprobados: " + contador);
        return contador;
    }
    /**
     * Realiza la prueba de emisores del vehículo.
     *
     * @param emisores El objeto de Emisores que representa la prueba.
     * @return El número de atributos aprobados durante la prueba.
     */

    private int emisores(Emisores emisores) {
        System.out.println("Realizando prueba de Emisores...");

        int contador = 0;

        // Lógica de prueba de Índice
        sleep();
        float indice = random.nextFloat() * 10.0f; // Valor aleatorio entre 0 y 10
        emisores.setIndice(indice);
        System.out.println("Índice de Emisiones: " + indice);

        // Lógica de prueba de Emisiones
        sleep();
        boolean testEmisionesAprobado = random.nextDouble() <= 0.9; // 90% de probabilidad de ser true
        emisores.setTestEmisiones(testEmisionesAprobado);
        contador += testEmisionesAprobado ? 1 : 0;
        System.out.println("Test Emisiones: " + testEmisionesAprobado);

        // Incrementar el contador específico de la clase Emisores
        emisores.setContador(emisores.getContador() + contador);

        System.out.println("Prueba de Emisores completada. Total de atributos aprobados: " + contador);
        return contador;
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


