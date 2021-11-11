package main;


import controllers.*;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

public class Routes {

    public static void main(String[] args) {
        System.out.println("Corriendo bootstrap...");
        new Bootstrap().run();

        System.out.println("Iniciando servidor...");
        Spark.port(8080);
        Spark.staticFileLocation("/public");


        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

        HomeController homeController = new HomeController();
        SesionController sesionController = new SesionController(); //TODO controllers
        UserController userController = new UserController();

        MascotaController mascotaController = new MascotaController();

        RescateController rescateController = new RescateController();

        Map<String, Object> modelo = new HashMap<>();

        Spark.get("/", homeController::getHome, engine); //TODO home
        Spark.get("/login", sesionController::mostrarLogin, engine);
        Spark.post("/login", sesionController::crearSesion); //TODO ver
        Spark.get("/usuarios/nuevo", userController::registrarUsuario, engine);
        Spark.get("/caracteristicas", characteristicsController::mostrarCaracteristicas, engine);

        Spark.get("/mascotas/nueva", mascotaController::registrarMascota, engine);
        Spark.get("/rescates/datosPersonales", rescateController::registrarRescate, engine); //TODO ver como poner todo en el mismo html o definir otro path mejor
        Spark.get("/rescates/datosMascota", rescateController::registrarDatosMascota, engine); //TODO ver como poner todo en el mismo html o definir otro path mejor

        Spark.get("/rescates/nuevo", rescateController::registrarRescate, engine);

        Spark.get("/caracteristicas/nueva",characteristicsController::registrarNuevaCaracteristica, engine);


        /* VER:
        https://github.com/dds-utn/jpa-proof-of-concept-template/tree/modelo-consultoras
        https://github.com/dds-utn/jpa-proof-of-concept-template/tree/modelo-consultoras-sin-login
        https://github.com/dds-utn/jpa-proof-of-concept-template/tree/modelo-consultoras-con-login-en-clase
         */

        System.out.println("Servidor iniciado!");
    }


}
