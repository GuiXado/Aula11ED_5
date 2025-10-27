package br.gui.listagenerica;

public class ListaSet<T> {
	
	No<T> primeiro;
	
	public ListaSet() {
		primeiro = null;
	}
	
	public boolean isEmpty() {
	if (primeiro == null) {
	return  true;
	} 
	return false;
	}
	
	public int size() {
		int cont = 0;
		if (!isEmpty()) {
			No<T> auxiliar = primeiro;
			while (auxiliar != null) {
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}
	
	private boolean contem(T valor) throws Exception {
	    No<T> aux = primeiro;
	    while (aux != null) {
	        if (aux.dado.equals(valor)) { 
	        	return true;
	        }
	        aux = aux.proximo;
	    }
	    return false; 
	}
	
	public void addFirst(T valor) throws Exception {
		if(contem(valor)) throw new Exception("Elemento já existe na Lista");
		
		No<T> elemento = new No<T>();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}
	
	public void addLast(T valor) throws Exception {
		if(contem(valor)) throw new Exception("Elemento já existe na Lista");
		
		if (isEmpty()) { 
			addFirst(valor);
		} else {
			int tamanho = size();
			
			No<T> elemento = new No<T>();
			elemento.dado = valor;
			elemento.proximo = null; // redundancia
			
			No<T> ultimo = getNo(tamanho - 1);
			ultimo.proximo = elemento;
		}
	}
	
	public void add (T valor, int pos) throws Exception {
		if(contem(valor)) throw new Exception("Elemento já existe na Lista");
		if(isEmpty()) throw new Exception("Lista Vazia");
		
		int tamanho = size();
		
		if (pos < 0 || pos > tamanho) throw new Exception("Posição Inválida");
		
		if (pos == 0) {
			addFirst(valor);
		} else if (pos == tamanho) {
			addLast(valor);
		} else {
			No<T> elemento = new No<T>();
			elemento.dado = valor;
			No<T> anterior = getNo(pos - 1);
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}
	
	public void removeFirst() throws Exception  {
		if (isEmpty()) throw new Exception("Lista Vazia");
		
		primeiro = primeiro.proximo;
	}
	
	public void removeLast() throws Exception {
		if (isEmpty()) throw new Exception("Lista Vazia");
		
		int tamanho = size();
		
		if (tamanho == 1) {
			removeFirst();
		} else {
			No<T> penultimo = getNo(tamanho - 2);
			penultimo.proximo = null;
		}
	}
	
	public void remove (int pos) throws Exception {
		if  (isEmpty()) throw new Exception("Lista Vazia");
		
		int tamanho = size();
		
		if (pos < 0 || pos > tamanho - 1) throw new Exception("Posição Inválida");
		
		if (pos == 0) {
			removeFirst();
		} else if (pos == tamanho - 1) {
			removeLast();
		} else {
			No<T> anterior = getNo(pos - 1);
			No<T> atual = getNo(pos);
			anterior.proximo = atual.proximo;
		}
	}
	
	public T get(int pos) throws Exception{
		if (isEmpty()) throw new Exception("Lista Vazia");
		
		int tamanho = size();
		
		if (pos < 0 || pos > tamanho - 1) throw new Exception("Posição Inválida");
		
		int cont = 0;
		No<T> auxiliar = primeiro;
		
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		return auxiliar.dado;
	}
	
	public void clean() throws Exception {
		if (isEmpty()) throw new Exception("Lista Vazia");
		
		primeiro = null;
	}
	
	private No<T> getNo(int pos) throws Exception {
		
		if (isEmpty()) throw new Exception("Lista Vazia");

		int tamanho = size();
		
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception ("Posição inválida");
		}
		
		No<T> auxiliar = primeiro;
		int cont = 0;
		
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		
		return auxiliar;
	}
	
}
