package main;


import controllers.*;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class Routes {

    public static void main(String[] args) {
        System.out.println("Corriendo bootstrap...");

        System.out.println("Iniciando servidor...");
        Spark.port(8080);
        Spark.staticFileLocation("/public");


        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

        HomeController homeController = new HomeController();
        SesionController sesionController = new SesionController(); //TODO controllers
        UserController userController = new UserController();

        MascotaController mascotaController = new MascotaController();
        CharacteristicsController characteristicsController = new CharacteristicsController();
        RescateController rescateController = new RescateController();

        Map<String, Object> modelo = new HashMap<>();

        Spark.get("/", homeController::getHome, engine); //TODO home
        Spark.get("/login", sesionController::mostrarLogin, engine);
        Spark.post("/login", sesionController::crearSesion); //TODO ver
        Spark.post("/logout", sesionController::cerrarSesion);
        Spark.get("/usuarios/nuevo", userController::mostrarFormularioNuevoUsuario, engine);
        Spark.post("/usuarios/nuevo", userController::crearUsuario);
        Spark.get("/caracteristicas", characteristicsController::mostrarCaracteristicas, engine);


        Spark.get("/mascotas/nueva", mascotaController::mostrarFormularioMascota, engine);
        Spark.post("/mascotas/nueva", mascotaController::crearMascota);

        Spark.get("/rescates/nuevo", rescateController::mostrarFormularioRescate, engine);
        Spark.post("/rescates/nuevo",rescateController::crearRescate);

        Spark.get("/caracteristicas/nueva",characteristicsController::registrarNuevaCaracteristica, engine);
        Spark.post("/caracteristicas/nueva",characteristicsController::crearCaracteristica);

        Spark.get("/login-error", sesionController::crearSesionError, engine);

        /* VER:
        https://github.com/dds-utn/jpa-proof-of-concept-template/tree/modelo-consultoras
        https://github.com/dds-utn/jpa-proof-of-concept-template/tree/modelo-consultoras-sin-login
        https://github.com/dds-utn/jpa-proof-of-concept-template/tree/modelo-consultoras-con-login-en-clase
         */

        System.out.println("Servidor iniciado!");
    }


}
