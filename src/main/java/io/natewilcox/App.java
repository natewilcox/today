package io.natewilcox;

import java.io.IOException;

public class App {
    public static void main(String[] args) {

        Command cmd = new Command(args);

        try {
            cmd.execute();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
