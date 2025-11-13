import java.util.Scanner;

public class Funciones {
    public static void showmap(String[][]map, int filasmap , int columnasmap){
        for (int i = 0 ;i<filasmap;i++){
            System.out.print("\n|");
            for (int j=0;j<columnasmap;j++){
                System.out.print(map[i][j] + " ");
                if((j+1)==columnasmap){
                    System.out.print("|");
                }
            }
        }

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
    public static boolean hacerdisparo(String[][]campodebatalla, int filasmp , int columnasmp ,char direccion){
        boolean acierto = false;
        if (direccion=='w' || direccion=='W'){
            for(int i = 0; i<filasmp;i++){
                for(int j=0;j<columnasmp;j++) {
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
            for (int i = 0; i<filasmp;i++){
                for(int j=0;j<columnasmp;j++) {
                    if (campodebatalla[i][j].equals("J")) {
                        if (i == filasmp-1 ) {
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
            for (int i = 0; i<filasmp;i++){
                for(int j=0;j<columnasmp;j++){
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
            for (int i = 0; i<filasmp;i++){
                for(int j=0;j<columnasmp;j++) {
                    if (campodebatalla[i][j].equals("J")) {
                        if (j == columnasmp - 1) {
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


}
