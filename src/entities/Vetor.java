package entities;

//import java.util.Arrays;s

public class Vetor {
	
	private String[] elementos;
	private int tamanho;
	
	public Vetor(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
		
	}
	
	public Vetor() {
		
	}
//	ADCIONA UM VALOR DENTRO DE UM ARRAY
	public boolean adciona(String elemento) {
		
		this.aumentaCapacidade();
		
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		
		return false;
	}
	
//	VAI RETORNAR O TAMANHO DO ARRAY
	public int tamanho() {
		return this.tamanho;
		
	}
	
//	VAI PRINTAR TODOS OS ELEMENTOS DO ARRAY
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		
		s.append("[");
		
		for (int i = 0; i<this.tamanho-1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
			
		}
		
		if (this.tamanho > 0) {
			s.append(this.elementos[this.tamanho-1]);
		}
		
		s.append("]");
		
//		return Arrays.toString(this.elementos);
		return s.toString();
	}
	
//	BUSCAR POSICAO
	public String busca(int posicao) {
		
		if (!(posicao >= 0 && posicao < this.tamanho)) {
			throw new IllegalArgumentException("Posi��o inv�lida");
			
		}
		return this.elementos[posicao];
	}
	
//	VERIFICAR SE O ELEMENTO EXISTE
//	public boolean verificar(String elemento) {
//		
//		for (int i = 0; i <= this.tamanho; i++) {
//			
////			if DE UMA LINHA
////			if (this.elementos[i].equals(elemento)) return true;
//			if (this.elementos[i].equals(elemento)) {
//				return true;
//			}
//			
//		}
//		
//		return false;
//		
//	}
//	
	
	public int verificar(String elemento) {
		
		for (int i = 0; i < this.tamanho; i++) {
			if (this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		
		return -1;
	}
	
	
//	ADD ELEMENTO EM QUALQUER POSI��O
	
	public boolean adciona(int posicao, String elemento) {
		
		if (!(posicao >= 0 && posicao < this.tamanho)) {
			throw new IllegalArgumentException("Posi��o inv�lida");
		}
		
		this.aumentaCapacidade();
		
//		MOVER TODOS OS ELEMENTOS
		for (int i = this.tamanho - 1; i >= posicao; i--) {
			this.elementos[i+1] = this.elementos[i];
			
		}
		
		this.elementos[posicao] = elemento;
		this.tamanho++;
		
		return false;
	}
	
//	AUMENTAR A CAPACIDADE DO VETOR
	private void aumentaCapacidade() {
		
		if (this.tamanho == this.elementos.length) {
			String[] elementosNovos = new String[this.elementos.length*2];
			
			for (int i = 0; i < this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
				
			}
			
			this.elementos = elementosNovos;
		}
	}
	
	public void remover(int posicao) {
		
		if (!(posicao >= 0 && posicao < this.tamanho)) {
			throw new IllegalArgumentException("Posi��o inv�lida");
		}
		
		for (int i = posicao; i < this.elementos.length - 1; i++) {
			this.elementos[i] = this.elementos[i+1];
		}
		
		this.tamanho--;
	}
	

}



















