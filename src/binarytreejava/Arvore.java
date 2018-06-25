package binarytreejava;
public class Arvore{
    static No raiz;
    
    public Arvore(){
        this.raiz=null;
    }
    
    public void remover(int valor){
        remover(raiz,valor);
    }
    
    public void remover(No no,int valor){
        No temp=no;
        if(temp.valor==valor){
//        if(removido==false)
        }else{
            if(valor>temp.valor){
                if(temp.direita.valor==valor){
                    switch(contarFilhos(temp.direita)){
                        case 0:
                            temp.direita=null;
                            break;
                        case 1:
                            if(temp.direita.direita!=null){
                                temp.direita=temp.direita.direita;
                            }else{
                                temp.esquerda=temp.direita.esquerda;
                            }
                            break;
                        case 2:
                            //temp.esque = excluir
                            No maisEq=noMaisAEsquerda(temp.direita);
                            remover(maisEq.valor);
                            maisEq.direita=temp.direita.direita;
                            maisEq.esquerda=temp.direita.esquerda;
                            temp.direita=maisEq;
                            break;
                        default:
                            break;
                    }
                }else{
                    remover(temp.direita,valor);
                }
            }else{
                if(temp.esquerda.valor==valor){
                    switch(contarFilhos(temp.esquerda)){
                        case 0:
                            temp.esquerda=null;
                            break;
                        case 1:
                            if(temp.esquerda.esquerda!=null){
                                temp.esquerda=temp.esquerda.esquerda;
                            }else{
                                temp.direita=temp.esquerda.direita;
                            }
                            break;
                        case 2:
                            //temp.esque = excluir
                            No maisDir=noMaisADireita(temp.esquerda);
                            remover(maisDir.valor);
                            maisDir.esquerda=temp.esquerda.esquerda;
                            maisDir.direita=temp.esquerda.direita;
                            temp.esquerda=maisDir;

                            break;
                        default:
                            break;
                    }
                }else{
                    remover(temp.esquerda,valor);
                }
            }
        }
    }

    public int contarFilhos(No no){
        int contador=0;
        if(no.esquerda!=null)
            contador++;
        if(no.direita!=null)
            contador++;
        return contador;
    }
    
    public No noMaisAEsquerda(No no){
        No temp=no;
        while(temp.esquerda!=null){
            temp=temp.esquerda;
        }
        return temp;
    }
    public No noMaisADireita(No no){
        No temp=no;
        while(temp.direita!=null){
            temp=temp.direita;
        }
        return temp;
    }
    
    public static No buscaNo(No no,int valor){
        No temp=no;
        if(temp.valor==valor)
            return temp;
        if(valor>temp.valor){
            if(temp.direita==null)
                return null;
            return buscaNo(temp.direita,valor);
        }else{
            if(temp.esquerda==null)
                return null;
            return buscaNo(temp.esquerda,valor);    
        }
    }
    
    public static void exibe1Filho(No temp){
        if(raiz==null){
            System.out.println("Árvore Vazia, impossível exibir inverso");
        }else{
            if(temp!=null){
                if(((temp.esquerda!=null)&&(temp.direita==null))||((temp.esquerda==null)&&(temp.direita!=null))){
                    System.out.println(temp.valor);
                }else{
                    exibe1Filho(temp.esquerda);    
                    exibe1Filho(temp.direita);
                }
            }
        }
    }
    public static void exibeFolhas(No temp){
        if(raiz==null){
            System.out.println("Árvore Vazia, impossível exibir inverso");
        }else{
            if(temp!=null){
                if((temp.esquerda==null)&&(temp.direita==null)){
                    System.out.println(temp.valor);
                }else{
                    exibeFolhas(temp.esquerda);    
                    exibeFolhas(temp.direita);
                }
            }
        }
    }
    public boolean temFilho(No no){
        if((no.direita==null)||(no.esquerda==null))
            return false;
        return true;
    }
    public int contarNos(){
        return contarNos(raiz);
    }
    public int contarNos(No no){
        if(no!=null){
            return 1+contarNos(no.esquerda)+contarNos(no.direita);
        }else{
            return 0;
        }
    }
    
    public void inserir(int valor){
        No novo=new No(valor);
        if(this.raiz==null){
            this.raiz=novo;
//            System.out.println("inserido raiz "+valor);
        }else{
            boolean inseriu=false;
            No temp=raiz;
            while(!inseriu){
                
                if(temp.valor>=valor){
                    if(temp.esquerda==null){
                        temp.esquerda=novo;
                        inseriu=true;
//                        System.out.println("inserido esquerda "+valor);
                    }else{
                        temp=temp.esquerda;
                    }
                }
                else{
                    if(temp.direita==null){
                        temp.direita=novo;
                        inseriu=true;
//                        System.out.println("inserido direita "+valor);
                    }else{
                        temp=temp.direita;
                    }
                }
                
            }
        }
    }

    static void exibeArvore(){
        if(raiz==null)
            System.out.println("Arvore Vazia...");
        else
            exibeNo(raiz,0);
    }
    
    static void exibeNo(No no, int x){

      if(no.direita!=null)
          exibeNo(no.direita, x+1);
      else
          System.out.println();

      for(int i=1; i<=x; i++)
          System.out.print("|  ");

      if((no.esquerda == null)&&(no.direita == null))
          System.out.print("["+no.valor+"]");
      else
          System.out.print(no.valor);

      if(no.esquerda != null)
          exibeNo(no.esquerda, x+1);
      else
          System.out.println();
    }
    
    public static void exibeOrdenado(No no){
        if(raiz==null){
            System.out.println("Árvore Vazia, impossível exibir ordenado");
        }else{
            if(no!=null){
                exibeOrdenado(no.esquerda);
                System.out.println(no.valor);
                exibeOrdenado(no.direita);
            }
        }
    }
    public static void exibeInverso(No no){
       if(raiz==null){
            System.out.println("Árvore Vazia, impossível exibir inverso");
        }else{
            if(no!=null){
                exibeInverso(no.direita);
                System.out.println(no.valor);
                exibeInverso(no.esquerda);
            }
        }
    }
    public static int profundidade(No temp){
        if(temp==null){
            return 0;
        }if((temp.esquerda==null)&&(temp.direita==null)){
            return 0;
        }
        return 1+maior(profundidade(temp.esquerda),profundidade(temp.direita));
    }
    public static int profundidadeEsq(No temp){
        temp=temp.esquerda;
        if(temp==null){
            return 0;
        }if((temp.esquerda==null)&&(temp.direita==null)){
            return 0;
        }
        return 1+maior(profundidade(temp.esquerda),profundidade(temp.direita));
    }
    public static int profundidadeDir(No temp){
        temp=temp.direita;
        if(temp==null){
            return 0;
        }if((temp.esquerda==null)&&(temp.direita==null)){
            return 0;
        }
        return 1+maior(profundidade(temp.esquerda),profundidade(temp.direita));
    }
    public static int maior(int a,int b){
        if(a>b){
            return a;
        }else{
            return b;
        }
    }
}
