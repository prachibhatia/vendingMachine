package org.example.vendingMachine.controllers;

import org.example.vendingMachine.models.Coin;
import org.example.vendingMachine.models.Item;
import org.example.vendingMachine.models.ItemShelf;
import org.example.vendingMachine.models.VendingMachine;

public class VendingMachineController {

    public static void addItem(VendingMachine vendingMachine,Item item, int codeNumber) throws Exception {

        for (ItemShelf itemShelf : vendingMachine.getItemShelfList()) {
            if (itemShelf.getCode() == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("already item is present, you can not add item here");
                }
            }
        }
    }

    public static void chooseItem(VendingMachine vendingMachine,int codeNumber) throws Exception {
        for (ItemShelf itemShelf : vendingMachine.getItemShelfList()) {
            if (itemShelf.getCode() == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    throw new Exception("This item is sold out");
                } else {
                    Item item = itemShelf.getItem();
                    itemShelf.setSoldOut(true);
                    vendingMachine.setChosenProduct(item);
                }
            }
        }
    }

    public static void addMoney(VendingMachine vendingMachine, Coin coin) throws Exception {
        vendingMachine.getCoinList().add(coin);
    }

    public static void add(VendingMachine vendingMachine, Coin coin) throws Exception {
        vendingMachine.getCoinList().add(coin);
    }

}
