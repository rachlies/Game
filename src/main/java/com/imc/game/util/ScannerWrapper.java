package com.imc.game.util;


import java.util.Scanner;

public class ScannerWrapper {
    private final Scanner scanner;

    public ScannerWrapper(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public int nextInt() {
        return scanner.nextInt();
    }

    // Add other necessary methods from Scanner
}
