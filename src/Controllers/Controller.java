package Controllers;

import Models.Fish;
import View.Map;

import java.util.Scanner;

public class Controller {
    private int gunPosition;
    private Fish fish;
    private int lvl;


    public Controller() {
        gunPosition = 0;
        fish = null;
        lvl = 1;
    }

    public void setGunPosition(int gunPosition) {
        this.gunPosition = gunPosition;
    }

    public Fish getFish(Map map) {
        char[][] temp = map.getMap();
        for (int i = 5; i >= 0; i--)
        {
            if (temp[i][gunPosition] != '\u0489') {
                fish = map.removeFish(i, gunPosition);
                break;
            }
        }
        return fish;
    }

    public void outFish(Map map) {
        char[][] temp = map.getMap();
        int freePosition=0;
        for (int i = 5; i >= 0; i--)
        {
            if(i == 5 && temp[i][gunPosition] != '\u0489')
                return;
            if (temp[i][gunPosition] == '\u0489')
            {
                freePosition = i;
            }
            else
                break;
        }

        if (freePosition > 0 && Character.toLowerCase(map.getFish(freePosition -  1, gunPosition).getSymbol()) != 's')
        {
            if (Character.toLowerCase(map.getFish(freePosition -  1, gunPosition).getSymbol()) == 'b' && Character.toLowerCase(fish.getSymbol()) == 'm')
            {
                fishWay(map, freePosition);
            }
            else if (Character.toLowerCase(map.getFish(freePosition -  1, gunPosition).getSymbol()) == 'm' && Character.toLowerCase(fish.getSymbol()) == 's')
            {
                fishWay(map, freePosition);
            }
            else
            {
                fish.setCoordX(freePosition);
                fish.setCoordY(gunPosition);
                map.addFish(fish);
            }
        }
        else
        {
            fish.setCoordX(freePosition);
            fish.setCoordY(gunPosition);
            map.addFish(fish);
        }

        fish = null;
    }

    private void fishWay(Map map, int freePosition) {
        if (fish.isFull()){
            // remove
            removeFishWay(map, map.getFish(freePosition -  1, gunPosition).getSymbol());
        }
        else if (!map.getFish(freePosition -  1, gunPosition).isFull()) {
            // update
            map.updateFish(freePosition - 1, gunPosition);
        }
        else {
            // remove
            removeFishWay(map, map.getFish(freePosition -  1, gunPosition).getSymbol());
        }

        map.mapFishRefresh();
    }

    private void removeFishWay(Map map, char fishType) {
        char[][] temp = map.getMap();
        for (int i = 5; i >= 0; i--)
        {
            if (temp[i][gunPosition] != '\u0489') {
                if (Character.toLowerCase(temp[i][gunPosition]) == Character.toLowerCase(fishType)) {
                    // remove
                    map.removeFish(i, gunPosition);
                }
                else {
                    // this is other fish, exit
                    break;
                }
            }
        }
    }

    public void show() {
        for(int i = 0; i < gunPosition; i++)
            System.out.print("  ");
        System.out.print("\u001B[30;2m" + '\u2295');

        if(fish != null)
            Map.showSymbol(fish.getSymbol());
        System.out.println();
    }

    public int work(Map map) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        command = command.toLowerCase();

        if(command.equals("a") && gunPosition != 0) {
            gunPosition--;
        }
        else if(command.equals("d") && gunPosition != 5) {
            gunPosition++;
        }
        else if(command.equals(" ") && fish == null) {
            getFish(map);
        }
        else if(command.equals(" ") && fish != null) {
            outFish(map);
        }
        else if (command.equals("r")) {
            map.mapDefault();
            map.clear();
            newLevel(map, lvl);
            gunPosition = 0;
        }
        else if (command.equals("n")) {
            if (lvl == 5) {
                System.out.println("All levels are complete! Congratulation!");
                return 1;
            }
            else  {
                map.mapDefault();
                map.clear();
                newLevel(map, lvl + 1);
                gunPosition = 0;
            }
        }

        return 0;
    }

    public Map newLevel(Map map, int count)
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
        lvl = count;
        return map;
    }
}
