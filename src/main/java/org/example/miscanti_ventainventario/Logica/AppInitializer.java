package org.example.miscanti_ventainventario.Logica;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Inicializa y configura la bodega
        Bodega bodega = BodegaManagment.getBodega();
        sce.getServletContext().setAttribute("bodega", bodega);
        System.out.println("Bodega inicializada y añadida al contexto de aplicación.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Liberar recursos si es necesario al detener la aplicación
        System.out.println("Aplicación detenida. Recursos liberados.");
    }
}
