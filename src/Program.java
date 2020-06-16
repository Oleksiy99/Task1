import Controllers.Controller;
import View.Map;
import Models.Fish;
public class Program {
    public static Map newLevel(Map map, int count)
    {
        switch (count)
        {
            case 1: // перший рівень
                map.add(new Fish('s',0,0));
                map.add(new Fish('m',0,2));
                map.add(new Fish('b',0,4));
                break;
            case 2:
                map.add(new Fish('m',0,0));
                map.add(new Fish('b',0,3));
                map.add(new Fish('s',1,3));
                break;
            case 3:
                map.add(new Fish('m',0,0));
                map.add(new Fish('s',1,0));
                map.add(new Fish('b',0,3));
                map.add(new Fish('b',1,3));
                map.add(new Fish('b',2,3));
                break;
            case 4:
                map.add(new Fish('s',0,0));
                map.add(new Fish('s',0,1));
                map.add(new Fish('m',0,3));
                break;
            case 5:
                map.add(new Fish('m',0,1));
                map.add(new Fish('m',0,2));
                map.add(new Fish('b',0,4));
                break;
        }
        return map;
    }
    public static void main(String[] avgs)
    {
        Map m=new Map();
        newLevel(m, 5); // перший рівень
        m.show();

        // тетив контроллер
        Controller c = new Controller();
        c.setGunPosition(1);
        c.getFish(m);
    }
}
