package org.example.vendingMachine.models;

import org.example.vendingMachine.vendingStates.IdleState;
import org.example.vendingMachine.vendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State vendingState;
    private List<ItemShelf> itemShelfList;
    private List<Coin> coinList;
    private Item chosenProduct;
    private int slots;

    public VendingMachine(int slots) {
        this.slots = slots;
        itemShelfList = new ArrayList<>();
        vendingState = new IdleState();
        coinList = new ArrayList<>();
        initialEmptyInventory();
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public Item getChosenProduct() {
        return chosenProduct;
    }

    public void setChosenProduct(Item chosenProduct) {
        this.chosenProduct = chosenProduct;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public State getVendingState() {
        return vendingState;
    }

    public void setVendingState(State vendingState) {
        this.vendingState = vendingState;
    }

    public List<ItemShelf> getItemShelfList() {
        return itemShelfList;
    }

    public void setItemShelfList(List<ItemShelf> itemShelfList) {
        this.itemShelfList = itemShelfList;
    }

    public void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < slots; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            itemShelfList.add(space);
            startCode++;
        }
    }

}
