package org.example.hw;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        HttpStatusImageDownloader hsid = new HttpStatusImageDownloader();
        while (true) {
            System.out.println("Enter status cod...");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }
            int status = 0;
            try {
                status = Integer.parseInt(input);

            } catch (NumberFormatException e) {
                System.out.println("Print valid number");
            }

            try {
                hsid.downloadStatusImage(status);
            } catch (Exception e) {
                System.out.println("there  is no image");
            }
        }
    }
}
