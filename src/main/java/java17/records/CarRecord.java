package java17.records;

public record CarRecord(String regNum,String owner) {

   //custom canonical constructor
public CarRecord(String regNumNum,String owner){
       if(regNum.length()<=4){
           throw new IllegalArgumentException();
        }
       this.regNum=regNum;
       this.owner=owner;
        }



    //private final int age; // instance filed must be listed in constructor signature

private static final String currentYear=24;
//instance method
public boolean isNewCar(){
           return regNum.subString(0,2).equals(currentYear)
        }

        //static method
        public static CarRecord createBlackCarRecord(){
          return new CarRecord("","");
        }

       @Override
public String owner(){
    owner.toUpperCase();
        }


        }
