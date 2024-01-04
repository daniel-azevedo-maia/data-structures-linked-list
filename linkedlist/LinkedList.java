package linkedlist;

public class LinkedList {

    private Node head; // Referência ao primeiro nó da lista
    private Node tail; // Referência ao último nó da lista
    private int length; // Contador do número de elementos na lista

    // Classe interna Node para representar cada elemento da lista
    class Node {
        int value; // Valor armazenado no nó
        Node next; // Referência ao próximo nó na lista

        // Construtor para criar um novo nó com um valor específico
        Node(int value) {
            this.value = value;
        }
    }

    // Construtor para criar uma lista com um elemento inicial
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode; // Define o novo nó como cabeça da lista
        tail = newNode; // Define o mesmo nó como cauda da lista
        length = 1; // Inicializa o comprimento da lista como 1
    }

    // Método para adicionar um nó no final da lista
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // Conecta o último nó ao novo nó
            tail = newNode; // Atualiza a cauda para ser o novo nó
        }
        length++; // Incrementa o comprimento da lista
    }

    // Método para adicionar um nó no início da lista
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head; // O novo nó aponta para o antigo primeiro nó
            head = newNode; // Atualiza a cabeça para ser o novo nó
        }
        length++; // Incrementa o comprimento da lista
    }

    // Método para inserir um nó em uma posição específica
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false; // Verifica limites

        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);

        Node temp = get(index - 1); // Encontra o nó anterior ao índice desejado
        newNode.next = temp.next; // Conecta o novo nó ao próximo nó
        temp.next = newNode; // Insere o novo nó na posição correta
        length++; // Incrementa o comprimento da lista
        return true;
    }

    // Método para imprimir todos os elementos da lista
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value); // Imprime o valor do nó atual
            temp = temp.next; // Move para o próximo nó
        }
    }

    // Método para remover o último nó da lista
    public Node removeLast() {
        if (length == 0) return null; // Verifica se a lista está vazia

        Node temp = head;
        Node pre = head;

        while (temp.next != null) {
            pre = temp; // Armazena o penúltimo nó
            temp = temp.next; // Move para o último nó
        }

        tail = pre; // Atualiza a cauda para ser o penúltimo nó
        tail.next = null; // Remove a referência ao último nó
        length--; // Decrementa o comprimento da lista

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp; // Retorna o nó removido
    }

    // Método para remover o primeiro nó da lista
    public Node removeFirst() {
        if (length == 0) return null; // Verifica se a lista está vazia

        Node temp = head; // Armazena o primeiro nó

        head = head.next; // Move a cabeça para o segundo nó
        temp.next = null; // Remove a referência ao antigo primeiro nó
        length--; // Decrementa o comprimento da lista

        if (length == 0) {
            tail = null; // Se a lista estiver vazia, atualiza a cauda
        }

        return temp; // Retorna o nó removido
    }

    // Método para remover um nó de um índice específico
    public Node remove(int index) {
        if (index < 0 || index >= length) return null; // Verifica limites

        if (index == 0) return removeFirst();

        if (index == length - 1) return removeLast();

        Node prev = get(index - 1); // Encontra o nó anterior ao índice desejado
        Node temp = prev.next; // Armazena o nó a ser removido

        prev.next = temp.next; // Remove a referência ao nó removido
        temp.next = null; // Limpa a referência do nó removido
        length--; // Decrementa o comprimento da lista

        return temp; // Retorna o nó removido
    }

    // Método para obter um nó de um índice específico
    public Node get(int index) {
        if (index < 0 || index >= length) return null; // Verifica limites

        Node temp = head; // Começa do primeiro nó

        for (int i = 0; i < index; i++) {
            temp = temp.next; // Move para o próximo nó
        }

        return temp; // Retorna o nó encontrado
    }

    // Método para definir o valor de um nó em um índice específico
    public boolean set(int index, int value) {
        Node temp = get(index); // Encontra o nó no índice especificado
        if (temp != null) {
            temp.value = value; // Atualiza o valor do nó
            return true;
        }
        return false;
    }

    // Método para inverter a ordem dos nós na lista
    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next; // Armazena a referência ao próximo nó
            temp.next = before; // Inverte a referência do nó atual
            before = temp; // Move para o próximo nó
            temp = after;
        }
    }

    // Método para obter o valor do primeiro nó
    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    // Método para obter o valor do último nó
    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    // Método para obter o comprimento da lista
    public void getLength() {
        System.out.println("Length: " + length);
    }
}
