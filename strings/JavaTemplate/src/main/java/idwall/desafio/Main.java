package idwall.desafio;

import idwall.desafio.string.IdwallFormatter;
import idwall.desafio.utils.Idwall;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class Main {

    //private static final String DEFAULT_INPUT_TEXT = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" + "\n" + "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
    //private static final Integer DEFAULT_LIMIT = 40;
    //private static final Boolean DEFAULT_JUSTIFY = false;

    public static void main(String[] args) throws IOException {

        Integer limit = 0;
        Boolean justify = false;

        Idwall idwall = new Idwall();
        idwall.banner();
        IdwallFormatter idwallFormatter = new IdwallFormatter();
        Scanner sc = new Scanner(System.in);


        System.out.println("----------------  Console IdWall o que deseja fazer?  ----------------");
        System.out.println("1 - Formatar texto");
        System.out.println("2 - Buscar Lista Reddit ");

        Integer opcaoInicial = sc.nextInt();
        while (!opcaoInicial.equals(3))

        switch (opcaoInicial) {
            case 1:
                System.out.println("Informe o texto que deseja formatar: \n*Caso deseje pular uma linha incluir no texto a tag \\n");
                String text = sc.next();

                System.out.println("Qual o limite de maximo de caracter deseja por linha");
                String limite = sc.next();

                System.out.println("Deseja Justificar seu texto?\n 1-SIM \n 2-NÃO");

                justify = sc.nextInt() == 1 ? Boolean.TRUE : Boolean.FALSE;

                String formatado = idwallFormatter.format(text, justify, limit);

                System.out.println(formatado);

                break;
            case 2:
                text = args[0];
                limit = Integer.parseInt(args[1]);
                break;

        }

   /*     // Print input data
        System.out.println("Inputs: ");
        System.out.println("Text: " + text);
        System.out.println("Limit: " + limit);
        System.out.println("Should justify: " + justify);
        System.out.println("=========================");
*/

        // Print output text
      /*  System.out.println("Output: ");
        System.out.println(outputText);*/
    }
}
