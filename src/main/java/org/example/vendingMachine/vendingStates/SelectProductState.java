package org.example.vendingMachine.vendingStates;

import org.example.vendingMachine.controllers.VendingMachineController;
import org.example.vendingMachine.models.Coin;
import org.example.vendingMachine.models.Item;
import org.example.vendingMachine.models.VendingMachine;

import java.util.List;

public class SelectProductState implements State{

    public SelectProductState(){
        System.out.println("Currently Vending machine is in Item Selection State");
    }

    @Override
    public void clickOnSelectProductButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        if(machine.getChosenProduct()!=null){
            machine.setVendingState(new AddMoneyState());
        }else{
            throw new Exception("first you need to select the product and then you can pay");
        }
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("first you need to select the product and then you can pay");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        VendingMachineController.chooseItem(machine,codeNumber);
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        return 0;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine) throws Exception {
        return null;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        return null;
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory can not be updated in Selection state");
    }
}
