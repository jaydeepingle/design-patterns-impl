package genericCheckpointing.util;

/**
 *
 */
public class MyAllTypesFirst extends SerializableObject {
    private int myInt, myOtherInt;
    private String myString;

    private long myLong, myOtherLong;
    private boolean myBool;

    /**
     * Constructor
     */
    public MyAllTypesFirst() {
        myInt = 0;
        myOtherInt = 0;
        myLong = 0;
        myOtherLong = 0;
    }

    /**
     * Parameterized Constructor
     * @param myInt
     * @param myOtherInt
     * @param myLong
     * @param myOtherLong
     * @param myString
     * @param myBool
     */
    public MyAllTypesFirst(int myInt, int myOtherInt, long myLong, long myOtherLong, String myString, boolean myBool) {
        this.myInt = myInt;
        this.myOtherInt = myOtherInt;
        this.myLong = myLong;
        this.myOtherLong = myOtherLong;
        this.myString = myString;
        this.myBool = myBool;
    }

    public int getMyInt() {
        return myInt;
    }

    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public long getMyLong() {
        return myLong;
    }

    public void setMyLong(long myLong) {
        this.myLong = myLong;
    }

    public boolean getMyBool() {
        return myBool;
    }

    public void setMyBool(boolean myBool) {
        this.myBool = myBool;
    }

    public int getMyOtherInt() {
        return myOtherInt;
    }

    public void setMyOtherInt(int myOtherInt) {
        this.myOtherInt = myOtherInt;
    }

    public long getMyOtherLong() {
        return myOtherLong;
    }

    public void setMyOtherLong(long myOtherLong) {
        this.myOtherLong = myOtherLong;
    }

    /**
     * Overridden toString
     */
    public String toString() {
        return "Type: MyAllTypesFirst\n{ " +
                "myInt=" + myInt +
                "\n  myOtherInt=" + myOtherInt +
                "\n  myLong=" + myLong +
                "\n  myOtherLong=" + myOtherLong +
                "\n  myString=" + myString +
                "\n  myBool=" + myBool +
                " }";
    }


    public int hashCode() {
        return java.util.Objects.hash(myInt, myOtherInt, myLong, myOtherLong, myString, myBool);
    }

    /**
     * Overridden equals
     */
    public boolean equals(Object object) {
        if (object instanceof MyAllTypesFirst) {
            MyAllTypesFirst f = (MyAllTypesFirst) object;
            return (
                    f.myInt == myInt &&
                    f.myOtherInt == myOtherInt &&
                    f.myLong == myLong &&
                    f.myOtherLong == myOtherLong &&
                    f.myBool == myBool
            );
        }
        return false;
    }
}