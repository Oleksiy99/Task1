package Controllers;

import Models.Fish;
import View.Map;

public class Controller {
    private int gunPosition; // позиція взяття рибки або викидання риби (0-5)
    private Fish fish; // риби яка зараз захопленна, якщо не захопленна null

    public void setGunPosition(int gunPosition) {
        this.gunPosition = gunPosition;
    }

    /* бере рибку з позиції gunPosition
    ҉ ҉ ҉ ҉ ҉ ҉
    ҉ s ҉ ҉ ҉ ҉
    ҉ ҉ b ҉ ҉ ҉
    ҉ ҉ ҉ m ҉ ҉
    ҉ ҉ ҉ ҉ ҉ ҉
    ҉ ҉ ҉ ҉ ҉ ҉
    якщо gunPosition = 1 візьме "s"
    Поки показує перший символ який знайде, але має брати рибу треба дописати клас карти щоб там буои риби */
    public Fish getFish(Map map)
    {
        char[][] temp = map.getMap();

        for (int i = 5; i >= 0; i--)
        {
            if (temp[i][gunPosition] != '\u0489') {
                System.out.println(temp[i][gunPosition]);
                // Взяти рибу
                break;
            }
        }
        return fish;
    }

    // По позиції випльовує рибу, поки просто знаходить найближчу, треба карту дописати
    public void outFish(Map map)
    {
        char[][] temp = map.getMap();

        for (int i = 5; i >= 0; i--)
        {
            if (temp[i][gunPosition] != '\u0489') {
                System.out.println(temp[i][gunPosition]);
                // Накормити рибу або лопнути
                break;
            }
        }
    }
}
