package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject {
    private double myDoubleT;
    private double myOtherDoubleT;
    private float myFloatT;
    private short myShortT;
    private char myCharT;

    public MyAllTypesSecond() {
        myDoubleT = 0;
        myOtherDoubleT = 0;
        myFloatT = 0;
        myShortT = 0;
    }

    public MyAllTypesSecond(double myDoubleT, double myOtherDoubleT, float myFloatT, short myShortT, char myCharT) {
        this.myDoubleT = myDoubleT;
        this.myOtherDoubleT = myOtherDoubleT;
        this.myFloatT = myFloatT;
        this.myShortT = myShortT;
        this.myCharT = myCharT;
    }

    public double getMyDoubleT() {
        return myDoubleT;
    }

    public void setMyDoubleT(double myDoubleT) {
        this.myDoubleT = myDoubleT;
    }

    public double getMyOtherDoubleT() {
        return myOtherDoubleT;
    }

    public void setMyOtherDoubleT(double myOtherDoubleT) {
        this.myOtherDoubleT = myOtherDoubleT;
    }

    public float getMyFloatT() {
        return myFloatT;
    }

    public void setMyFloatT(float myFloatT) {
        this.myFloatT = myFloatT;
    }

    public short getMyShortT() {
        return myShortT;
    }

    public void setMyShortT(short myShortT) {
        this.myShortT = myShortT;
    }

    public char getMyCharT() {
        return myCharT;
    }

    public void setMyCharT(char myCharT) {
        this.myCharT = myCharT;
    }

    /**
     * overridden equals
     * @param object
     * @return
     */
    public boolean equals(Object object) {
        if (object instanceof MyAllTypesSecond) {
            MyAllTypesSecond second = (MyAllTypesSecond) object;
            return (
                    second.myDoubleT == myDoubleT &&
                    second.myOtherDoubleT == myOtherDoubleT &&
                    second.myFloatT == myFloatT &&
                    second.myShortT == myShortT &&
                    second.myCharT == myCharT
            );
        }
        return false;
    }

    /**
     * overridden toString
     * @return
     */
    public String toString() {
        return "Type: MyAllTypesSecond\n{ " +
                "myDoubleT=" + myDoubleT +
                "\n  myOtherDoubleT=" + myOtherDoubleT +
                "\n  myFloatT=" + myFloatT +
                "\n  myShortT=" + myShortT +
                "\n  myCharT=" + myCharT +
                " }";
    }

    /**
     * hashCode
     * @return
     */
    public int hashCode() {
        return java.util.Objects.hash(myDoubleT, myOtherDoubleT, myFloatT, myShortT, myCharT);
    }

}