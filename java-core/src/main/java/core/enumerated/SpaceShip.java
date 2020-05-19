package main.java.core.enumerated;

public enum SpaceShip {
    GO,
    HOME,
    MY,
    SON;
    public String toString(){
        String id = name();
        String s = id.substring(1).toLowerCase();
        return id.charAt(0) + s;
    }

    public static void main(String[] args) {
        for (SpaceShip value : SpaceShip.values()) {
            System.out.println(value);
        }
    }
}
