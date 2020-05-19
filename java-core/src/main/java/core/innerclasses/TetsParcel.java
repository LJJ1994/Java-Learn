package main.java.core.innerclasses;

/**
 * @Author: LJJ
 * @Program: java-core
 * @Description:
 * @Create: 2020-04-13 14:58:58
 * @Modified By:
 */

class Parcel {
    private class PConetents implements Contents{
        private int i = 1;
        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination{
        private String label;
        private PDestination(String l){
            label = l;
        }
        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s){
        return new PDestination(s);
    }

    public Contents contents(){
        return new PConetents();
    }
}

class TestParcel{
    public static void main(String[] args) {
        Parcel parcel = new Parcel();
        Contents contents = parcel.contents();
        Destination destination = parcel.destination("home");

        // Parcel.PConetents pConetents = parcel.new PConetents();
    }
}
