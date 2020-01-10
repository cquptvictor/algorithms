package Proxy;

//静态代理
public class ProxySubject implements Subject{

    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void visit() {
        subject.visit();
    }

    @Override
    public void audit() {

    }
}