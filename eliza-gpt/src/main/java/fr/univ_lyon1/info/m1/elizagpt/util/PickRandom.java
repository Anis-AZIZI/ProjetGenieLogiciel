package fr.univ_lyon1.info.m1.elizagpt.util;

import java.util.Random;
/**
 * Pickrandom.
 */
public final class PickRandom {
    private static final Random RANDOM = new Random();
    /**
     * bloquer l'instanciation de la classe.
     */
    private PickRandom() { }

    /**
     * pickrandom.
     */
    public static <T> T pickRandom(final T[] array) {
        return array[RANDOM.nextInt(array.length)];
    }
}
