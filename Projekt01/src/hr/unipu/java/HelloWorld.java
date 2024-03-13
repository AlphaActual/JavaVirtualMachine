package hr.unipu.java;

/**
 * This is the HelloWorld class, which is designed to print out the first argument passed to it.
 * If no arguments are passed, it prints out a default message.
 */
public class HelloWorld {

    /**
     * The main method of the HelloWorld class.
     * This method takes in an array of String arguments, and prints out the first argument.
     * If no arguments are provided, it prints out a default message.
     *
     * @param args An array of String arguments passed to the main method.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("No arguments provided!");
        }
    }
}