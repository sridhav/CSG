
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sridhar
 */
public class l2 {

    /**
     * @param args the command line arguments
     * 
     * 1. S->BAYD
     * 2. ZA->aAZ
     * 3. Za->aZ
     * 4. ZD->AAYD
     * 5. aY->Ya
     * 6. AY->YA
     * 7. BY->BZ
     * 8. YD->X
     * 9. aX->Xa
     * 10. AX->Xa
     * 11. BX->eps
     * 
     * 
     */
    private static String[] productions=null;
    public static void main(String[] args) {
        // TODO code application logic here
        int inp=0;
        if(args.length!=1){
            System.out.println("l2 <i-value>");
            System.exit(1);
        }
        else{
            inp=Integer.parseInt(args[0]);
        }
        
        if(inp<=0){
            System.out.println("Invalid Input");
		return;
        }
        
        productions=buildProductionArray();
        System.out.println("Input(i) Value :"+inp);
        System.out.println("Generation\tProductions\n");
        
        String out="BAYD";
        
            display(out.toCharArray(),0);
            for(int i=0;i<inp-1;i++){
                out=LangIterator(out);
                //System.out.println(out);
            }
           
            
            int j=out.length()-1;
                if(out.charAt(j)=='D' && out.charAt(j-1)=='Y'){

                        String temp2=new String(out);
                        String pre=temp2.substring(0, j-1);
                        String mid="X";
                        String post=temp2.substring(j+1);
                        temp2=pre+mid+post;
                        
                        out=temp2;
                        display(out.toCharArray(),7);
                }
                
            
            j=out.length()-1;
             char[] outp=out.toCharArray();
            while(true){
               
                if(outp[j]=='X'){
                    if(outp[j-1]=='A'){
                       char temp='a';
                       outp[j-1]=outp[j];
                       outp[j]=temp;
                       display(outp,9);
                    }
                    if(outp[j-1]=='a'){
                       char temp='a';
                       outp[j-1]=outp[j];
                       outp[j]=temp;
                       display(outp,8);
                    }
                    
                }
                j--;
                if(j==0){
                    break;
                }
                
            }
                
                
             out=new String(outp);   
              
             outp=out.toCharArray();
             if(outp[0]=='B' && outp[1]=='X'){
                 out=out.substring(2);
                 display(out.toCharArray(),10);
             }
             
            // System.out.println(out);
            System.out.println("String length : "+out.length());
                    
        
    }

    private static void display(char[] outp,int i) {
        String outs=new String(outp);
        System.out.print(outs+"\t\t");
        System.out.println(productions[i]);
    
    }
    
    
    private static String LangIterator(String out){
        char[] outp=out.toCharArray();
       
            int j=outp.length-1;
            while(outp[1]!='Y'){
                    if(outp[j-1]=='A'){
                      if(outp[j]=='Y'){
                         char temp=outp[j-1];
                         outp[j-1]=outp[j];
                         outp[j]=temp;
                         display(outp,5);
           
                         }
                      
                    }
                    if(outp[j-1]=='a'){
                      if(outp[j]=='Y'){
                         char temp=outp[j-1];
                         outp[j-1]=outp[j];
                         outp[j]=temp;
                         display(outp,4);
           
                         }
                      
                    }
 
                    j--;
                    if(j==0){
                        break;
                    }
            }
            
            outp[1]='Z';
            display(outp,6);
            j=1; 
            while(true){ 
                
                if(outp[j-1]=='Z' && outp[j]=='a'){
                    char temp=outp[j-1];
                    outp[j-1]=outp[j];
                    outp[j]=temp;
                    display(outp,2);
                }
                if(outp[j-1]=='Z' && outp[j]=='A'){
                    String temp2=new String(outp);
                    String pre=temp2.substring(0, j-1);
                    String mid="aAZ";
                    String post=temp2.substring(j+1);
                    
                    temp2=pre+mid+post;
                    outp=temp2.toCharArray();
                    display(outp,1);
                }
                j++;
               
                if(j==(outp.length)){
                    break;
                }
                
            }
            j=1;
            while(true){
                if(outp[j-1]=='Z' && outp[j]=='D'){
                    String temp2=new String(outp);
                    String pre=temp2.substring(0, j-1);
                    String mid="AAYD";
                    String post=temp2.substring(j+1);
                    temp2=pre+mid+post;
                    outp=temp2.toCharArray();                    
                    display(outp,3);
                }
                 j++;
               
                if(j==(outp.length)){
                    break;
                }
                
                
            }
    return new String(outp);
}
    
    private static String[] buildProductionArray(){
        String[] productions={"S->BAYD","ZA->aAZ","Za->aZ","ZD->AAYD","aY->Ya","AY->YA","BY->BZ","YD->X","aX->Xa","AX->Xa","BX->eps"};
        return productions;
    }
    
}
