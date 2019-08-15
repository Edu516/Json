package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ArrayJson {

    public static void main(String[] args) throws IOException {
       
        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe a quantidade de valores: ");
        int t = entrada.nextInt();

        int[] vetor = new int[t];

        for (int i = 0; i < t; i++) {
            System.out.print("Valor -> ");
            vetor[i] = entrada.nextInt();
        }

        System.out.println("Carregar Json?1)sim 2)não");
        int escolha = entrada.nextInt();
        if (escolha ==1){
            
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("array.json");
        writer.write(gson.toJson(vetor));
        writer.close();

        FileReader fr = new FileReader("array.json");
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {

            sb = sb.append(line);
            System.out.println(sb);
        }

        br.close();
        fr.close();
        
        }
        

    }
}
