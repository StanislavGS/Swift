/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Veneer {
    private int x,y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    Veneer(int x, int y){
        this.x=x;
        this.y=y;       
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Veneer){
        return this.x==((Veneer) o).getX() && this.y==((Veneer) o).getY();
        }else{
            return false;
        }
    }
    
}
