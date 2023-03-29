package org.example.vendingMachine.vendingStates;

import org.example.vendingMachine.controllers.VendingMachineController;
import org.example.vendingMachine.models.Coin;
import org.example.vendingMachine.models.Item;
import org.example.vendingMachine.models.VendingMachine;

import java.util.List;

public class AddMoneyState implements State{

    int paidByUser;

    public AddMoneyState() {
        paidByUser = 0;
    }

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
        paidByUser = paidByUser + coin.value;
        if(paidByUser<machine.getChosenProduct().getPrice()){
            VendingMachineController.addMoney(machine,coin);
        }else{
            System.out.println("Money Deposited successfully.Any extra money will be dispensed in the dispensing tray with the item");
            machine.setVendingState(new ProductDispenseState());
        }
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        return;
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Extra money will be refunded at the time of dispensing of product");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine) throws Exception {
        throw new Exception("Product cannot be dispensed in add money state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        List<Coin> money = machine.getCoinList();
        machine.setVendingState(new IdleState(machine));
        return money;
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory can not be updated in adding money state");
    }
}
