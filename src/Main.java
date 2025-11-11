import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int vidaJ = 3;
        int vidaE = 3;
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Introduce cuantas filas y columnas tiene el campo de batalla");
        System.out.println("\n filas : ");
        Scanner entrada = new Scanner(System.in);
        int filas = entrada.nextInt();
        System.out.println(" columans : ");
        int columnas = entrada.nextInt();

        String[][] campo = new String[filas][columnas];
        Random rand = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                campo[i][j] = ".";
            }
        }
        campo[rand.nextInt(0, filas)][rand.nextInt(0, columnas)] = "J";
        campo[rand.nextInt(0, filas)][rand.nextInt(0, columnas)] = "E";

        actualizacion(vidaJ, vidaE, campo, filas, columnas);
        do {
            boolean semueve= false;

            char movimiento = pedirmovimiento();

            if (movimiento == 'w' || movimiento == 'W') {
                semueve = movimientojugador(movimiento, campo, filas, columnas, semueve);
                if (semueve){
                    actualizacion(vidaJ, vidaE, campo, filas, columnas);
                }

            } else if (movimiento == 'a' || movimiento == 'A') {
                semueve = movimientojugador(movimiento, campo, filas, columnas, semueve);
                if (semueve){
                    actualizacion(vidaJ, vidaE, campo, filas, columnas);
                }

            } else if (movimiento == 's' || movimiento == 'S') {
                semueve = movimientojugador(movimiento, campo, filas, columnas, semueve);
                if (semueve){
                    actualizacion(vidaJ, vidaE, campo, filas, columnas);;
                }

            } else {
                semueve = movimientojugador(movimiento, campo, filas, columnas, semueve);
                if (semueve){
                    actualizacion(vidaJ, vidaE, campo, filas, columnas);;
                }

            }


        }while (vidaE >0 || vidaJ >0);
    }

    public static void actualizacion(int x, int y, String [][] b,int filasmap, int columnasmap){
        // muestra el mapa actual
        for (int i = 0 ;i<filasmap;i++){
            System.out.print("\n|");
            for (int j=0;j<columnasmap;j++){
                System.out.print(b[i][j] + " ");
                if((j+1)==columnasmap){
                    System.out.print("|");
                }
            }
        }
        System.out.print( "\nVIDA DE J ==> " + x);
        System.out.print("\nVIDA DE ENEMIGO ==> "+y);
        System.out.print("\n J es tu posicion y E es el enemigo teclea W(NORTE), S(SUR), A(OESTE) o D(ESTE) para intentar atraparlo");

    }
    public static char pedirmovimiento (){
        Scanner mov = new Scanner(System.in);
        System.out.print("\n MOVIMIENTO WASD : ");
        String movimientomap = mov.nextLine();
        char movmap = movimientomap.charAt(0);
        while (movmap != 'w' && movmap != 'W' && movmap != 'S' && movmap != 's' && movmap != 'A' && movmap != 'a' && movmap != 'D' && movmap != 'd'){
            System.out.print("Dato incorrecto introduce bien la direccion en la que quieres ir: ");
            movimientomap = mov.nextLine();
            movmap = movimientomap.charAt(0);
        }
        return movmap;
    }
    public static boolean movimientojugador(char direccion, String [][] campodebatalla, int filasmp, int columnasmp,boolean movimiento){
        if (direccion=='w' || direccion=='W'){
            for(int i = 0; i<filasmp;i++){
                for(int j=0;j<columnasmp;j++) {
                    if (campodebatalla[i][j].equals("J")) {
                        if (i == 0) {
                            System.out.print("El jugador no puede avanzar a esa posicion por que sandria fuera del mapa elije otra opcion");
                            movimiento = false;
                            break;

                        } else if (campodebatalla[i-1][j].equals("E")) {
                            System.out.print("El jugador no puede avanzar a esa posicion por que se encuentra el enemigo en ella");
                            break;

                        }
                        campodebatalla[i - 1][j] = "J";
                        campodebatalla[i][j] = ".";
                        movimiento = true;
                        break;
                    }
                }
            }
        } else if (direccion=='s'|| direccion=='S') {
            boolean cambio = false;
            for (int i = 0; i<filasmp;i++){
                for(int j=0;j<columnasmp;j++) {

                    if(cambio){
                        break;
                    }
                    if (campodebatalla[i][j].equals("J")) {
                        if (i == filasmp-1 ) {
                            System.out.print("El jugador no puede avanzar a esa posicion por que sandria fuera del mapa elije otra opcion");
                            movimiento = false;
                            break;

                        }else if (campodebatalla[i+1][j].equals("E")){
                            System.out.print("El jugador no puede avanzar a esa posicion por que se encuentra el enemigo en ella");
                            break;
                        } else {
                            campodebatalla[i+1][j] = "J";
                            campodebatalla[i][j] = ".";
                            movimiento = true;
                            cambio = true ;
                            break;
                        }


                    }

                }
            }

        } else if (direccion == 'a' || direccion  == 'A') {
            for (int i = 0; i<filasmp;i++){
                for(int j=0;j<columnasmp;j++){
                    if (campodebatalla[i][j].equals("J")){
                        if (j==0){
                            System.out.print("El jugador no puede avanzar a esa posicion por que sandria fuera del mapa elije otra opcion");
                            movimiento = false;
                            break;

                        } else if (campodebatalla[i][j-1].equals("E")){
                            System.out.print("El jugador no puede avanzar a esa posicion por que se encuentra el enemigo en ella");
                            break;
                        }
                        campodebatalla[i][j-1] = "J";
                        campodebatalla[i][j] = ".";
                        movimiento = true;
                        break;
                    }
                }
            }


        } else if (direccion == 'd' || direccion== 'D') {
            for (int i = 0; i<filasmp;i++){
                for(int j=0;j<columnasmp;j++) {
                    if (campodebatalla[i][j].equals("J")) {
                        if (j == columnasmp - 1) {
                            System.out.print("El jugador no puede avanzar a esa posicion por que sandria fuera del mapa elije otra opcion");
                            movimiento = false;
                            break;

                        } else if (campodebatalla[i][j+1].equals("E")) {
                            System.out.print("El jugador no puede avanzar a esa posicion por que se encuentra el enemigo en ella");
                            break;

                        }
                        campodebatalla[i][j + 1] = "J";
                        campodebatalla[i][j] = ".";
                        movimiento = true;
                        break;
                    }
                }
            }


        }
        return movimiento;

    }

}
//








/*// muestra el mapa actual
        for (int i = 0 ;i<filas;i++){
            System.out.print("\n|");
            for (int j=0;j<columnas;j++){
                System.out.print(campo[i][j] + " ");
                if((j+1)==columnas){
                    System.out.print("|");
                }
            }
        }
        System.out.print( "\nVIDA DE J ==> " + vidaJ);
        System.out.print("\nVIDA DE ENEMIGO ==> "+vidaE);*/