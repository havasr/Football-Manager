package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TeamService {

public Team createTeam(String teamName, String nickname, String colors, String coach, String president, String stadiumName,
                       BigDecimal budget, Currency currency, String country){

  Team team = new Team();
  team.setName(teamName);
  team.setNickname(nickname);
  team.setColors(colors);
  team.setCoach(coach);
  team.setPresident(president);
  team.setStadiumName(stadiumName);
  team.setBudget(budget);
  team.setCurrency(currency);
  team.setCountry(country);

    return team;
}

public void addAwardToTeam(Team team, String awardName, int year, AwardTypeEnum awardTypeEnum, AwardCategory awardCategory){


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

}


}
