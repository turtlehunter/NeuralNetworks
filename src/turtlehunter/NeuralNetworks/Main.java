package turtlehunter.NeuralNetworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * turtlehunter.NeuralNetworks - uriel NeuralNetworks 5/12/2015
 */
public class Main {
    public static void and (String[] args) {
        Neuron and = new Neuron(1.5f);

        for (String val : args) {
            Neuron op = new Neuron(0.0f);
            op.setWeight(Boolean.parseBoolean(val));
            and.connect(op);
        }

        and.fire();

        System.out.println("Result: " + and.isFired());
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter parameters: ");
            try {
                args = br.readLine().split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        and(args);
    }
}
