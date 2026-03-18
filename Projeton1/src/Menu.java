import java.util.Scanner;
import java.util.Random;
//Eduardo Berthoux de Oliveira Souza, 10322329 e Andreas Caycedo Martinez, 10435302
public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int[] vetor = null;
		int opcao;
			
		// Menu em constante execução usando o while
			boolean sair = false;
		
			while(!sair)
		{
			System.out.println("\n===== MENU =====");
			
			System.out.println("1. Inicializar o vetor com números aleatórios");
			
			System.out.println("2. Imprimir o vetor");
			
			System.out.println("3. Verificar se um determinado número está contido no vetor");
			
			System.out.println("4. Buscar o maior número armazenado no vetor");
			
			System.out.println("5. Calcular a média dos números pares armazenados no vetor");
			
			System.out.println("6. Calcular o percentual dos números ímpares armazenados no vetor");
			
			System.out.println("7. Calcula a média centralizada dos números armazenados no vetor");
			
			System.out.println("8. Verificar se dado um valor existe dois números em posições distintas que somados são iguais ao valor informado.");
			
			System.out.println("0. Encerrar Programa");
			
			System.out.print("Escolha uma opção: ");
			
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				
				System.out.printf("Insira o tamanho do vetor: " );
				int N = sc.nextInt();
				int M;
				do {
		            System.out.print("Digite um número inteiro positivo: ");
		            M = sc.nextInt();
		            
				} while (M <= 0);

		        // Vetor de tamanho N
		        vetor = new int[N];
		        

		        // Vetor com números inteiros 
		        for (int i = 0; i < N; i++) {
                    vetor [i] = random.nextInt(M + 1);
		        	
                }
                
                break;
				
			case 2:
                if (vetor != null) {
                	imprimirVetor(vetor);
                } 
                else {
                    System.out.println("O vetor ainda não foi criado. Escolha a opção 1 primeiro.");
                }
                break;
			
			case 3: 
				if (vetor != null) {
					System.out.print("Digite o valor que deseja procurar: ");
					//Procura o valor no vetor
					int valorProcura = sc.nextInt();
							
					int indice = proValor(vetor, valorProcura);
					
						if (indice != -1) {
							System.out.print("Valor encontrado: " + indice);
							
						} 
						else {
							System.out.print("Valor não encontrado no vetor");
					}
				} 
				else {
					System.out.print("O vetor ainda não foi criado. Escolha a opção 1 primeiro.");
				}
                
			case 4:
			
				if (vetor != null) {
					int[] meuVetor = vetor;
					int maior = encontrarMaior(meuVetor);
					System.out.print("\nO maior número do vetor é: " + maior);
					
				}
				else {
					System.out.print("O vetor ainda não foi criado. Escolha a opção 1 primeiro.");
				}
			
			case 5:
				
				if(vetor != null) {
					int[] meuVetor = vetor;
					double media = calcularMedia(meuVetor);
					System.out.print("\nA média dos numeros pares é: " + media);
				}
				else {
					System.out.print("O vetor ainda não foi criado. Escolha a opção 1 primeiro.");
				}
			
			case 6:
				if(vetor != null) {
					int[] meuVetor = vetor;
					double percentual = calcularPercentual(meuVetor);
					System.out.printf("\nO percentual do ímpares é: %.2f%%\n", percentual);
				}
				else {
					System.out.print("O vetor ainda não foi criado. Escolha a opção 1 primeiro.");
				}
			
			case 7:
				if(vetor != null) {
					int[] meuVetor = vetor;
					double mediacentralizada = calcularMediacentro(meuVetor);
					System.out.printf("\nA média centralizada é de: %.2f%n", mediacentralizada);
				}
				else {
					System.out.print("O vetor ainda não foi criado. Escolha a opção 1 primeiro.");
				}
			
			case 8:
				if(vetor != null) {
					int[] meuVetor = vetor;
					int valorFinal = vetor[1] + vetor[2];
					boolean resultado = somaDosVetores(meuVetor, valorFinal);
					
				
					if(resultado) {
						System.out.print("Existem dois numeros que a soma tem o valor de: " + valorFinal);
					} else {
						System.out.print("Não existe um numero que somado tem o valor de: " + valorFinal);
					}
					
				}
				else {
					System.out.print("O vetor ainda não foi criado. Escolha a opção 1 primeiro.");
				}
			
			case 0:
                System.out.print("\nEncerrando o programa...");
                break;

            default:
                System.out.print("Opção inválida! Tente novamente.");
			}
						
		}		
			
	}		//Metodo criado para imprimir o vetor no case 2		
		public static void imprimirVetor(int[] vetor) {
			
			for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
			
	
		} //Metodo criado para encontrar o vetor
		public static int proValor (int[] vetor, int valor) {
			
			for(int i = 0; i < vetor.length; i++) {
				if(vetor[i] == valor) {
					return i;
				} 
				
			}
			
					return -1;
		} 	//Metodo para achar o maior numero
		public static int encontrarMaior (int[] vetor) {
			int maior = vetor[0];
			for(int i = 1; i < vetor.length; i++) {
				if (vetor[i] > maior) {
					maior = vetor[i];
						
					}
				}
				return maior;
		}	//Metodo para calcular a media entre os numeros pares
		public static double calcularMedia(int[] vetor) {
			int soma = 0;
			int quantidade = 0;
			
			for (int num : vetor) {
				if (num % 2 == 0) {
					soma = soma = num;
					quantidade++;
				}
			}
			if (quantidade == 0) {
				return 0;
			}
			return (double) soma / quantidade;
		}
		// Metodo para calcular o percentual
		public static double calcularPercentual(int[] vetor) {
			int quantidadeImpares = 0;
			for (int num : vetor) {
				if(num % 2 != 0) {
					quantidadeImpares++;
				}
			}
			return ((double) quantidadeImpares / vetor.length) * 100;
		}
		//metodo criado para calcular a media centralizada
		public static double calcularMediacentro(int[] vetor) {
			if (vetor.length <= 2) {
				return 0;
			}
		int soma = 0;
		int maior = vetor[0];
		int menor = vetor[0];
				
		for	(int num : vetor) {
			soma = soma + num;
			if (num > maior) maior = num;
			if (num < menor) menor = num;
		}
		soma -= maior;
		soma -= menor;
		
		return (double) soma /(vetor.length - 2);
		}//Metodo para saber se existem 2 numeros em posicoes distintas
		public static boolean somaDosVetores(int[] vetor, int valor) {
			for(int i = 0; i < vetor.length; i++) {
				for(int j = i; j < vetor.length; j++) {
					if (vetor[i] + vetor[j] == valor) {
						return true;
					}
				}
			}
			return false;
		}
}	


	


