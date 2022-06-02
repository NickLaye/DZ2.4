package pro.sky.dz_2_4.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatoeService {

    public String greetings() {
        return "Добро пожаловать в калькулятор";
    }

    public float plus(float a, float b) {
        return a + b;
    }

    public float minus(float a, float b) {
        return a - b;
    }

    public float multiply(float a, float b) {
        return a * b;
    }

    public float divide(float a, float b) {
        return a / b;
    }

}
