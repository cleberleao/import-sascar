package br.com.chart.rodovia.infra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ImportSascar {
	public static void main(String[] args) throws IOException {

		File arquivoCSV = new File("macros.csv");

		ArrayList<String> vet = new ArrayList<>();
		BufferedReader lerArq = new BufferedReader(new FileReader(arquivoCSV));

		FileWriter writer = new FileWriter("teste.csv");
		lerArq.readLine();
		String line = lerArq.readLine();

		try {

			while (line != null) {
				vet.add(line);
				line = lerArq.readLine();

			}

		} catch (FileNotFoundException e) {

		}

		Collections.reverse(vet);
		System.out.println("Qtde linhas: " + vet.size());
		String[] valoresEntreVirgulas;
		String vv2;
		String vv3;
		Integer evento = 0;
		for (int i = 0; i < vet.size(); i++) {
			// System.out.println(" " + vet.get(i));

			valoresEntreVirgulas = vet.get(i).split(";");
			vv2 = valoresEntreVirgulas[3].replace("�", "");
			vv3 = vv2.replace("/", "");

			if (valoresEntreVirgulas[7].contains("INICIO DE JORNADA")) {
				evento = 1;
			} else if (valoresEntreVirgulas[7].contains("FIM DE JORNADA")) {
				evento = 0;
			} else if (valoresEntreVirgulas[7].contains("INICIO DE DIRECAO")) {
				evento = 8;
			} else if (valoresEntreVirgulas[7].contains("FIM DE DIRECAO")) {
				evento = -8;
			} else if (valoresEntreVirgulas[7].contains("INICIO DE REFEICAO")) {
				evento = 14;
			} else if (valoresEntreVirgulas[7].contains("FIM DE REFEICAO")) {
				evento = -14;
			} else if (valoresEntreVirgulas[7].contains("CARGA/DESCARGA") && valoresEntreVirgulas[7].contains("(X)AGUARDANDO CARGA")) {
				evento = 9;
			} else if (valoresEntreVirgulas[7].contains("CARGA/DESCARGA") && valoresEntreVirgulas[7].contains("(X)AGUARDANDO DESCARGA")) {
				evento = 11;
			} else if (valoresEntreVirgulas[7].contains("CARGA/DESCARGA") && valoresEntreVirgulas[7].contains("(X)CARGA")) {
				evento = 10;
			} else if (valoresEntreVirgulas[7].contains("CARGA/DESCARGA") && valoresEntreVirgulas[7].contains("(X)DESCARGA")) {
				evento = 12;
			} else if (valoresEntreVirgulas[7].contains("CARGA/DESCARGA") && valoresEntreVirgulas[7].contains("(X)MANIFESTO")) {
				evento = 2;
			} else if (valoresEntreVirgulas[7].contains("PARADAS") && valoresEntreVirgulas[7].contains("(X)ABASTECIMENTO")) {
				evento = 7;
			} else if (valoresEntreVirgulas[7].contains("PARADAS") && valoresEntreVirgulas[7].contains("(X)LANCHE")) {
				evento = 5;
			} else if (valoresEntreVirgulas[7].contains("PARADAS") && valoresEntreVirgulas[7].contains("(X)BANHEIRO")) {
				evento = 6;
			} else if (valoresEntreVirgulas[7].contains("PARADAS") && valoresEntreVirgulas[7].contains("(X)REPOUSO")) {
				evento = 15;
			} else if (valoresEntreVirgulas[7].contains("PARADAS") && valoresEntreVirgulas[7].contains("(X)INTERVALO FEMININO")) {
				evento = 16;
			} else if (valoresEntreVirgulas[7].contains("PARADAS") && valoresEntreVirgulas[7].contains("(X)INTERVALO PESSOAL")) {
				evento = 25;
			} else if (valoresEntreVirgulas[7].contains("PARADAS") && valoresEntreVirgulas[7].contains("(X)MANUTENCAO")) {
				evento = 3;
			} else if (valoresEntreVirgulas[7].contains("PARADAS") && valoresEntreVirgulas[7].contains("(X)SINISTRO")) {
				evento = 4;
			} else if (valoresEntreVirgulas[7].contains("PARADAS") && valoresEntreVirgulas[7].contains("(X)PISTA INTERDITADA")) {
				evento = 23;
			} else {
				System.out.println("Não contém");
				evento = null;
			}

			writer.append(valoresEntreVirgulas[0].replace(" (UTC-3)", "") + ";"
					+ valoresEntreVirgulas[1].replace(" (UTC-3)", "") + ";" + vv3.replace("\"", "") + ";"
					+ valoresEntreVirgulas[4] + ";" + String.valueOf(evento) + "\n");
		}
		lerArq.close();
		writer.flush();
		writer.close();

	}
}
