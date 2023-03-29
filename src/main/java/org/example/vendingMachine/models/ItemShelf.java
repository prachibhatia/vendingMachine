package org.example.vendingMachine.models;

public class ItemShelf {
    private int code;
    private Item item;
    boolean soldOut;

    public ItemShelf(){

    }

    public ItemShelf(int code, Item item, boolean soldOut) {
        this.code = code;
        this.item = item;
        this.soldOut = soldOut;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
