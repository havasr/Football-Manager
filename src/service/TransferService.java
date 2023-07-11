package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class TransferService {
    CurrencyService currencyService = new CurrencyService();

    public Transfer createTransfer(Team fromTeam, Team newTeam, int transferYear, BigDecimal transferPrice) {

        Transfer transfer = new Transfer();
        transfer.setFromTeam(fromTeam);
        transfer.setToTeam(newTeam);
        transfer.setYear(transferYear);
        transfer.setPrice(transferPrice);

        return transfer;
    }

    public Transfer makeTransfer(Player player, Team newTeam, Transfer transfer) {

        if (newTeam.getBudget().compareTo
                (currencyService.exchange(player.getValue(), player.getCurrency(), newTeam.getCurrency())) >= 0) {
            System.out.println("transfer can be done");
            newTeam.setBudget(newTeam.getBudget().subtract
                    (currencyService.exchange(player.getValue(), player.getCurrency(), newTeam.getCurrency())));
            Team fromTeam = player.getTeamList().get(player.getTeamList().size() - 1);
            fromTeam.setBudget(fromTeam.getBudget().add
                    (currencyService.exchange(player.getValue(), player.getCurrency(), fromTeam.getCurrency())));
            player.getTeamList().add(newTeam);
            transfer.setCurrency(player.getCurrency());

            if (player.getTransferHistory() != null) {
                player.getTransferHistory().add(transfer);
            } else {
                List<Transfer> transferList = new ArrayList<>();
                transferList.add(transfer);
                player.setTransferHistory(transferList);
            }

        } else {
            System.err.println("transfer can not be done because of not enough budget");
        }

        return transfer;
    }


}
