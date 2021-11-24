package dtos;

import dtos.utils.Name;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

@Getter
@Setter
public class House {
    private int years;
    private String favoriteColor;
    private Name name;
    private ArrayList<Integer> roomsSizes;
    private HashMap<Integer, String> map;
    private Calendar buildDate;
    private byte[] parks;
    private char symb;

    private House(ArrayList<Integer> list, int years, String favoriteColor, Name country) {
        this.years = years;
        this.favoriteColor = favoriteColor;
        this.name = country;
        this.roomsSizes = list;
    }

    private House() {
    }

}
