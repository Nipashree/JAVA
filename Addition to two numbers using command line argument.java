class mycalculator
{
    private int a,b,c;
    mycalculator(int x, int y)
    {
        this.a = x;
        this.b = y; 
    }
    public void addmethod()
    {
        c = a+b;
        System.out.println("Addition: "+c);
    }   
}

public class cmdLineArg_1 
{
    public static void main(String [] args)
    {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
       
        mycalculator obj = new mycalculator(num1, num2);
        obj.addmethod();
    }
}
