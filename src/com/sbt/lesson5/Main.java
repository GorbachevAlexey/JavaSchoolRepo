package com.sbt.lesson5;

import com.sbt.lesson5.classes.PinValidatorImpl;
import com.sbt.lesson5.classes.TerminalImpl;
import com.sbt.lesson5.classes.TerminalServerImpl;
import com.sbt.lesson5.exceptionClasses.*;
import com.sbt.lesson5.interfaces.PinValidator;
import com.sbt.lesson5.interfaces.Terminal;
import com.sbt.lesson5.interfaces.TerminalServer;

import java.util.Scanner;


public class Main {
    private static final int NO_CACHED_SUM = -1;

    public static void main(String[] args) {
        TerminalServer terminalServer = new TerminalServerImpl(5000);
        PinValidator pinValidator = new PinValidatorImpl("1234");
        Terminal terminal = new TerminalImpl(terminalServer, pinValidator);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the command:\n" +
                    "1 - to enter pin code\n" +
                    "2 - to display balance\n" +
                    "3 - to set money\n" +
                    "4 - to get money\n" +
                    "5 - to exit");

            String command = "";
            command = scanner.next();
            if (command.equals("5")) {
                return;
            }
            executeCommand(command, terminal, scanner, NO_CACHED_SUM);
        }
    }

    private static void executeCommand(String command, Terminal terminal, Scanner scanner, int prevSum) {
        int sum = prevSum;
        switch (command) {
            case "1": {
                validate(scanner, terminal);
                break;
            }
            case "2":
                try {
                    System.out.println("Balance - " + terminal.checkBalance() + "\n");
                } catch (NotValidatePinException e) {
                    System.out.println(e.getMessage());
                    validate(scanner, terminal);
                    executeCommand(command, terminal, scanner, NO_CACHED_SUM);
                } catch (FailedConnectionException e) {
                    System.out.println(e.getMessage() + "\n");
                }
                break;
            case "3":
                if (sum == NO_CACHED_SUM) {
                    System.out.println("Enter sum:");
                    sum = scanner.nextInt();
                }

                try {
                    terminal.setMoney(sum);
                    System.out.println("Success!\n");
                } catch (NotValidatePinException e) {
                    System.out.println(e.getMessage());
                    validate(scanner, terminal);
                    executeCommand(command, terminal, scanner, sum);
                } catch (InvalidSumException | FailedConnectionException e) {
                    System.out.println(e.getMessage() + "\n");
                }
                break;
            case "4":
                if (sum == NO_CACHED_SUM) {
                    System.out.println("Enter sum:");
                    sum = scanner.nextInt();
                }

                try {
                    terminal.getMoney(sum);
                    System.out.println("Success!\n");
                } catch (NotValidatePinException e) {
                    System.out.println(e.getMessage());
                    validate(scanner, terminal);
                    executeCommand(command, terminal, scanner, sum);
                } catch (InvalidSumException | FailedConnectionException | NotEnoughMoneyException e) {
                    System.out.println(e.getMessage() + "\n");
                }
                break;
            default:
                System.out.println("Unknown command.\n");
        }
    }

    private static void validate(Scanner scanner, Terminal terminal) {
        while (!terminal.isPinValidated()) {
            System.out.println("Please enter your PIN code:");
            try {
                terminal.validatePin(scanner.next());
                System.out.println("Success!\n");
            } catch (InvalidPinException e) {
                System.out.println(e.getMessage() + e.getRemainingAttempts() + "\n");
            } catch (AccountIsLockedException e) {
                System.out.println(e.getMessage() + " " + e.getRemainingSeconds() + "\n");
                break;
            }
        }
    }
}
