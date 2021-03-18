import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		Fifo fifo = new Fifo();
		
		int com = 0;
		
		do {
			System.out.printf("Menu %n 1.Inserir %n 2.Retirar %n 3.Detornar %n 4.Mostrar Matrículas %n 5.Mostrar Invertido %n 6.Média de Idade %n 7.Achar Setor %n 8.Achar Idoso %n 9. Quantos Setor %n%n 10.Idade Média Por Setor %n 11.Funcionários em cada setor %n%n 12.Vazar %n");
			com = sc.nextInt();
			sc.nextLine();
			
			switch (com) {
			case 1:
				System.out.println("Informe a matrícula: ");
				int matricula = sc.nextInt();
				sc.nextLine();
				System.out.println("Informe a idade: ");
				int idade = sc.nextInt();
				sc.nextLine();
				System.out.println("Informe o setor: ");
				int setor = sc.nextInt();
				sc.nextLine();
				fifo.inserir(matricula, idade, setor);
				break;
				
			case 2:
				System.out.println("Retirado: " + fifo.retirar());
				break;
				
			case 3:
				System.out.println("Fila vazia");
				fifo.detonar();
				break;
				
			case 4:
				fifo.mostrarMatriculas();
				break;
				
			case 5:
				fifo.mostrarInvertido();
				break;
				
			case 6:
				System.out.println("Média: " + fifo.mediaIdade());
				break;
				
			case 7:
				System.out.print("Informe a matícula: ");
				int mat = sc.nextInt();
				sc.nextLine();
				System.out.println("Setor: " + fifo.acharSetor(mat));
				break;
				
			case 8:
				System.out.println("Funcionário mais velho: " + fifo.acharIdoso());
				break;
				
			case 9:
				System.out.print("Informe o setor: ");
				int set = sc.nextInt();
				sc.nextLine();
				System.out.println("Quantidade de fincionários no setor: " + fifo.quantosNoSetor(set));
				break;
				
			case 10:
				fifo.mediaPorSetor();
				break;
				
			case 11:
				fifo.funcionariosPorSetor();
				break;
			}
		} while (com != 12); 
		sc.close();
	}

}
