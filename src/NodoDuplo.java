public class NodoDuplo {
	public NodoDuplo antes;
	public NodoDuplo depois;
	public int matricula;
	public int idade;
	public int setor;

	public NodoDuplo(int matricula, int idade, int setor){
		this.matricula = matricula;
		this.idade  = idade;
		this.setor = setor;
		antes = null;
		depois = null;
	}
}



