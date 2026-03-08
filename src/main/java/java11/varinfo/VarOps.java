package java11.varinfo;

public class VarOps {

    var x=20;   //not allowed
    static var=40  //not allowed

    VarOps(var x) //not allowed
     {
         var p=30  //allowed
         p=50   //allowed
          p="we"  //not allowed
     }

     private test(var x) paramter not allowed
     {

     }
}
