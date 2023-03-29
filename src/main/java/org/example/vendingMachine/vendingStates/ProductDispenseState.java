package org.example.vendingMachine.vendingStates;

import org.example.vendingMachine.models.Coin;
import org.example.vendingMachine.models.Item;
import org.example.vendingMachine.models.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class ProductDispenseState implements State{
    @Override
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {

    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {

    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = machine.getChosenProduct();
        machine.setVendingState(new IdleState(machine));
        return item;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("refund can not be happen in Dispense state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory can not be updated in dispensing state");
    }
}
