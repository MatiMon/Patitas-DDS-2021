package main;


import controllers.*;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class Routes {

    public static void main(String[] args) {
        System.out.println("Iniciando servidor...");
        //Spark.port(8080);
        Spark.port(getHerokuAssignedPort());
        Spark.staticFileLocation("/public");


        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

        HomeController homeController = new HomeController();
        SesionController sesionController = new SesionController(); //TODO controllers
        UserController userController = new UserController();

        MascotaController mascotaController = new MascotaController();
        CharacteristicsController characteristicsController = new CharacteristicsController();
        RescateController rescateController = new RescateController();


        Spark.after((request, response) -> {
            PerThreadEntityManagers.getEntityManager();
            PerThreadEntityManagers.closeEntityManager();
        });

        Spark.get("/", homeController::getHome, engine); //TODO home
        Spark.get("/login", sesionController::mostrarLogin, engine);
        Spark.post("/login", sesionController::crearSesion); //TODO ver
        Spark.post("/logout", sesionController::cerrarSesion);
        Spark.get("/usuarios/nuevo", userController::mostrarFormularioNuevoUsuario, engine);
        Spark.post("/usuarios/nuevo", userController::crearUsuario);
        Spark.get("/user-error", userController::crearUsuarioError, engine);

        Spark.get("/caracteristicas", characteristicsController::mostrarCaracteristicas, engine);

        Spark.get("/mascotas", mascotaController::mostrarMascotas, engine);
        Spark.get("/mascotas/nueva", mascotaController::mostrarFormularioMascota, engine);
        Spark.post("/mascotas/nueva", mascotaController::crearMascota);
        Spark.get("/mascota-error", mascotaController::crearMascotaError, engine);

        Spark.get("/rescates/nuevo", rescateController::mostrarFormularioRescate, engine);
        Spark.post("/rescates/nuevo",rescateController::crearRescate);
        Spark.get("/rescates-error", rescateController::crearRescateError, engine);
        Spark.get("/mascota-inexistente", rescateController::obtenerMascotaError, engine);

        Spark.get("/caracteristicas/nueva",characteristicsController::registrarNuevaCaracteristica, engine);
        Spark.get("/caracteristicas/:id",characteristicsController::getDetalleCaracteristica, engine);
        Spark.get("/caracteristicas/:id/confirmacion/", characteristicsController::getCaracteristicaAEliminar,engine);

        Spark.post("/caracteristicas/nueva",characteristicsController::crearCaracteristica);
        Spark.post("/caracteristicas/:id",characteristicsController::actualizarCaracteristica);

        Spark.post("/caracteristicas/:id/confirmacion/",characteristicsController::eliminarCaracteristica);

        Spark.get("/login-error", sesionController::crearSesionError, engine);

        /* VER:
        https://github.com/dds-utn/jpa-proof-of-concept-template/tree/modelo-consultoras
        https://github.com/dds-utn/jpa-proof-of-concept-template/tree/modelo-consultoras-sin-login
        https://github.com/dds-utn/jpa-proof-of-concept-template/tree/modelo-consultoras-con-login-en-clase
         */

        System.out.println("Servidor iniciado!");
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }



}
