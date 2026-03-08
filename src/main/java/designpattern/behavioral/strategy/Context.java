package designpattern.behavioral.strategy;

public class Context {
    Strategy strategy;

   public Context(Strategy strategy){
        this.strategy=strategy;
    }

    public int executeStrategy(int a,int b){
      return strategy.doOps(a,b);
    }
}

//context will be passed along with strategy that need to be used

//in state design pattern state will be set based on the behaviour/method need to called
