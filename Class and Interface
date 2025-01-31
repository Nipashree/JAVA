class gp
{
    gp() // base class constructor
    {
        System.out.println("GP");
    }
}
interface i // interface for method declaration
{
    void diplay();
}
class child extends gp implements i
{
    child() // child class constructor
    {
        System.out.println("Child");
    }
    public void childmethod()
    {
        display(); // child class method calls the interface method
    }
    public void display() // definition of method which is declared within interface
    {
        System.out.println("Method of Interface");
    }
}
public class interface_1 {
    public static void main(String args[])
    {
        child c = new child();
        c.childmethod();
    }
}
