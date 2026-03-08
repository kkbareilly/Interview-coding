package designpattern.behavioral.interpreter;

public class TerminalExpression implements  Expression{

    String data;
    TerminalExpression(String data){
        this.data=data;
    }
    @Override
    public boolean interpret(String content) {
        if(content.contains(data))
            return true;

        return false;
    }
}
