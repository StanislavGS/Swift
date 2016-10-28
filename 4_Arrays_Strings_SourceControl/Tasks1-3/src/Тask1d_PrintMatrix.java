/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Stanislav Stanislavov
 */
public class Тask1d_PrintMatrix {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        //int n=9;
        int[][] task1d = new int[n][n];
        
        
        //Първи вариант /first way
        /*        
        int squareLevel,maxPrevois;
        for (int i = 0; i < task1d.length; i++) {
            for (int j = 0; j < task1d[i].length; j++) {
                // Определя в кой вложен квадрат се намира
                squareLevel=Integer.min(Integer.min(i,j),Integer.min(n-i-1,n-j-1));
                
                //Определя максималния елемент на предишния вложен квадрат
                maxPrevois=4*squareLevel*(n-squareLevel);
                
                //Според това на коя страна на квадрата се намира изчислява елемента
                if(i==squareLevel){
                    task1d[i][j]=maxPrevois+j-squareLevel+1;
                }else if(n-j-1==squareLevel){
                    task1d[i][j]=maxPrevois+(n-2*squareLevel)+i-squareLevel;
                }else if(n-i-1==squareLevel){
                    task1d[i][j]=maxPrevois+2*(n-2*squareLevel)-2+n-j-squareLevel;
                }else {
                    task1d[i][j]=maxPrevois+3*(n-2*squareLevel)-3+n-i-squareLevel;
                }
                
                System.out.printf("%3d ", task1d[i][j]);
            }
            System.out.println();
        }
        
        */
        
        //Понеже втория вариант (който е най отдолу не ме кефи много)
        //Направих 3-ти вариант /Third way
        // между другото и трите работят

        byte direction=0;int i=0,j=0,step=0;
        for (int ii=1;ii<=n*n;ii++){
            task1d[i][j]=ii;
            switch (direction){
                case 0:if (j<n-step-1){
                        j++;
                       }else{
                        direction=1;i++;
                       }
                       break;
                case 1:if (i<n-step-1){
                        i++;
                       }else{
                        direction=2;j--;
                       }
                       break;
                case 2:if (j>step){
                        j--;
                       }else{
                        direction=3;i--;
                       }
                       break;
                case 3:if (i>step+1){
                        i--;
                       }else{
                        direction=0;step++;j++;
                       }
                       break;                       
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.printf("%3d ", task1d[i][j]);
            }
            System.out.println();
        }
        
        //Втори начин /Second way
        /*
        int i=0,j=0,counter=1,sqareNumber=1;
        task1d[i][j]=counter;
        while (sqareNumber<(int) (n+1)/2+1){
            //if (sqareNumber==(int) (n+1)/2){ task1d[i][j]=++counter;break;}
            if (i==sqareNumber && j==sqareNumber-1){
                j++;sqareNumber++;
                if(sqareNumber==(int) (n+1)/2+1 && n%2==0) break; 
            }else if(i==sqareNumber-1 && j<n-sqareNumber){
                j++;
            }else if(i<n-sqareNumber && j==n-sqareNumber){
                i++;
            }else if(i==n-sqareNumber && j>sqareNumber-1){
                j--;
            }else if(i>sqareNumber-1 && j==sqareNumber-1){
                i--;
            }else{
                 break;
            }
            task1d[i][j]=++counter;
        }        
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.printf("%3d ", task1d[i][j]);
            }
            System.out.println();
        }
        */
        
    }
}
