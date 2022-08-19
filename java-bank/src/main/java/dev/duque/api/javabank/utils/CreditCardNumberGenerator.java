package dev.duque.api.javabank.utils;

import java.util.Random;
import java.util.stream.IntStream;

public class CreditCardNumberGenerator {
    public String generate() {

        Random rand = new Random();

        int secondSequence_min = 100;
        int secondSequence_max = 999;

        int lastSequence_min = 1000;
        int lastSequence_max = 9999;

        Integer secondSequence = rand.nextInt(secondSequence_max-secondSequence_min) + secondSequence_min;
        Integer thirdSequence = rand.nextInt(lastSequence_max-lastSequence_min) + lastSequence_min;
        Integer lastSequence = rand.nextInt(lastSequence_max-lastSequence_min) + lastSequence_min;

        String number = "4" + secondSequence + thirdSequence + lastSequence;

        return number;

    }

}
