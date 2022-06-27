import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static Scanner leitor;
    public static Random random;
    public static char[] letras;
    public static char[] simbolos;
    
    public static void mostrarForca(int chances, String tema){
        if(chances == 6){
            System.out.print("\nFORCA\n");
            System.out.println(" _______");
            System.out.println(" |     |");
            System.out.println(" |        ");
            System.out.println(" |       ");
            System.out.println(" |       ");
            System.out.println("___________       ");
        }
        
        if(chances == 5){
            System.out.print("\nFORCA\n");
            System.out.println(" _______");
            System.out.println(" |     |");
            System.out.println(" |     O");
            System.out.println(" |      ");
            System.out.println(" |      ");
            System.out.println("___________       ");
        }
        
        if(chances == 4){
            System.out.print("\nFORCA\n");
            System.out.println(" _______");
            System.out.println(" |     |");
            System.out.println(" |     O");
            System.out.println(" |     |");
            System.out.println(" |      ");
            System.out.println("___________       ");
        }
        
        if(chances == 3){
            System.out.print("\nFORCA\n");
            System.out.println(" _______");
            System.out.println(" |     |");
            System.out.println(" |     O");
            System.out.println(" |     |");
            System.out.println(" |    / ");
            System.out.println("___________       ");
        }
        
        if(chances == 2){
            System.out.print("\nFORCA\n");
            System.out.println(" _______");
            System.out.println(" |     |");
            System.out.println(" |     O");
            System.out.println(" |     |");
            System.out.println(" |    / \\");
            System.out.println("___________       ");
        }
        
        if(chances == 1){
            System.out.print("\nFORCA\n");
            System.out.println(" _______");
            System.out.println(" |     |");
            System.out.println(" |     O");
            System.out.println(" |    /|");
            System.out.println(" |    / \\");
            System.out.println("___________       ");
        }
        
        if(chances == 0){
            System.out.print("\nFORCA\n");
            System.out.println(" _______");
            System.out.println(" |     |");
            System.out.println(" |     O");
            System.out.println(" |    /|\\");
            System.out.println(" |    / \\");
            System.out.println("___________       ");
            System.out.println("Morto não fala, tchau!");
            System.exit(0); 
        }
    
        //mostrando a palavra "escondida pro usuario"
	    System.out.print("\nTema: "+tema+"\n");
	    for (int i=0; i<simbolos.length; i++)
	        System.out.print(simbolos[i]+" ");
    }
    
	public static void main(String[] args) {
	    leitor = new Scanner(System.in);
	    random = new Random();
	    char chute;
	    boolean verificaChances = false; //variavel que vai mostrar se tem a letra na palavra
	    boolean verificaVitoria = true; //varival que vai mostrar se todas as letras já foram reveladas
	   
	    int chances = 6;
	    
	    String vetor[] = {"BANANA", "LARANJA","KIWI","COCO","CAJU"}; 
	    
	    String tema = "Fruta";
	    
	    //1 - pegar a palavra sorteada;
	    String pSorteada = vetor[random.nextInt(vetor.length)]; //o limite vai ser o tamanho do vetor;
	    
	    //2 - transformar a palavra em um vetor. Ex: "uva" -> ["u", "v", "a"]
	    letras = pSorteada.toCharArray();
	    simbolos = new char[letras.length]; //vetor que vai ser mostrado ao usuario
	    
	   //3 - preenchendo o vetor simbolos
	    for (int i=0; i<simbolos.length; i++)
	        simbolos[i] = '_';
	        
	  
	   
	   
	   do{
	       mostrarForca(chances, tema);
    	        
    	   //5 - Pedindo o usuario pra chutar
    	   System.out.print("\nDigite uma letra: ");
    	   chute = Character.toUpperCase(leitor.next().charAt(0));
    	   
    	   verificaVitoria = true; //restart no valor pois a verificação é necessária a cada jogada
    	   verificaChances = false;
    	   //6 - Verificando chute
    	   for (int i=0; i<letras.length; i++){
    	       if(letras[i] == chute){ //se ele achar a letra na palavra
    	           simbolos[i] = chute; //ele vai substituir o simbolo pela letra
    	           verificaChances = true; //e vai mostrar que achou a letra chutada na palavra
    	       }
    	       
    	       if(simbolos[i] == '_') //se tiver pelo menos um "_" significa que a palavra não foi revelada
    	           verificaVitoria = false; 
    	            
    	   }
    	   
    	   if(verificaChances == false)
    	        chances --;
    	        
    	   if(verificaVitoria == true){
    	       mostrarForca(chances,tema);
    	       System.out.print("\nGanhou!");
    	       break;
    	   }
	  
	   }while(chances>=0);
	leitor.close();
	}
}



