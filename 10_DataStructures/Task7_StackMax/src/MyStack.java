/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Stack;
/**
 *
 * @author Stanislav Stanislavov
 */
public class MyStack {
    private Stack<Integer> values;
    private Stack<Integer> maxValue;
    MyStack(){
        this.values=new Stack<>();
        this.maxValue=new Stack<>();
    }
    
    void push(int value){
        values.push(value);
        if(maxValue.empty() || value>maxValue.peek()){
            maxValue.push(value);
        }else{
            maxValue.push(maxValue.peek());
        }
    }
    
    int pop(){
        maxValue.pop();
        return values.pop();
    }
    
    boolean isEmpty(){
        return values.empty();
    }
    
    int max(){
        return maxValue.peek();
    }
}
