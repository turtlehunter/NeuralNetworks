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
        Neuron and = new Neuron(0.75f*args.length); //0.75f for each neuron means that it will only run if both are 1f (true)

        for (String val : args) { //for each input
            Neuron op = new Neuron(0.0f); //create dummy neuron
            op.setWeight(Boolean.parseBoolean(val)); //set the weight to the value
            and.connect(op); //connect the input to the and neuron
        }

        and.fire(); //run and

        System.out.println("Result and: " + and.isFired()); //result of and
    }

    public static void or (String[] args) {
        Neuron or = new Neuron(0.5f); //0.5f for each neuron means that it will run when either input is true

        for (String val : args) { //for each input
            Neuron op = new Neuron(0.0f); //create dummy neuron
            op.setWeight(Boolean.parseBoolean(val)); //set the weight to the value
            or.connect(op); //connect the input to the or neuron
        }

        or.fire(); //run or

        System.out.println("Result or: " + or.isFired()); //result of or
    }

    public static void xor (String[] args) {
        Neuron xor = new Neuron(0.5f);
        Neuron left = new Neuron(1.5f);
        Neuron right = new Neuron(0.5f);

        left.setWeight(-1.0f);
        right.setWeight(1.0f);
        xor.connect(left, right);

        for (String val : args) {
            Neuron op = new Neuron(0.0f);
            op.setWeight(Boolean.parseBoolean(val));
            left.connect(op);
            right.connect(op);
        }

        xor.fire();

        System.out.println("Result xor: " + xor.isFired());
    }

    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            if (args.length == 0) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter parameters: ");
                try {
                    args = br.readLine().split(" ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(args[0].equals("end")) {
                run = false;
                break;
            }

            and(args);
            or(args);
            xor(args);

            args = new String[]{};
        }
    }



}
