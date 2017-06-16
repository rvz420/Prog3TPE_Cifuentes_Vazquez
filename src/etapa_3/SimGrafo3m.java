package etapa_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimGrafo3m {

	public static Grafo reader (){
		Grafo grafo = new Grafo();
		String csvFile = "dataset_3000000.csv";
		String line = "";
		String cvsSplitBy = ";";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				grafo.agregarUsuario(items[0]);
				for (int i = 1; i < items.length; i++) {
					grafo.agregarGusto(items[i]);
				}
				for (int i = 1; i < items.length; i++) {
					grafo.addGustoUser(items[i], items[0]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return grafo;
	}

	public static void main(String[] args) {

		Grafo grafo = new Grafo();
		grafo = reader();
		
		System.out.println("Gustos similares");
		System.out.println(grafo.gustosSimilares("71095014"));
		
		System.out.println("Gusto mas gustado");
		System.out.println(grafo.masGustado());
	}

}
