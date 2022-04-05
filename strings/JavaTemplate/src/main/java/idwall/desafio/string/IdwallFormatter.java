package idwall.desafio.string;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class IdwallFormatter extends StringFormatter {

    private int limite;

    /**
     * Should format as described in the challenge
     *
     * @param text
     * @return
     */

    @Override
    public String format(String text, boolean justificar, int limite) {


        this.limite = limite;
        StringBuilder formatada = new StringBuilder();
        String[] palavras = text.split(" ");
        int contador = 0;


        for (String palavra : palavras) {

            if (palavra.contains("\n")) {
                String removerQuebraLinha = palavra.replaceAll("\n", " ");
                char[] lastChar = removerQuebraLinha.toCharArray();
                for (char i : lastChar) {
                    if (' ' == i) {
                        formatada.append("\n");
                        contador = 0;
                    } else {
                        formatada.append(i);
                        contador += 1;
                    }
                }
                formatada.append(" ");
                contador += 1;
                continue;

            }

            if ((contador + palavra.length()) <= limite) {
                formatada.append(palavra).append(" ");

                contador += palavra.concat(" ").length();

            } else {
                contador = 0;

                formatada.deleteCharAt(formatada.length() - 1);


                formatada.append("\n").append(palavra).append(" ");
                contador += palavra.concat(" ").length();


            }

        }
        String textoFinal = formatada.toString().trim();

        /*     StringBuilder textoFinal = formatada.deleteCharAt(formatada.length() - 1);*/

        if (justificar) {
            return String.valueOf(justificarLinha(textoFinal));
        } else {
            return textoFinal;
        }

    }



    public StringBuilder justificarLinha(String textoFinal) {

        String[] linhas = textoFinal.split("\n");
        StringBuilder linhaTratada = new StringBuilder();
        StringBuilder linhajustificada = new StringBuilder();


        for (String linha : linhas) {

            if (linha.equals("")) {
                linhaTratada.append("\n");
                continue;
            }

            int totalfaltanteChar = limite - linha.length();

            boolean justifcar = Boolean.TRUE;
            if (totalfaltanteChar > 0) {
                while (justifcar) {


                    for (int i = 0; i < linha.length(); i++) {
                        char caracterLinha = linha.charAt(i);

                        if (caracterLinha == ' ' && totalfaltanteChar > 0) {

                            linhaTratada.append("  ");
                            totalfaltanteChar--;
                        } else {
                            linhaTratada.append(caracterLinha);
                        }
                    }

                    if (totalfaltanteChar == 0) {
                        justifcar = Boolean.FALSE;
                        linhaTratada.append("\n");
                    } else {
                        linha = linhaTratada.toString();
                        linhaTratada = new StringBuilder();
                    }

                }
            } else {
                linhajustificada.append(linhaTratada.append(linha).append("\n"));
                linhaTratada = new StringBuilder();
            }

            linhajustificada.append(linhaTratada);
            linhaTratada = new StringBuilder();
        }
        return linhajustificada;
    }
}

