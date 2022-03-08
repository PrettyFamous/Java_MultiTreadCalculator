package com.company.Generation;

import java.util.LinkedList;
import java.util.Random;

public class Generator {
    private final int amountOperands = 1000;
    private final int upperBound = 100;
    private final Random random = new Random();

    public final LinkedList<String> values = new LinkedList<>();

    private void generateString() {
        StringBuilder inputString = new StringBuilder();
        for (int i = 0; i < amountOperands - 1; i++) {
            inputString.append( random.nextInt(upperBound) )
                    .append( random.nextInt(upperBound) % 2 == 0
                             ? "+"
                             : "-");
        }
        inputString.append( random.nextInt(upperBound) ); // Последний операнд делаем отдельно,
                                                          // потому что ему не нужен оператор

        values.add(inputString.toString());
    }

    public void generate(int expressions) {
        for (int i = 0; i < expressions; i++) {
            generateString();
        }
    }
}
