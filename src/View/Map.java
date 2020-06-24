package View;
import Models.Fish;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private char[][] map;
    private List<Fish> fishList;

    public Map()
    {
       map = new char[6][6];
       fishList = new ArrayList<Fish>();
       mapDefault();
    }

    public char[][] getMap() {
        return map;
    }

    public void clear() {
        fishList.clear();
    }

    public void mapDefault() {
        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = '\u0489';
            }
        }
    }

    public void show() {
        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                showSymbol(map[i][j]);
            }
            System.out.println();
        }
    }

    public void mapFishRefresh()
    {
        for(Fish fish : fishList) {
            map[fish.getCoordX()][fish.getCoordY()] = fish.getSymbol();
        }
    }

    public static void showSymbol(char symbol) {
        switch (symbol) {
            case 's':
            case 'S':
                System.out.print("\u001B[33;1m"+symbol+" ");
                break;
            case 'm':
            case 'M':
                System.out.print("\u001B[31;1m"+symbol+" ");
                break;
            case 'b':
            case 'B':
                System.out.print("\u001B[34;1m"+symbol+" ");
                break;
            default:  System.out.print("\u001B[96;1m"+symbol+" ");
        }
    }

    public void addFish(Fish f) {
        fishList.add(f);
        map[f.getCoordX()][f.getCoordY()] = f.getSymbol();
    }

    public Fish getFish(int coordX, int coordY) {
        Fish temp = fishList
                .stream()
                .filter(f->f.getCoordY() == coordY && f.getCoordX() == coordX)
                .findFirst()
                .get();
        return temp;
    }

    public void updateFish(int coordX, int coordY) {
        Fish temp = fishList
                .stream()
                .filter(f->f.getCoordY() == coordY && f.getCoordX() == coordX)
                .findFirst()
                .get();
        temp.setFull(true);
    }

    public Fish removeFish(int coordX, int coordY) {
        Fish temp = fishList
                .stream()
                .filter(f->f.getCoordY() == coordY && f.getCoordX() == coordX)
                .findFirst()
                .get();

        fishList.remove(temp);
        map[coordX][coordY] = '\u0489';
        return temp;
    }
}

