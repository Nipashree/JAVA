import java.lang.*;

class base
{
    int b;
    base(){}
    base (int bb)
    {
        //super(gb);
        this.b = bb;
        System.out.println ("\n Base class : b = "+ b);
    }
}

class child1 extends base
{
    int c1;
    child1(){}
    child1 (int bb, int cc)
    {
        super(bb);
        this.c1 = cc;
        System.out.println ("\n Child class : c1 = "+ c1);
    }
}

class child2 extends base
{
    int c2;
    child2(){}
    child2 (int bb, int cc)
    {
        super(bb);
        this.c2 = cc;
        System.out.println ("\n Child class : c1 = "+ c2);
    }
}


public class Main
{
    public static void main(String[] args)
    {
        child1 cobj1 = new child1(10,20);
        child2 cobj2 = new child2(30,40);
    }      
}



