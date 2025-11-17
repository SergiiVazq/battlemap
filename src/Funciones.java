import java.util.Random;
import java.util.Scanner;

public class Funciones {
    public static void showmap(String[][]map){
        for (int i = 0 ;i<map.length;i++){
            System.out.print("\n|");
            for (int j=0;j<map[0].length;j++){
                System.out.print(map[i][j] + " ");
                if((j+1)==map[0].length){
                    System.out.print("|");
                }
            }
        }

    }
    public static void actualizacion(int x, int y, String [][] b){
        // muestra el mapa actual + vida
        showmap(b);
        System.out.print("\n ======================\n");
        System.out.print( "\nVIDA DE J ==> " + x);
        System.out.print("\nVIDA DE ENEMIGO ==> "+y);



    }
    public static char pedirdisparo (){
        Scanner mov = new Scanner(System.in);
        System.out.print("\n DISPARO WASD : ");
        String movimientomap = mov.nextLine();
        char disparo = movimientomap.charAt(0);
        while (disparo != 'w' && disparo != 'W' && disparo != 'S' && disparo != 's' && disparo != 'A' && disparo != 'a' && disparo != 'D' && disparo != 'd'){
            System.out.print("Dato incorrecto introduce bien la direccion del disparo: ");
            movimientomap = mov.nextLine();
            disparo = movimientomap.charAt(0);
        }
        return disparo;
    }
    public static boolean movimientojugador(char direccion, String [][] campodebatalla,boolean movimiento){
        if (direccion=='w' || direccion=='W'){
            for(int i = 0; i<campodebatalla.length;i++){
                for(int j=0;j<campodebatalla[0].length;j++) {
                    if (campodebatalla[i][j].equals("J")) {
                        if (i == 0) {
                            System.out.print("El jugador no puede avanzar a esa posicion por que sandria fuera del mapa elije otra opcion");
                            System.out.print("\n ======================\n");
                            movimiento = false;
                            break;

                        } else if (campodebatalla[i-1][j].equals("E")) {
                            System.out.print("El jugador no puede avanzar a esa posicion por que se encuentra el enemigo en ella");
                            System.out.print("\n ======================\n");
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
            for (int i = 0; i< campodebatalla.length;i++){
                for(int j=0;j< campodebatalla[0].length;j++) {

                    if(cambio){
                        break;
                    }
                    if (campodebatalla[i][j].equals("J")) {
                        if (i == campodebatalla.length-1 ) {
                            System.out.print("El jugador no puede avanzar a esa posicion por que sandria fuera del mapa elije otra opcion");
                            System.out.print("\n ======================\n");
                            movimiento = false;

                            break;

                        }else if (campodebatalla[i+1][j].equals("E")){
                            System.out.print("El jugador no puede avanzar a esa posicion por que se encuentra el enemigo en ella");
                            System.out.print("\n ======================\n");
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
            for (int i = 0; i<campodebatalla.length;i++){
                for(int j=0;j<campodebatalla[0].length;j++){
                    if (campodebatalla[i][j].equals("J")){
                        if (j==0){
                            System.out.print("El jugador no puede avanzar a esa posicion por que sandria fuera del mapa elije otra opcion");
                            System.out.print("\n ======================\n");
                            movimiento = false;
                            break;

                        } else if (campodebatalla[i][j-1].equals("E")){
                            System.out.print("El jugador no puede avanzar a esa posicion por que se encuentra el enemigo en ella");
                            System.out.print("\n ======================\n");
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
            for (int i = 0; i<campodebatalla.length;i++){
                for(int j=0;j<campodebatalla[0].length;j++) {
                    if (campodebatalla[i][j].equals("J")) {
                        if (j == campodebatalla[0].length - 1) {
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
    public static boolean hacerdisparo(String[][]campodebatalla,char direccion){
        boolean acierto = false;
        if (direccion=='w' || direccion=='W'){
            for(int i = 0; i< campodebatalla.length;i++){
                for(int j=0;j<campodebatalla[0].length;j++) {
                    if (campodebatalla[i][j].equals("J")) {
                        if (i == 0) {
                            System.out.print("DISPARASTE A LA NADA PIERDES TURNO");
                            acierto = false;
                            break;

                        } else if (campodebatalla[i-1][j].equals("E")) {
                            System.out.print("Disparas al jugador y ...");
                            acierto = true;
                            break;

                        }else {
                            System.out.print("Disparaste a una posicion donde no se encontraba el enemigo \n");
                            acierto= false;
                        }
                    }
                }
            }
        }else if (direccion=='s'|| direccion=='S') {

            for (int i = 0; i< campodebatalla.length;i++){
                for(int j=0;j<campodebatalla[0].length;j++) {
                    if (campodebatalla[i][j].equals("J")) {
                        if (i == campodebatalla.length-1 ) {
                            System.out.print("DISPARASTE A LA NADA PIERDES TURNO");
                            acierto = false;
                            break;

                        }else if (campodebatalla[i+1][j].equals("E")){
                            System.out.print("Disparas al jugador y ...");
                            acierto = true;
                            break;

                        } else {
                            System.out.print("Disparaste a una posicion donde no se encontraba el enemigo \n");
                            acierto= false;
                        }


                    }

                }
            }

        } else if (direccion == 'a' || direccion  == 'A') {
            for (int i = 0; i< campodebatalla.length;i++){
                for(int j=0;j< campodebatalla[0].length;j++){
                    if (campodebatalla[i][j].equals("J")){
                        if (j==0){
                            System.out.print("DISPARASTE A LA NADA PIERDES TURNO");
                            acierto = false;
                            break;

                        } else if (campodebatalla[i][j-1].equals("E")){
                            System.out.print("Disparas al jugador y ...");
                            acierto = true;
                            break;
                        }
                        System.out.print("Disparaste a una posicion donde no se encontraba el enemigo \n");
                        acierto= false;
                    }
                }
            }


        } else if (direccion == 'd' || direccion== 'D') {
            for (int i = 0; i<campodebatalla.length;i++){
                for(int j=0;j< campodebatalla[0].length;j++) {
                    if (campodebatalla[i][j].equals("J")) {
                        if (j == campodebatalla[0].length - 1) {
                            System.out.print("DISPARASTE A LA NADA PIERDES TURNO");
                            acierto = false;
                            break;
                        } else if (campodebatalla[i][j+1].equals("E")) {
                            System.out.print("Disparas al jugador y ...");
                            acierto = true;
                            break;

                        }
                        System.out.print("Disparaste a una posicion donde no se encontraba el enemigo \n");
                        acierto= false;
                    }
                }
            }


        }


        return acierto;
    }
    public static int menushort(){
        Scanner menu = new Scanner(System.in);
        System.out.print("\n ======================\n");
        System.out.print("\nPULSA 1 PARA MOVERTE");
        System.out.print("\nPULSA 2 PARA DISPARAR");

        int opcion = menu.nextInt();
        while (opcion!=1 && opcion!=2){
            System.out.print("\nError introduce un numero valido");
            opcion = menu.nextInt();

        }
        return opcion;
    }
    public static String [][] movimientoenemigo(String[][]map){
        Random  mov = new Random();
        int movimientoE = mov.nextInt(0,4);
        if (movimientoE==1){
            for(int i = 0; i< map.length;i++){
                for(int j=0;j< map[0].length;j++) {
                    if (map[i][j].equals("E")) {
                        if (i == 0) {


                            break;

                        } else if (map[i-1][j].equals("J")) {

                            break;

                        }
                        map[i - 1][j] = "E";
                        map[i][j] = ".";


                        break;
                    }
                }
            }
        } else if (movimientoE==2) {

            boolean cambio = false;
            for (int i = 0; i< map.length;i++){
                for(int j=0;j< map[0].length;j++) {

                    if(cambio){
                        break;
                    }
                    if (map[i][j].equals("E")) {
                        if (i == map.length-1 ) {


                            break;

                        }else if (map[i+1][j].equals("J")){

                            break;
                        } else {
                            map[i+1][j] = "E";
                            map[i][j] = ".";
                            cambio=true;

                            break;
                        }


                    }

                }
            }

        } else if (movimientoE==3) {
            for (int i = 0; i< map.length;i++){
                for(int j=0;j< map[0].length;j++){
                    if (map[i][j].equals("E")){
                        if (j==0){

                            break;

                        } else if (map[i][j-1].equals("J")){
                            break;
                        }
                        map[i][j-1] = "E";
                        map[i][j] = ".";

                        break;
                    }
                }
            }


        } else if (movimientoE==4) {
            for (int i = 0; i< map.length;i++){
                for(int j=0;j< map[0].length;j++) {
                    if (map[i][j].equals("E")) {
                        if (j == map[0].length - 1) {

                            break;

                        } else if (map[i][j+1].equals("J")) {
                            break;

                        }
                        map[i][j + 1] = "E";
                        map[i][j] = ".";
                        break;
                    }
                }
            }


        }
        return map;
    }


}
