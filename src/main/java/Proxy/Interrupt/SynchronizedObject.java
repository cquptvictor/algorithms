package Proxy.Interrupt;

public class SynchronizedObject {
    private String name =  "a";
    private String password = "b";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    synchronized public void printString(String a, String b){
        try {
            this.name = a;
            Thread.sleep(1000);
            this.password = b;
        }catch (InterruptedException e){
            System.out.println(Thread.interrupted());
        }
    }
}
