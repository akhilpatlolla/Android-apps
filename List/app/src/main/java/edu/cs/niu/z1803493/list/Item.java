/*
Name:  Patlolla Akhil Reddy
Zid : z1803493
filename : Item.java
 */
package edu.cs.niu.z1803493.list;
/**
 * Created by Akhil on 5/2/2017.
 */
public class Item {
    private int id,flag;
    private String name;
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
        this.flag = 0;
    }
    public Item(int id, String name, int flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString()
    {
        return id + " " + name ;
    }
}
