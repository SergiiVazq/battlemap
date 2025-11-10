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
        System.out.printf("Introduce cuantas filas y columnas tiene el campo de batalla");
        System.out.println("\n filas : ");
        Scanner entrada = new Scanner(System.in);
        int filas = entrada.nextInt();
        System.out.println(" columans : ");
        int columnas = entrada.nextInt();

        String [][] campo = new String[filas][columnas];
        Random rand = new Random();
        for (int i = 0 ;i<filas;i++){
            for (int j=0;j<columnas;j++){
                campo[i][j] = "." ;
            }
        }
        campo[rand.nextInt(0,filas)][rand.nextInt(0,columnas)] = "j";
        campo[rand.nextInt(0,filas)][rand.nextInt(0,columnas)] = "E";

        actualizacion(vidaJ,vidaE,campo,filas,columnas);
        String mientrada = entrada.next();

        char movimiento = mientrada.charAt(0);
        while (movimiento!='w' && movimiento!='W' && movimiento!='S' && movimiento!='s' && movimiento!='E' && movimiento!='e' && movimiento!='o' && movimiento!='O'){
            System.out.print("Error introduce un Valor valido de direccion: ");
            mientrada = entrada.next();
            movimiento = mientrada.charAt(0);
        }
        /*switch (movimiento){
            case
        }*/






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

}
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