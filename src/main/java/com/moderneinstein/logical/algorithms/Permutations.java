package com.moderneinstein.logical.algorithms  ; 


import java.util.Arrays ; 
import java.util.Vector ; 
import java.util.List ; 
import java.util.Set ;  
import java.util.ArrayList ; 
import java.util.Collection ; 

public class Permutations{

    public static <C> void compute(List<C> present,List<C> source,boolean[] signs,Collection<List<C>> nested){
         if(present.size( )==source.size()){ 
        for(int dy=0;dy<present.size( );dy++){
          //  int[] lines = (int[])present.get(dy ) ;
          //  System.out.println(Arrays.toString(lines)) ;
        }
        nested.add(new Vector<C>(present))  ; 
        return  ; 
         }  
        for(int  fc=0 ;fc<signs.length;fc++){
            if(signs[fc]==false){
                signs[fc] = true  ;
                 present.add(source.get( fc)) ; 
                compute( present,source,signs,nested ) ; 
                signs[fc] = false ; 
                present.remove(present.size()-1) ; 
             }
        }
    }
    public static <S> void  subsets(int phase,List<S> current,List<S> source,List<List<S>> nested){
        if(phase>=source.size()){
            nested.add (new ArrayList<S>(current)) ; 
            return  ; 
        } 
        subsets(phase+1,current,source,nested) ; 
         current.add(source.get(phase)) ; 
        subsets( phase+1,current,source,nested ) ; 
        current.remove(current.size()-1) ; 
    }
    public static <T>  List<List<T>> permute(List<T> input){
        int length  =input.size() ; 
        List<List<T>> created = new Vector<List<T>>( ); 
        List<T> begin =  new ArrayList<T> () ;    
        boolean[] lines = new boolean[length] ;   
        List<T> clone = new ArrayList<T>(input) ; 
       // compute(begin,clone,lines,created) ;  
       subsets(0,begin,clone,created) ;
        return created ;  
    }
}