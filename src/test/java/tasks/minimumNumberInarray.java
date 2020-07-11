package tasks;

public class minimumNumberInarray {

    public static void main(String[] args) {
        int abc[][]={{99,3,4},{3,4,7},{2,2,9},{9,8,6}};

        int min =abc[0][0];

        for(int i=0; i<abc.length;i++){
            for(int j = 0; j<abc[i].length; j++){
                if(abc[i][j]<min){
                    min = abc[i][j];
                }
            }

        }
        System.out.println(min);
    }
}
