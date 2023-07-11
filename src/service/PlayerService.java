package service;

import model.Currency;
import model.Player;
import model.Team;
import model.Transfer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {


public Player createPlayer(String playerName, String surname, int kitNumber, int birthYear, String position, BigDecimal value, Currency currency) {

    Player player = new Player();
    player.setName(playerName);
    player.setSurname(surname);
    player.setKitNumber(kitNumber);
    player.setBirthYear(birthYear);
    player.setPosition(position);
    player.setValue(value);
    player.setCurrency(currency);

    return player;
}

public void addTeamToPlayer(Player player, Team team){

    if (player.getTeamList()!=null){
        player.getTeamList().add(team);
    } else {
        List<Team> teamList = new ArrayList<>();
        teamList.add(team);
        player.setTeamList(teamList);
    }
}



}

    /*

      Award award = new Award();
  award.setName(awardName);
  award.setYear(year);
  award.setAwardCategory(awardCategory);
  award.setAwardType(awardTypeEnum);

 if (team.getAwards()!=null){
   team.getAwards().add(award);
 } else {
   List<Award> awardList = new ArrayList<>();
   awardList.add(award);
   team.setAwards(awardList);
 }




    yeni oyuncu ekliyoruz
    baslangicta en az bir takim olsun

    ayni metod icin birden fazla takim da eklemeliyim bir oyuncuya

takim gerekiyor

    transfer ettikce de takim bilgisi guncellenecek
     */

