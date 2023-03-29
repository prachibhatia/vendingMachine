package org.example.vendingMachine;

import org.example.vendingMachine.models.*;
import org.example.vendingMachine.vendingStates.State;

import java.util.List;

public class VendingCell {
    public static void main(String[] args) throws Exception {
        VendingMachine vendingMachine = new VendingMachine(10);
        System.out.println("|");
        System.out.println("filling up the inventory");
        System.out.println("|");

        fillUpInventory(vendingMachine);
        displayInventory(vendingMachine);

        System.out.println("|");
        System.out.println("clicking on Select Product");
        System.out.println("|");

        State vendingState = vendingMachine.getVendingState();
        vendingState.clickOnSelectProductButton(vendingMachine);

        vendingState = vendingMachine.getVendingState();

        vendingState.chooseProduct(vendingMachine,101);
        vendingState.clickOnInsertCoinButton(vendingMachine);

        vendingState = vendingMachine.getVendingState();

        vendingState.insertCoin(vendingMachine, Coin.DIME);
        vendingState.insertCoin(vendingMachine, Coin.NICKEL);

        vendingState = vendingMachine.getVendingState();

        vendingState.dispenseProduct(vendingMachine);
        displayInventory(vendingMachine);
    }
    private static void fillUpInventory(VendingMachine vendingMachine){
        List<ItemShelf> itemShelfList = vendingMachine.getItemShelfList();
        for (int i = 0; i < itemShelfList.size(); i++) {
            Item newItem = new Item();
            if(i >=0 && i<3) {
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i >=3 && i<5){
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(9);
            }else if(i >=5 && i<7){
                newItem.setItemType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i >=7 && i<10){
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(7);
            }
            itemShelfList.get(i).setItem(newItem);
            itemShelfList.get(i).setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        List<ItemShelf> itemShelfList = vendingMachine.getItemShelfList();
        for (int i = 0; i < itemShelfList.size(); i++) {

            System.out.println("CodeNumber: " + itemShelfList.get(i).getCode() +
                    " Item: " + itemShelfList.get(i).getItem().getItemType().name() +
                    " Price: " + itemShelfList.get(i).getItem().getPrice() +
                    " isAvailable: " + !itemShelfList.get(i).isSoldOut());
        }
    }

}
