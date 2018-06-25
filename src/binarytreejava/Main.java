package binarytreejava;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
/**
 * 
 * @author Matheus Ladislau Ribeiro
 * matheusladislauribeiro@gmail.com
 * www.linkedin.com/in/matheusladislau/
 * 
 */
public class Main{
    public static void main(String[] args) throws IOException, URISyntaxException{
        Arvore arvore=new Arvore();
        lerArquivo(arvore);
        System.out.println("===exibir===");
        arvore.exibeArvore();
        System.out.println("");
        System.out.println("contar nós: "+arvore.contarNos());

        excluirMenoresQue(arvore,100);
        System.out.println("===exibir===");
        arvore.exibeArvore();
        System.out.println("");
        System.out.println("contar nós: "+arvore.contarNos());

    }
    
    public static void excluirMenoresQue(Arvore arvore,int valor) throws IOException{
//        JFileChooser arquivo=new JFileChooser();
//        int retorno=arquivo.showOpenDialog(null);
//        if(retorno==JFileChooser.APPROVE_OPTION){
//            String nome=arquivo.getSelectedFile().getAbsolutePath();
//            System.out.println("lendo arquivo "+nome);
//            try{
                String nome = "C:\\Users\\Matheus\\Documents\\arvore2.txt";
                System.out.println("lendo arquivo "+nome);
                FileReader arq=new FileReader(nome);
                BufferedReader lerArq=new BufferedReader(arq);
                String linha=lerArq.readLine();
                
                //percorre linha por linha do arquivo
                while(linha!=null){
                    if(Integer.parseInt(linha)<valor){
                        //efetivamente remove
                        arvore.remover(Integer.parseInt(linha));
                    }
                    linha=lerArq.readLine();
                }
                arq.close();
//            }catch(IOException e){
//                System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
//            }
    }
    
    public static void lerArquivo(Arvore arvore) throws IOException, URISyntaxException{
        No temp=arvore.raiz;
//        JFileChooser arquivo=new JFileChooser();
//        int retorno=arquivo.showOpenDialog(null);
//        if(retorno==JFileChooser.APPROVE_OPTION){
//            String nome=arquivo.getSelectedFile().getAbsolutePath();
//            System.out.println("lendo arquivo "+nome);
//            try{
               
                String nome = "C:\\Users\\Matheus\\Documents\\arvore2.txt";
                System.out.println("lendo arquivo "+nome);
                FileReader arq=new FileReader(nome);
                BufferedReader lerArq=new BufferedReader(arq);
                String linha=lerArq.readLine();
                while(linha!=null){
                    arvore.inserir(Integer.parseInt(linha));
                    linha=lerArq.readLine();
                }
                arq.close();
//            }catch(IOException e){
//                System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
//            }
    }
}    
   
