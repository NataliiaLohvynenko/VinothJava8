package lambdaExpression;

public class test {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a+b;
        MathOperation substract = (a, b) -> a-b;
        MathOperation multiply = (a, b) -> a*b;
        MathOperation divide = (a, b) -> a/b;

        int onScreenNumber = 0;

        onScreenNumber = calculate(5,add, 2);
        onScreenNumber = calculate(onScreenNumber,substract,3);
        onScreenNumber = calculate(onScreenNumber, multiply,7);
        onScreenNumber = calculate(onScreenNumber,add,2);
        onScreenNumber = calculate(onScreenNumber,divide,3);

        System.out.println(onScreenNumber);

    }

    private static int calculate(int onScreenNumber, MathOperation mathOperation, int enteredNumber){
        int a= 100;
        int b = 5;
        return mathOperation.operate(a, b);
    }

}
