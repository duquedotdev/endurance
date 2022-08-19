package dev.duque.api.javabank.utils;

import java.util.Random;
import java.util.stream.IntStream;

public class CreditCardNumberGenerator {

    public String challangerGeneration() {

        Random rand = new Random();

        int startOfNumber_min = 51;
        int startOfNumber_max = 55;

        int secondSequence_min = 10;
        int secondSequence_max = 99;

        int lastSequence_min = 1000;
        int lastSequence_max = 9999;

        IntStream numberStart = rand.ints(1, startOfNumber_min, startOfNumber_max);
        IntStream secondSequence = rand.ints(1, secondSequence_min, secondSequence_max);
        IntStream thirdSequence = rand.ints(1, lastSequence_min, lastSequence_max);
        IntStream lastSequence = rand.ints(1, lastSequence_min, lastSequence_max);

        String number = numberStart.toString() + secondSequence.toString() + thirdSequence.toString() + lastSequence.toString();

        return number;

    }

    public String sightGeneration() {

        Random rand = new Random();

        int secondSequence_min = 100;
        int secondSequence_max = 999;

        int lastSequence_min = 1000;
        int lastSequence_max = 9999;

        IntStream secondSequence = rand.ints(1, secondSequence_min, secondSequence_max);
        IntStream thirdSequence = rand.ints(1, lastSequence_min, lastSequence_max);
        IntStream lastSequence = rand.ints(1, lastSequence_min, lastSequence_max);

        String number = "4" + secondSequence.toString() + thirdSequence.toString() + lastSequence.toString();

        return number;

    }

}
