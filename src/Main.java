import javax.swing.plaf.ActionMapUIResource;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int vidaJ = 3;
        int vidaE = 3;
        boolean acierto = false;


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Introduce cuantas filas y columnas tiene el campo de batalla");
        System.out.println("\n filas : ");
        Scanner entrada = new Scanner(System.in);
        int filas = entrada.nextInt();
        System.out.println(" columans : ");
        int columnas = entrada.nextInt();
        System.out.println(" cuantos enemigos hay ? :");
        int enemigos = entrada.nextInt();

        String[][] campo = new String[filas][columnas];
        Random rand = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                campo[i][j] = ".";
            }
        }
        campo[rand.nextInt(0, filas)][rand.nextInt(0, columnas)] = "J";
        for (int i = 0; i<enemigos;i++){
            campo[rand.nextInt(0, filas)][rand.nextInt(0, columnas)] = "E";
        }

    //muestra mapa y vidas y lo que puedes hacer
        Funciones.actualizacion(vidaJ, vidaE, campo, filas, columnas);
        do {
            boolean semueve= false;
            //disparar o moverse
            int opcion = Funciones.menushort();




            switch (opcion){
                //movimiento jugador y enemigo
                case 1 :
                    char movimiento = Funciones.pedirmovimiento();
                    semueve = Funciones.movimientojugador(movimiento, campo, filas, columnas, semueve);
                    if (semueve){
                        campo = Funciones.movimientoenemigo(campo,filas,columnas);
                        Funciones.actualizacion(vidaJ, vidaE, campo, filas, columnas);

                    } else {
                        Funciones.showmap(campo,filas,columnas);
                    }

                    break;
                case 2 :
                    //disparo y movimiento enemigo
                    System.out.print("\n En que direccion quieres disparar? (wasd):");

                    char direcdisparo = Funciones.pedirdisparo();
                    campo = Funciones.movimientoenemigo(campo,filas,columnas);
                    acierto = Funciones.hacerdisparo(campo, filas , columnas ,direcdisparo);
                    if (acierto){

                        int prob = 0;
                        prob =rand.nextInt(0,100)+1;
                        if (prob<80){
                            vidaE --;
                            System.out.print("ACERTASTE le queda una vida menos a tu enemigo\n");
                            System.out.print("\n ======================\n");

                            Funciones.actualizacion(vidaJ, vidaE, campo, filas, columnas);
                        }else {
                            System.out.print("TIENES UNA PUNTERIA NEFASTA Y FALLAS...\n");
                            System.out.print("\n ======================\n");

                            Funciones.actualizacion(vidaJ, vidaE, campo, filas, columnas);

                        }
                    }else {

                        Funciones.actualizacion(vidaJ, vidaE, campo, filas, columnas);
                    }


                    break;
            }




        }while (vidaE >0 && vidaJ >0);
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