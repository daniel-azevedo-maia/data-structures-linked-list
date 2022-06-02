
public class Principal {

	public static void main(String[] args) {
		
		Lista listaencadeada = new Lista();
		System.out.println("A lista está vazia? " + listaencadeada.estaVazia());
		
		Aluno a1 = new Aluno();
		a1.nome = "Bob Esponja";
		a1.idade = "10";
		
		Aluno a2 = new Aluno();
		a2.nome = "Patrick";
		a2.idade = "12";
		
		listaencadeada.inserirAlunoInicio(a1);
		listaencadeada.inserirNoFim(a2);
		
		System.out.println("A lista tem " + listaencadeada.tamanhoDaLista() + " elementos.");
		System.out.println("Elementos da lista: ");
		listaencadeada.exibirLista();
				
		Aluno a3 = new Aluno();
		a3.nome = "Lula Molusco";
		a3.idade = "15";
		
		Aluno a4 = new Aluno();
		a4.nome = "Gary Caracol";
		a4.idade = "2";
		
		listaencadeada.inserirAlunoInicio(a3);
		listaencadeada.inserirAlunoInicio(a4);
		listaencadeada.exibirLista();
		
		listaencadeada.removerAlunoPorNome("Gary Caracol");
		
		listaencadeada.exibirLista();
		

	}

}
