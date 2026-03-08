package designpattern.behavioral.interpreter;

public class InterpreterApplication {

    public static Expression getMaleExpression(){
        Expression exp1=new TerminalExpression("kk");
        Expression exp2=new TerminalExpression("singh");
       return new OrExpression(exp1,exp2);

    }
}
