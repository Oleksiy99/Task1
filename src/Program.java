import Controllers.Controller;
import View.Map;
import Models.Fish;
public class Program {
    public static void main(String[] avgs)
    {
        Controller controller = new Controller();
        Map map;
        while (true)
        {
            map = controller.newLevel(new Map(), 1);
            while (true)
            {
                map.show();
                controller.show();
                if (controller.work(map) == 1) {
                    System.out.println("Game over!");
                    return;
                }
            }
        }
    }
}
