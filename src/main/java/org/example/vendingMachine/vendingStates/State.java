package org.example.vendingMachine.vendingStates;

import org.example.vendingMachine.models.Coin;
import org.example.vendingMachine.models.Item;
import org.example.vendingMachine.models.VendingMachine;

import java.util.List;

public interface State {
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception;
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
    public void insertCoin(VendingMachine machine , Coin coin) throws Exception;

    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception;

    public int getChange(int returnChangeMoney) throws Exception;

    public Item dispenseProduct(VendingMachine machine) throws Exception;

    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception;

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception;


}
