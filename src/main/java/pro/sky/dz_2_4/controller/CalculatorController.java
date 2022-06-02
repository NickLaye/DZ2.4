package pro.sky.dz_2_4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.dz_2_4.service.CalculatoeService;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatoeService calculatoeService;

    public CalculatorController(CalculatoeService calculatoeService) {
        this.calculatoeService = calculatoeService;
    }

    @GetMapping
    String greetings() {
        return calculatoeService.greetings();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Float a,
                       @RequestParam(value = "num2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Не правильно переданы параметры";
        }
        return buildString(a, b, calculatoeService.plus(a, b), "+");
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Float a,
                        @RequestParam(value = "num2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Не правильно переданы параметры";
        }
        return buildString(a, b, calculatoeService.minus(a, b), "-");
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Float a,
                           @RequestParam(value = "num2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Не правильно переданы параметры";
        }
        return buildString(a, b, calculatoeService.multiply(a, b), "*");
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Float a,
                         @RequestParam(value = "num2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Не правильно переданы параметры";
        }
        if (b == 0) {
            return "На ноль делить нельзя!";
        }
        return buildString(a, b, calculatoeService.divide(a, b), "/");
    }

    private String buildString(float a, float b, float result, String operation) {
        return String.format("%.1f %s %.1f = %.1f", a, operation, b, result);
    }

}
