package designpattern.solid.Liskov;

public class LoanCloserService {
    SecureLoad secureLoad;

    public LoanCloserService(SecureLoad secureLoad){
        this.secureLoad=secureLoad;
    }
    public void secureLoan(){
        secureLoad.forceClose();;
    }
}
