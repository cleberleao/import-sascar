package br.com.chart.rodovia.infra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportarCSV {
	public static void main(String[] args) {
        
	       //abre um arquivo e cria um file
	       File arquivoCSV = new File("macros.csv");
	        
	        try{
	            
	            //cria um scanner para ler o arquivo
	            Scanner leitor = new Scanner(arquivoCSV);
	            
	            //variavel que armazenara as linhas do arquivo
	            String linhasDoArquivo = new String();
	            
	            //ignora a primeira linha do arquivo
	            leitor.nextLine();
	            
	            //percorre todo o arquivo
	            while(leitor.hasNext()){
	                
	                //recebe cada linha do arquivo
	                linhasDoArquivo = leitor.nextLine();
	                
	                //separa os campos entre as virgulas de cada linha
	                String[] valoresEntreVirgulas = linhasDoArquivo.split(";");
	                
	                //imprime a coluna que quiser
	                System.out.println(valoresEntreVirgulas[2]);
	            }leitor.close();
	        
	        }catch(FileNotFoundException e){
	            
	        }
	        
	    }
}
