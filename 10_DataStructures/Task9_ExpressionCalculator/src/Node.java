/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Node {
    private int operation;//type and level
    private double argument;
    private Node nextNode;
    private Node prevoisNode;
    
    public int getOperation(){
        return this.operation;
    }    
    public void setOperation(int operation){
        this.operation=operation;                
    }
    public double getArgument(){
        return this.argument;
    }    
    public void setArgument(double argument){
        this.argument=argument;                
    }
    public Node getNextNode(){
        return this.nextNode;
    }    
    public void setNextNode(Node nextNode){
        this.nextNode=nextNode;                
    }
    public Node getPrevoisNode(){
        return this.prevoisNode;
    }    
    public void setPrevoisNode(Node prevosNode){
        this.prevoisNode=prevosNode;                
    }
    
    Node(int operation,double argument,Node prevosNode){
        this.setOperation(operation);
        this.setArgument(argument);
        this.setPrevoisNode(prevosNode);
        this.setNextNode(null);
    }
}
