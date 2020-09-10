import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sanan
 */
public class DrawClassDiagram extends JPanel{
    
        int x=120;
        int oddx=900;
        int y= 20;
        int oddy=20;
     
    
    
    
    ArrayList<String> fileTypes = new ArrayList<>(); // to store file Types
    ArrayList<String> fileNames = new ArrayList<>(); // to store file Names
    
    
    ArrayList<String> methodNames = new ArrayList<>();//stores method names
    ArrayList<String> methodTypes = new ArrayList<>() ;// stores method types
          ArrayList<String> methodReturn = new ArrayList<>();
    
      ArrayList<String> variableNames = new ArrayList<>(); //stores variable names
      ArrayList<String> variableTypes = new ArrayList<>();// stores variable types
         ArrayList<String> variableReturn = new ArrayList<>();
      
      ArrayList<Integer> fileRecordVariables = new ArrayList<>(); // to store class number for variables.
      ArrayList<Integer> fileRecordMethods =new ArrayList<>(); // to store class number for methods.
      
      ArrayList<String> compositionRelationWith = new ArrayList<>(); // class to which composition is with.
      ArrayList<String> compositionRelationHas = new ArrayList<>(); // in which variable lies.
      
      
      ArrayList<String> aggregationRelationWith = new ArrayList<>(); // class to which aggregation is with.
      ArrayList<String> aggregationRelationHas = new ArrayList<>(); //class in which the Array lies.
      
      ArrayList<String> generalizationParent = new ArrayList<>(); // class which is parent.
      ArrayList<String> generalizationChild = new ArrayList<> (); // class which is child.
      
      
    JFrame frame;
    JTextArea textArea;
    JScrollPane scroll;
    JScrollPane scroll2;
    
    String result="";
    String relations="";
    
    String space="";

    
    public DrawClassDiagram(ArrayList<String> fileTypes,ArrayList<String> fileNames,ArrayList<String> methodReturn,ArrayList<String> methodNames,ArrayList<String> variableReturn,ArrayList<String> variableNames,ArrayList<Integer> fileRecordMethods,ArrayList<Integer> fileRecordVariables,ArrayList<String> compositionRelationWith,ArrayList<String> compositionRelationHas,ArrayList<String> aggregationRelationWith,ArrayList<String> aggregationRelationHas,ArrayList<String> generalizationParent,ArrayList<String> generalizationChild){
       
        frame =new JFrame();
        frame.setLayout(new BorderLayout());
        this.setLayout(new BorderLayout());
        
        this.setPreferredSize(new Dimension(50000,50000));
 
       
    
  
        frame.setSize(500000, 500000);
        
        
        scroll = new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        frame.add(scroll,BorderLayout.CENTER);
        
  
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      
      this.fileTypes = fileTypes;
      this.fileNames =fileNames;
      
   
      this.methodNames = methodNames;
      this.methodReturn = methodReturn; 
    
      this.variableNames = variableNames;
      this.variableReturn = variableReturn;
      
      this.fileRecordMethods = fileRecordMethods;
      this.fileRecordVariables = fileRecordVariables;
        
      this.compositionRelationWith = compositionRelationWith;
      this.compositionRelationHas = compositionRelationHas;
      
      this.aggregationRelationWith = aggregationRelationWith;
      this.aggregationRelationHas = aggregationRelationHas;
      
      this.generalizationParent = generalizationParent;
      this.generalizationChild = generalizationChild;
      
    
    }
   
    
    @Override
    public void paintComponent(Graphics g){  // This function is used to draw box for each class.
    
       super.paintComponent(g);
     
        
        
        for(int i=0; i < fileNames.size() ; i++){
        
                
           
           for(int j=0; j < fileRecordVariables.size() ; j++){ // for variable
           
                if(j == 0){
                   
         
                 result = result + "               "+fileNames.get(i).toUpperCase()+" CLASS\n";

                }
               
               
           if(i == fileRecordVariables.get(j)){
           
           result = result+"\n"+variableNames.get(j)+": "+variableReturn.get(j);

          }
           
           } // variable loop ends here.
           
           result= result+"\n\n__________________________________________________________________";
           result = result+"\n\n";
           
           for(int j=0; j < fileRecordMethods.size() ; j++){ // for method
           
           if(i == fileRecordMethods.get(j)){
           
           
               result = result+"\n"+methodNames.get(j)+": "+methodReturn.get(j);
                 
           
          }
           
           } // method loop ends here.
     
        if(i%2 == 0){
     
           textArea = new JTextArea();
           textArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3));
           textArea.setBounds(x, y, 300, 300);
           this.add(textArea);
            this.repaint();
           textArea.setText(result);
            result="";
           
           
           y=y+400;
 }    
        else if(i%2 != 0 ){
     
           textArea = new JTextArea();
           textArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3));
           textArea.setBounds(oddx, oddy, 300, 300);
           this.add(textArea);
            this.repaint();
           textArea.setText(result);
            result="";
           
           
           oddy= oddy+400;     
     
     
 }           
        } // outer loop ends here.    
                 
   
        // Now, display Relations.
        
        
          for(int i=0; i < compositionRelationWith.size() ; i++){
            
            if(i == 0){
                
                relations= relations+"    \n\nCOMPOSITION RELATIONS:\n\n";
                
            }
            
            relations= relations+compositionRelationWith.get(i)+"<------"+compositionRelationHas.get(i)+"\n";
            
        }
         
          
           relations= relations+"\n\n__________________________________________________________________";
           relations = relations+"\n\n";
          
          for(int i=0; i < aggregationRelationWith.size() ; i++){
            
            if(i == 0){
                
                relations= relations+"    \nAGGREGATION RELATIONS:\n\n";
                
            }
            
            relations= relations+aggregationRelationWith.get(i)+"<------"+aggregationRelationHas.get(i)+"\n";
            
        }
                     relations= relations+"\n\n__________________________________________________________________";
          relations = relations+"\n\n";
          
          for(int i=0; i < generalizationParent.size() ; i++){
            
            if(i == 0){
                
                relations= relations+"    \nGENERALIZATION RELATIONS:\n\n";
                
            }
            
            relations= relations+generalizationParent.get(i)+"<------"+generalizationChild.get(i)+"\n";
            
        }
        
        
        textArea = new JTextArea();
        textArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,3)); 
        textArea.setBounds(x+400, y+30, 300, 500);
             this.add(textArea);
            this.repaint();
           textArea.setText(relations);
                  relations="";
        
                  
                     textArea = new JTextArea(BorderLayout.CENTER); //to draw space at the start
                       textArea.setBounds(oddx, oddy+300, 300, 500);
                          this.add(textArea);
                            textArea.setText(space);
      
                  
                  
                 textArea.setEditable(false);
        
              
        
    }// paint function ends here
    
    
    
    
    
    } // Draw class diagram class ends here.
    
    
  

