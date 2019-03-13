package com.sbt.lesson5;

import com.sbt.lesson5.classes.PinValidatorImpl;
import com.sbt.lesson5.classes.TerminalImpl;
import com.sbt.lesson5.classes.TerminalServerImpl;
import com.sbt.lesson5.exeptionClasses.*;
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
                    "1 - to display balance\n" +
                    "2 - to set money\n" +
                    "3 - to get money\n" +
                    "4 - to exit");

            String command = "";
            command = scanner.next();
            if (command.equals("4")) {
                return;
            }
            executeCommand(command, terminal, scanner, NO_CACHED_SUM);
        }
    }

    private static void executeCommand(String command, Terminal terminal, Scanner scanner, int prevSum) {
        int sum = prevSum;
        switch (command) {
            case "1":
                try {
                    System.out.println("Balance - " + terminal.checkBalance() + "\n");
                } catch (NotValidatePinException e) {
                    validate(scanner, terminal);
                    executeCommand(command, terminal, scanner, NO_CACHED_SUM);
                } catch (FailedConnectionException e) {
                    System.out.println("Error: Connection is lost, try later.\n");
                }
                break;
            case "2":
                if (sum == NO_CACHED_SUM) {
                    System.out.println("Enter sum:");
                    sum = scanner.nextInt();
                }

                try {
                    terminal.setMoney(sum);
                    System.out.println("Success!\n");
                } catch (NotValidatePinException e) {
                    validate(scanner, terminal);
                    executeCommand(command, terminal, scanner, sum);
                } catch (InvalidSumException e) {
                    System.out.println("Error: Expected sum, which is multiple to 100 and is more than 0.\n");
                } catch (FailedConnectionException e) {
                    System.out.println("Error: Connection is lost, try later.\n");
                }
                break;
            case "3":
                if (sum == NO_CACHED_SUM) {
                    System.out.println("Enter sum:");
                    sum = scanner.nextInt();
                }

                try {
                    terminal.getMoney(sum);
                    System.out.println("Success!\n");
                } catch (NotValidatePinException e) {
                    validate(scanner, terminal);
                    executeCommand(command, terminal, scanner, sum);
                } catch (InvalidSumException e) {
                    System.out.println("Error: Expected sum, which is multiple to 100 and is more than 0.\n");
                } catch (NotEnoughMoneyException e) {
                    System.out.println("Error: You have not enough money.\n");
                } catch (FailedConnectionException e) {
                    System.out.println("Error: Connection is lost, try later.\n");
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
            } catch (InvalidPinException e) {
                System.out.println("Error: Invalid PIN code. Remaining attempts: " + e.getRemainingAttempts() + "\n");
            } catch (AccountIsLockedException e) {
                System.out.println("Error: Your card is locked for " + e.getRemainingSeconds() + " seconds.\n");
            }
        }
    }
}
