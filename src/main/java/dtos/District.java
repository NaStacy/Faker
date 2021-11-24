package dtos;

import lombok.Data;

import java.util.*;

@Data
public class District {
    private ArrayList<House> houses;
    private HashMap<Integer, String> owners;
    private HashSet<Long> numbers;
    private ArrayDeque<Long> indexes;
    private TreeMap<Integer, String> garages;
    private Calendar[] closeDates;
}
