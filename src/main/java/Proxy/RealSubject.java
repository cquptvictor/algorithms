package Proxy;

public class RealSubject implements Subject{
    private String name = "byhieg";
    @Override
    public void visit() {
        System.out.println(name);
    }

    @Override
    public void audit() {
        System.out.println("this is audit");
        }
        public void only(){
        System.out.println("This is my own method");
        }
}
