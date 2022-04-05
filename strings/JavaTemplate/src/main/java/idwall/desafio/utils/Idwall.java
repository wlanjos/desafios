package idwall.desafio.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Idwall {


    public void banner() throws IOException {

        FileInputStream stream = new FileInputStream("strings/JavaTemplate/src/main/java/banner.txt");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        while (linha != null) {
            System.out.println(linha);
            linha = br.readLine();
        }
        br.close();
        reader.close();
        stream.close();
    }
}
