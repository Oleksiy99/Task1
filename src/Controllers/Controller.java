package Controllers;

import Models.Fish;
import View.Map;

import java.util.Scanner;

public class Controller {
    private int gunPosition;
    private Fish fish;
    public Controller()
    {
        gunPosition=0;
        fish=null;
    }
    public void setGunPosition(int gunPosition) {
        this.gunPosition = gunPosition;
    }

    public Fish getFish(Map map)
    {
        char[][] temp = map.getMap();

        for (int i = 5; i >= 0; i--)
        {
            if (temp[i][gunPosition] != '\u0489') {
                fish=map.removeFish(i,gunPosition);
                break;
            }
        }
        return fish;
    }

    public void outFish(Map map)
    {
        char[][] temp = map.getMap();
        int freePosition=0;
        for (int i = 5; i >= 0; i--)
        {
            if(i==5&&temp[i][gunPosition] != '\u0489')return;
            if (temp[i][gunPosition] == '\u0489')
            {
                freePosition=i;
            }
            else break;
        }
        fish.setCoordX(freePosition);
        fish.setCoordY(gunPosition);
        map.addFish(fish);
        fish=null;
    }
    public void show()
    {
        for(int i=0;i<gunPosition;i++)
            System.out.print("  ");
        System.out.print("\u001B[30;2m"+'\u2295');
        if(fish!=null)
            Map.showSymbol(fish.getSymbol());
        System.out.println();
    }
    public void work(Map map)
    {
        Scanner scanner=new Scanner(System.in);
        String command=scanner.nextLine();
        command=command.toLowerCase();
        if(command.equals("a")&&gunPosition!=0)
        gunPosition--;
        else if(command.equals("d")&&gunPosition!=5)
            gunPosition++;
        else if(command.equals(" ")&&fish==null)
            getFish(map);
        else if(command.equals(" ")&&fish!=null)
            outFish(map);
    }
}
