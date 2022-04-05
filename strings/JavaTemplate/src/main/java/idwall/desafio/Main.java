package idwall.desafio;

import idwall.desafio.crawlers.Crawales;
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
    private static Boolean justify;
    private static Integer limit;
    private static String text;

    public static void main(String[] args) throws IOException {
        Idwall idwall = new Idwall();
        idwall.banner();
        IdwallFormatter idwallFormatter = new IdwallFormatter();


        Scanner sc = new Scanner(System.in);

        Boolean continuar = Boolean.TRUE;
        while (continuar) {

            System.out.println("----------------  Console IdWall o que deseja fazer?  ----------------");
            System.out.println("1 - Formatar texto");
            System.out.println("2 - Buscar Lista Reddit ");
            System.out.println("3 - Sair ");

            Integer opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    processarTexto();
                    String formatado = idwallFormatter.format(text, justify, limit);

                    System.out.println(formatado);
                    break;
                case 2:
                    System.out.println("Informe a lista que deseja pesquisar\nCaso deseje buscar mais de uma lista utilize o separador ; ");
                    String subreddit = sc.next();
                    Crawales crawales = new Crawales();
                    crawales.processarSubreddits(subreddit);
                    crawales.exibirCaptura();

                    break;

                case 3:
                    continuar = Boolean.FALSE;
                    break;

                default:
                    System.out.println("Opção invalida Tente novamente");

            }

        }
    }

    private static void processarTexto() {
        try {
            Scanner opçaoTexto = new Scanner(System.in);

            System.out.println("Informe o texto que deseja formatar: \n*Caso deseje pular uma linha incluir no texto a tag \\n");
            text = opçaoTexto.nextLine();

            System.out.println("Qual o limite de maximo de caracter deseja por linha");
            String next = opçaoTexto.next();
            limit = Integer.valueOf(next);

            System.out.println("Deseja Justificar seu texto?\n 1-SIM \n 2-NÃO");

            justify = opçaoTexto.nextInt() == 1 ? Boolean.TRUE : Boolean.FALSE;


        } catch (Exception e) {
            System.out.println("Ocorreu um erro, por favor tente novamente.");
        }
    }
}
