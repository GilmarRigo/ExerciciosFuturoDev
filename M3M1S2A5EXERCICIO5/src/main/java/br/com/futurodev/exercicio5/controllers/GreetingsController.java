package br.com.futurodev.exercicio5.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/mostrarvalor/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping(value = "/trabalhando/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public String mostrarTrabalhando(@PathVariable String nome){
        return "Olá " +  nome + " estamos começando nosso trabalho com Spring Boot.";
    }

    @GetMapping(value = "/calculando/{valor1}/{valor2}")
    @ResponseStatus(HttpStatus.OK)
    public String mostrarCalculando(@PathVariable String valor1, @PathVariable String valor2){
        double media = (Double.parseDouble(valor1) + Double.parseDouble(valor2)) / 2;
        return "A média dos valores " + valor1 + " + " + valor2 + " é " + media;
    }

}
