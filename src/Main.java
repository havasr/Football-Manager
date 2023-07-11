import model.*;
import service.CurrencyService;
import service.PlayerService;
import service.TeamService;
import service.TransferService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws Exception {


        TeamService teamService = new TeamService();
        PlayerService playerService = new PlayerService();
        TransferService transferService = new TransferService();
        CurrencyService currencyService = new CurrencyService();

        Currency dolar = currencyService.createCurrency("Dolar", 26.08);
        Currency euro = currencyService.createCurrency("Euro", 28.68);
        Currency tl = currencyService.createCurrency("Tl", 1.0);

        Team team = teamService.createTeam("Galatasaray", "GS", "yellow-red",
                "Okan Buruk", "Dursun Özbek", "Nef Arena", new BigDecimal(10000000),
                dolar, "Türkiye");

        System.out.println(team.toString());
        teamService.addAwardToTeam(team, "Champions Cup", 2023,
                AwardTypeEnum.CUP, AwardCategory.INTERNATIONAL);

        System.out.println(team.toString());

        Team team2 = teamService.createTeam("Fenerbahçe", "FB", "yellow-blue",
                "İsmail Kartal", "Ali Koç", "Kadıköy", new BigDecimal(55000000),
                dolar, "Türkiye");


        teamService.addAwardToTeam(team2, "Turkish Cup", 2023,
                AwardTypeEnum.CUP, AwardCategory.NATIONAL);

        teamService.addAwardToTeam(team, "League Cup", 2023,
                AwardTypeEnum.CUP, AwardCategory.NATIONAL);

        System.out.println(team.toString());

        Player player = playerService.createPlayer("Cristiano", "Ronaldo",
                7, 1985, "Forvet", new BigDecimal(35000000), dolar);

        playerService.addTeamToPlayer(player, team);


        Transfer transfer = transferService.createTransfer(team, team2, 2020, BigDecimal.valueOf(35000000));

        Transfer playerTransfer = transferService.makeTransfer(player, team2, transfer);

        playerService.addTeamToPlayer(player, team);
        System.out.println(player.toString());
        transferService.makeTransfer(player, team2, transfer);
        System.out.println(team);
        System.out.println(team2);
        System.out.println(player);
    }

}

/*
(String playerName, String surname, int kitNumber, int birthYear, String position, List<Team> teamList)

public void addTeamToPlayer(Player player, String teamName, String coach, String president,
                            BigDecimal budget, String currency, String country, List<Team> teamList){

hasNext() - input.nextInt();
Scanner yaygin kullanilmayan bir sey

enum

static sinif olarak ulasabiliyorsun ama instance olusturup obje olunca obje uzerinden ulasabiliyorsun


Zate fonskiyonda bir obje olusturuluyor tekrar mainde create etmeye gerek yok Team team = new Team()

 if (team.getAwards()!=null){
   team.getAwards().add(award);
 } else {
   List<Award> awardList = new ArrayList<>();
   awardList.add(award);
   team.setAwards(awardList);
 }

 Null sa yeni liste olusturuyor degilse ustune ekliyor


 Referansini gostermeyim kendisini gostermesini istiyorsan to String()

 Objects.nonNull() != null ile ayni
 */