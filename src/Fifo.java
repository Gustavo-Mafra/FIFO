import java.util.List;
import java.util.ArrayList;

public class Fifo {
	public NodoDuplo inicio;
	public NodoDuplo fim;

	public Fifo(){
		inicio = null;
		fim = null;
	}

	//Op��o 1
	public void inserir(int matricula, int idade, int setor) {
		NodoDuplo aux = new NodoDuplo(matricula, idade, setor);
		if (inicio == null) {
			inicio = aux;
		} else {
			aux.antes = fim;
			fim.depois = aux;
		}
		fim = aux;
	}

	//Op��o 2
	public int retirar() {
		Integer aux = null;
		if (fim != null) {
			aux = inicio.matricula;
			inicio = inicio.depois;
			if (inicio != null) {
				inicio.antes = null;
			} else {
				fim = null;
			}
		}
		return aux;
		
	}

	//Op��o 3
	public void detonar() {
		inicio = null;
		fim = null;
	}

	//Op��o 4
	public void mostrarMatriculas() {
		NodoDuplo aux = inicio;
		System.out.print("Matr�culas do in�cio ao fim: ");

		while (aux != null) {
			System.out.print(" " + aux.matricula);
			aux = aux.depois;
		}
		System.out.println();
	}

	//Op��o 5
	public void mostrarInvertido() {
		NodoDuplo aux = fim;
		System.out.print("Matr�culas do fim ao in�cio: ");

		while (aux != null) {
			System.out.print(" " + aux.matricula);
			aux = aux.antes;
		}
		System.out.println();
	}

	//Op��o 6
	public float mediaIdade() {
		int cont = 0; 
		int soma = 0;
		NodoDuplo aux = inicio;
		while (aux != null) {
			soma += aux.idade;
			cont ++;
			aux = aux.depois;
		}
		float media = soma / cont;
		return media;
	}

	//Op��o 7
	public int acharSetor(int matricula) {
		NodoDuplo aux = inicio;
		while (aux != null) {
			if (aux.matricula == matricula) {
				return aux.setor;
			} else {
				aux = aux.depois;
			}
		}
		return 0;	
	}

	//Op��o 8
	public int acharIdoso() {
		NodoDuplo aux;

		if (inicio.depois != null) {
			aux = inicio.depois;
		} else {
			return inicio.matricula;
		}

		NodoDuplo idoso = inicio;
		while (aux != null) {
			if (aux.idade > idoso.idade) {
				idoso = aux;
			}
			aux = aux.depois;
		}
		return idoso.matricula;
	}

	//Op��o 9
	public int quantosNoSetor (int setor) {
		NodoDuplo aux = inicio;
		int cont = 0;
		while (aux != null) {
			if (aux.setor == setor) {
				cont ++;
			}
			aux = aux.depois;
		}
		return cont;
	}

	//Op��o 10 - Desafio
	public void mediaPorSetor() {
		List<Integer> setores = new ArrayList<>();
		NodoDuplo aux = inicio;
		System.out.println("M�dia de idade por setor:");
		
		while (aux != null) {
			NodoDuplo aux2 = aux;
			if (setores.contains(aux.setor)) {
				
			} else {
				setores.add(aux.setor);
				float soma = 0;
				float cont = 0;
				
				while (aux2 != null) {
					if (aux2.setor == aux.setor) {
						soma += aux2.idade;
						cont ++;
					}
					aux2 = aux2.depois;
				}
				float media = soma / cont;
				System.out.printf("M�dia de idade do setor %d: %.2f %n", aux.setor, media);
			}
			aux = aux.depois;
		}
	}

	//Op��o 11 - Desafio
	public void funcionariosPorSetor() {
		List<Integer> setores = new ArrayList<>();
		NodoDuplo aux = inicio;
		System.out.println("Quantidade de funcion�rios por setor:");
		
		while (aux != null) {
			NodoDuplo aux2 = aux;
			if (setores.contains(aux.setor)) {
				
			} else {
				setores.add(aux.setor);
				int funcionarios = 0;
				
				while (aux2 != null) {
					if (aux2.setor == aux.setor) {
						funcionarios ++;
					}
					aux2 = aux2.depois;
				}
				System.out.printf("No setor %d existem %d funcion�rios %n", aux.setor, funcionarios);
			}
			aux = aux.depois;
		}
	}
}