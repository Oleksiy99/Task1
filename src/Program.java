import Controllers.Controller;
import View.Map;
import Models.Fish;
public class Program {
    public static Map newLevel(Map map, int count)
    {
        switch (count)
        {
            case 1:
                map.addFish(new Fish('s',0,0));
                map.addFish(new Fish('m',0,2));
                map.addFish(new Fish('b',0,4));
                break;
            case 2:
                map.addFish(new Fish('m',0,0));
                map.addFish(new Fish('b',0,3));
                map.addFish(new Fish('s',1,3));
                break;
            case 3:
                map.addFish(new Fish('m',0,0));
                map.addFish(new Fish('s',1,0));
                map.addFish(new Fish('b',0,3));
                map.addFish(new Fish('b',1,3));
                map.addFish(new Fish('b',2,3));
                break;
            case 4:
                map.addFish(new Fish('s',0,0));
                map.addFish(new Fish('s',0,1));
                map.addFish(new Fish('m',0,3));
                break;
            case 5:
                map.addFish(new Fish('m',0,1));
                map.addFish(new Fish('m',0,2));
                map.addFish(new Fish('b',0,4));
                break;
        }
        return map;
    }
    public static void main(String[] avgs)
    {
        Controller controller = new Controller();
        Map map;
        while (true)
        {
            map=newLevel(new Map(), (int)Math.random()*5+1);
            while (true)
            {
                map.show();
                controller.show();
                controller.work(map);
            }
        }
    }
}
