
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public class Task1c_PrintMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        //int n = 6;
        
        int[][] task1c = new int[n][n];

        //Първи вариант(First way)

        //Знам че не трябваше да използувам ?: но ми се наложи на два пъти/I know I was not supposed to use?: But I had twice
        //Иначе кода щеше да се удължи с още 10-тина реда/Otherwise, the code would be extended by another 10-rows
        //Надявам се да ме извиниш./ I hope you forgive me
        //Този подход е по скоро математически отколкото инженерен/This approach is more mathematical than engineering
        //Основната идея е че смята на кой подред диагонал се намира -> i+j/ The basic idea is that considered a diagonal who is -> i + j
        //След това изчислява най голямото число на предишния диягонал - prevoiseDiagonalMaxValue / Then calculates the largest number of previous diyagonal - prevoiseDiagonalMaxValue
        //Изчислява и дължината на текущия диагонал - lengthCurrentDiagonal /  Calculate the length of the current diagonal - lengthCurrentDiagonal
        //и по тези данни изчислява числото на позиция i и j / And this data calculates the number of the item i and j 
        //Формулите изглеждат малко сложни но са верни - повярвай ми, извел съм ги математически / Formulas seem a little complicated but true - believe me, I brought them mathematically
        //Недостатъците на този вариант са многото сметки / The disadvantages of this option are many calculations 
        //Предимствата му са , че всичко става само във 2 вложени цикъла /  Its advantages are that it is only in two nested loops
        for (int i = 0; i < task1c.length; i++) {
            for (int j = 0; j < task1c[i].length; j++) {
                int prevoiseDiagonalMaxValue = (i + j > n) ? n * (n + 1) / 2 + (i + j - n) * n - (i + j - n) * (i + j - n + 1) / 2 : (i + j) * (i + j + 1) / 2;
                int lengthCurrentDiagonal = (i + j >= n) ? 2 * n - i - j - 1 : i + j + 1;
                if ((i + j) % 2 == 0) {
                    if ((i + j) >= n) {
                        task1c[i][j] = prevoiseDiagonalMaxValue + lengthCurrentDiagonal + j - n + 1;
                    } else {
                        task1c[i][j] = prevoiseDiagonalMaxValue + lengthCurrentDiagonal - i;
                    }
                } else {
                    if ((i + j) >= n) {
                        task1c[i][j] = prevoiseDiagonalMaxValue + n - j;
                    } else {
                        task1c[i][j] = prevoiseDiagonalMaxValue + i + 1;
                    }
                }
                System.out.printf("%3d ", task1c[i][j]);
            }
            System.out.println();
        }

        /*
        //Втори вариант (Second way)
        //Този подход е изцяло итерационен / This way is fully iteration
        
        boolean upRightDirection=true,isEnd=false;        
        task1c[0][0]=1;
        int i=0,j=0,counter=1;
        while (!isEnd){
            if (upRightDirection){
                if (i>0&&j<n-1){
                    i--;j++;                        
                } else if (j==n-1){
                    if (i==n-1){
                        isEnd=true;
                    }else{
                        i++;upRightDirection=!upRightDirection;
                    }
                } else{
                    j++;upRightDirection=!upRightDirection;
                }
            }else{
                if (i<n -1&&j>0){
                    i++;j--;                        
                } else if (i==n-1){
                    if (j==n-1){
                        isEnd=true;
                    }else{
                        j++;upRightDirection=!upRightDirection;
                    }
                } else{
                    i++;upRightDirection=!upRightDirection;
                }
            }
            
            if (!isEnd) {task1c[i][j]=++counter;}
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.printf("%3d ", task1c[i][j]);
            }
            System.out.println();
        }
        // Край на втори вариант / End of the second way
        */
    }
    
    
}
