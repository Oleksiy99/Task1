package View;
import Models.Fish;

public class Map {
    private char[][] map;
    public Map()
    {
       map=new char[6][6];
        mapDefault();
    }
    public void mapDefault()
    {
        for(int i=0;i<map.length;i++)
            for(int j=0;j<map[i].length;j++)
                map[i][j]='\u0489';
    }
    public void show()
    {
        for(int i=0;i<map.length;i++) {
            for (int j = 0; j < map[i].length; j++)
            {
                showSymbol(map[i][j]);
            }
            System.out.println();
        }
    }
    private void showSymbol(char symbol)
    {
        switch (symbol)
        {
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
            default:  System.out.print("\u001B[94;1m"+symbol+" ");
        }
    }
    public void add(Fish f)
    {
        map[f.getCoordX()][f.getCoordY()]=f.getSymbol();
    }
}

