package simuladores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import estructuras.ArregloUsuario;
import estructuras.Usuario;

public class SimArr500k {

	public static ArregloUsuario reader (){
		ArregloUsuario usuarios = new ArregloUsuario();
		String csvFile = "dataset_500000.csv";
		String line = "";
		String cvsSplitBy = ";";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				Usuario usuario = new Usuario(items);
				usuarios.agregar(usuario);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public static void writterAlta(ArregloUsuario us){

		String csvFile = "dataset_insert_10000.csv";
		String line = "";
		String cvsSplitBy = ";";
		BufferedWriter bw = null;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			File file = new File("salidaAltaAr500000.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			long time_start, time_end;

			String primeraLinea = "Usuario;Tiempo";
			bw.write(primeraLinea);
			bw.newLine();

			while ((line = br.readLine()) != null) {
				time_start = System.nanoTime();
				String[] items = line.split(cvsSplitBy);
				Usuario usuario = new Usuario(items);
				us.agregar(usuario);

				time_end = System.nanoTime();

				String contenidoLinea1 = items[0]+";"+(( time_end - time_start ));
				bw.write(contenidoLinea1);
				bw.newLine();
			}


		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	}

	public static void writterBusqueda(ArregloUsuario us){

		String csvFile = "dataset_busqueda_10000.csv";
		String line = "";
		String cvsSplitBy = ";";
		BufferedWriter bw = null;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			File file = new File("salidaBusquedaAr500000.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			long time_start, time_end;

			String primeraLinea = "Usuario;Tiempo;Encontrado?";
			bw.write(primeraLinea);
			bw.newLine();

			while ((line = br.readLine()) != null) {
				time_start = System.nanoTime();
				String[] items = line.split(cvsSplitBy);
				boolean existe = us.existe(items[0]);
				time_end = System.nanoTime();



				String contenidoLinea="";
				if(existe){
					contenidoLinea = items[0]+";"+(( time_end - time_start ))+";Encontrado";
				}else{
					contenidoLinea = items[0]+";"+(( time_end - time_start ))+";NoEncontrado";
				}

				bw.write(contenidoLinea);
				bw.newLine();
			}
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	}

	public static void main(String[] args) {

		ArregloUsuario us = new ArregloUsuario();
		us = reader();
		writterAlta(us);
		writterBusqueda(us);
	}

}
