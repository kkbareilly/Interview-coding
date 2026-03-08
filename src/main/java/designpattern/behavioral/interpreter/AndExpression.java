package designpattern.behavioral.interpreter;

public class AndExpression implements Expression{

    Expression exp1=null;
    Expression exp2=null;

    AndExpression(Expression exp1,Expression exp2){
        this.exp1=exp1;
        this.exp2=exp2;
    }
    @Override
    public boolean interpret(String content) {
        return exp1.interpret(content)&& exp2.interpret(content);
    }
}
