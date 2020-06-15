import View.Map;
import Models.Fish;
public class Program {
    public static void newLevel(int count)
    {
        
    }
    public static void main(String[] avgs)
    {
        Map m=new Map();
        Fish f1=new Fish('s',1,1);
        Fish f2=new Fish('m',3,3);
        Fish f3=new Fish('b',2,2);
        m.add(f1);
        m.add(f2);
        m.add(f3);
        m.show();
    }
}
