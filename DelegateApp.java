package com.company.pattern;

public class DelegateApp {
    public static void main(String[] args) {
        Painter p = new Painter();
        p.setG(new Square());
        p.draw();
    A a = new A();
    a.f();
    }
}

class A {
    void f() {
        System.out.println("f()");
    }
}
class B {
    A a = new A();
    void f() {
        a.f();
    }
}
interface G {
    void draw();
}
class Triangle implements G {
    public void draw () {
        System.out.println("Треугольник");
    }
}
class Square implements G {
    public void draw () {
        System.out.println("Квадрат");
    }
}
class Circle implements G {
    public void draw () {
        System.out.println("Круг");
    }
}
class Painter {
G g;
void setG (G a) {
    g = a;
}
void draw () {
    g.draw();
}

}