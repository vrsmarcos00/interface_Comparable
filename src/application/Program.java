package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employee;

public class Program {
	
	public static void main(String[] args) {
		
	/*Faça um programa para ler um arquivo contendo nomes de pessoas (um nome por 
	linha), armazenando-os em uma lista. Depois, ordenar os dados dessa lista e mostra-los 
	ordenadamente na tela. Nota: o caminho do arquivo pode ser informado "hardcode".
	*/
		
		List<String> list = new ArrayList<>();
		String path = "C:\\temp\\in.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String name = br.readLine();
			while (name != null) {
				list.add(name);
				name = br.readLine();
			}
			
			Collections.sort(list); // Forma de ordenar uma coleção
			for (String s : list) {
				System.out.println(s);
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		/*
		 Faça um programa para ler um arquivo contendo funcionários (nome e salário) no
		formato .csv, armazenando-os em uma lista. Depois, ordenar a lista por nome e mostrar
		o resultado na tela. Nota: o caminho do arquivo pode ser informado "hardcode"
		 */
		
		System.out.println();
		
		List<Employee> list2 = new ArrayList<>();
		String path2 = "C:\\temp\\in2.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path2))){
			
			String employeeCsv = br.readLine();
			while (employeeCsv != null) {
				String[] fields = employeeCsv.split(",");
				list2.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				employeeCsv = br.readLine();
			}
			
			Collections.sort(list2); // Forma de ordenar uma coleção
			for (Employee emp : list2) {
				System.out.println(emp.getName() + ", " + emp.getSalary());
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}
