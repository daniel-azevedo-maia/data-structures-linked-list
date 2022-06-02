
public class Lista {
	
	Aluno primeiro = null;
	Aluno ultimo = null;
	int tamanho = 0;

	public boolean estaVazia() {
		if (tamanho == 0) {
			return true;
		}
		return false;
	}
	
	public int tamanhoDaLista() {
		return tamanho;
	}
	
	public void inserirAlunoInicio(Aluno a) {
		if ( estaVazia() ) {
			primeiro = ultimo = a;
		} else {
			a.proximo = primeiro;
			primeiro = a;
		}
		tamanho++;
	}
	
	public void inserirNoFim(Aluno a) {
		if ( estaVazia() ) {
			primeiro = ultimo = a;
		} else {
			ultimo.proximo = a;
			ultimo = a;
		}
		tamanho++;
	}
	
	public void exibirLista() {
		Aluno temp = primeiro;
		if ( estaVazia() == false ) {
			for (int i = 0; i < tamanho; i++) {
				System.out.println("Aluno " + i + " | nome: " + temp.nome + " | idade: " + temp.idade);
				temp = temp.proximo;
			}
		}
	}
	
	public void removerAlunoPorNome(String nomeprocurado) {
		//Caso a lista esteja vazia
		if (tamanho == 0) {
			System.out.println("Lista vazia!");
			//Esse return impedirá o restante da execução do método
			return;
		}
		
		//Caso a lista tenha apenas um elemento
		if (tamanho == 1) {
			if (primeiro.nome.equals(nomeprocurado)) {
				primeiro = ultimo = null;
				tamanho--;
				return;
			} 
			
			else {
				System.out.println("O nome procurado não está na lista!");
				return;
			}
		}
		
		Aluno alunodafrente = primeiro;
		Aluno alunodetras = null;
		
		for (int i = 0; i < tamanho; i++) {
			if (nomeprocurado.equals(alunodafrente.nome)) {
				//Caso encontre o nome num dado elemento, e se estiver na posição 0, ou seja, o primeiro elemento...
				if (i == 0) {
					System.out.println("Achei na primeira posição!");
					primeiro = primeiro.proximo;
					tamanho--;
					return;
				} else {
					alunodetras.proximo = alunodafrente.proximo;
					tamanho--;
					return;
				}
			} else {
				//caso não encontre o nome, vai saltar para o próximo elemento
				System.out.println("Procurando...");
				alunodetras = alunodafrente;
				alunodafrente = alunodafrente.proximo;
			}
		}
		
		
	
	}

	

}
