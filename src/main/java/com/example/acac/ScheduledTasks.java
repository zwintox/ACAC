package com.example.acac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.List;

@Component
public class ScheduledTasks {
    @Autowired
    private AccidentRepository accidentRepository;

    @Scheduled(fixedRate = 5000)
    //@Scheduled(cron = "0 * * * *")

    public void sendMail() throws MessagingException {
        List<List<Accident>> matchedAccidents = accidentRepository.getMatchedAccidents();

        for (List<Accident> accidentPair: matchedAccidents) {
                String DriverFirstName1 = String.format("Förnamn förare: %s", accidentPair.get(0).getDriverFirstName());
                String DriverFirstName2 = String.format("Förnamn förare: %s", accidentPair.get(1).getDriverFirstName());

                LocalDate skadedag1 = accidentPair.get(0).getSkadedag();
                LocalDate skadedag2 = accidentPair.get(1).getSkadedag();

                String Driverlastname1 = String.format("name: %s", accidentPair.get(0).getDriverLastName());
                String Driverlastname2 = String.format("name: %s", accidentPair.get(1).getDriverLastName());

            String DriverPersonalID1 = String.format("name: %s", accidentPair.get(0).getDriverPersonalID());
            String DriverPersonalID2 = String.format("name: %s", accidentPair.get(1).getDriverPersonalID());

            String DriverPhoneNumber1= String.format("name: %s", accidentPair.get(0).getDriverPhoneNumber());
            String DriverPhoneNumber2 = String.format("name: %s", accidentPair.get(1).getDriverPhoneNumber());

            String Fösäkringsbolag1 = String.format("name: %s", accidentPair.get(0).getFörsäkringsbolag());
            String Fösäkringsbolag2 = String.format("name: %s", accidentPair.get(1).getFörsäkringsbolag());

            String Händelseförlopp1 = String.format("name: %s", accidentPair.get(0).getHändelseförlopp());
            String Händelseförlopp2 = String.format("name: %s", accidentPair.get(1).getHändelseförlopp());

            String Omständighet1 = String.format("name: %s", accidentPair.get(0).getOmständighet());
            String Omständighet2 = String.format("name: %s", accidentPair.get(1).getOmständighet());

            String PolisPåPlats1 = String.format("name: %s", accidentPair.get(0).getPolisPåPlats());
            String PolisPåPlats2 = String.format("name: %s", accidentPair.get(1).getPolisPåPlats());

            String Regnr1 = String.format("name: %s", accidentPair.get(0).getRegnr());
            String Regnr2 = String.format("name: %s", accidentPair.get(1).getRegnr());

            String Regnrmotpart1 = String.format("name: %s", accidentPair.get(0).getRegnrmotpart());
            String Regnrmotpart2 = String.format("name: %s", accidentPair.get(1).getRegnrmotpart());

            String Skadeplats1 = String.format("name: %s", accidentPair.get(0).getSkadeplats());
            String Skadeplats2 = String.format("name: %s", accidentPair.get(1).getSkadeplats());

            String Skadorpåbilen1 = String.format("name: %s", accidentPair.get(0).getSkadorPåBilen());
            String Skadorpåbilen2 = String.format("name: %s", accidentPair.get(1).getSkadorPåBilen());

            String Utandningsprov1 = String.format("name: %s", accidentPair.get(0).getUtandningsprov());
            String Utandningsprov2 = String.format("name: %s", accidentPair.get(1).getUtandningsprov());


            /*set matched where both regnr1 and regnr2 in database to skickat...*/
            accidentRepository.setSkickad(accidentPair.get(0).getRegnr(),accidentPair.get(1).getRegnr());

            String body0 = new StringBuilder()
                    .append("Hej din kund har gjort en anmälan.\n")
                    .append("Nedan finner du din kunds skaderapport.\n")
                    .append(String.format("Förnamn: %s%n<br>", accidentPair.get(0).getDriverFirstName()))
                    .append(String.format("Efternamn: %s%n<br>", accidentPair.get(0).getDriverLastName()))
                    .append(String.format("Personnummer: %s%n<br>", accidentPair.get(0).getDriverPersonalID()))
                    .append(String.format("Telefonnummer: %s%n<br>", accidentPair.get(0).getDriverPhoneNumber()))
                    .append(String.format("Registreringsnummer: %s%n<br>", accidentPair.get(0).getRegnr()))
                    .append(String.format("Försäkringsbolag: %s%n<br>", accidentPair.get(0).getFörsäkringsbolag()))
                    .append(String.format("Skadedag: %s%n<br>", accidentPair.get(0).getSkadedag()))
                    .append(String.format("Skadeplats: %s%n<br>", accidentPair.get(0).getSkadeplats()))
                    .append(String.format("Skador på bilen: %s%n<br>", accidentPair.get(0).getSkadorPåBilen()))
                    .append(String.format("Var polisen på plats?: %s%n<br>", accidentPair.get(0).getPolisPåPlats()))
                    .append(String.format("Reslutat av utandningsprov: %s%n<br>", accidentPair.get(0).getUtandningsprov()))
                    .append(String.format("Registreringsnummer på motpart: %s%n<br>", accidentPair.get(0).getRegnrmotpart()))
                    .append(String.format("Omständighet: %s%n<br>", accidentPair.get(0).getOmständighet()))
                    .append(String.format("Händelseförlopp: %s%n<br>", accidentPair.get(0).getHändelseförlopp()))
                    .toString();

            String body1 = new StringBuilder()
                    .append("Hej din kund har gjort en anmälan.\n<br>")
                    .append("Nedan finner du din kunds skaderapport.\n<br>")
                    .append(String.format("Förnamn: %s%n<br>", accidentPair.get(1).getDriverFirstName()))
                    .append(String.format("Efternamn: %s%n<br>", accidentPair.get(1).getDriverLastName()))
                    .append(String.format("Personnummer: %s%n<br>", accidentPair.get(1).getDriverPersonalID()))
                    .append(String.format("Telefonnummer: %s%n<br>", accidentPair.get(1).getDriverPhoneNumber()))
                    .append(String.format("Registreringsnummer: %s%n<br>", accidentPair.get(1).getRegnr()))
                    .append(String.format("Försäkringsbolag: %s%n<br>", accidentPair.get(1).getFörsäkringsbolag()))
                    .append(String.format("Skadedag: %s%n<br>", accidentPair.get(1).getSkadedag()))
                    .append(String.format("Skadeplats: %s%n<br>", accidentPair.get(1).getSkadeplats()))
                    .append(String.format("Skador på bilen: %s%n<br>", accidentPair.get(1).getSkadorPåBilen()))
                    .append(String.format("Var polisen på plats?: %s%n<br>", accidentPair.get(1).getPolisPåPlats()))
                    .append(String.format("Reslutat av utandningsprov: %s%n<br>", accidentPair.get(1).getUtandningsprov()))
                    .append(String.format("Registreringsnummer på motpart: %s%n<br>", accidentPair.get(1).getRegnrmotpart()))
                    .append(String.format("Omständighet: %s%n<br>", accidentPair.get(1).getOmständighet()))
                    .append(String.format("Händelseförlopp: %s%n<br>", accidentPair.get(1).getHändelseförlopp()))
                    .toString();

            Mail.generateInsuranceCompanyClaimMessage(accidentPair.get(0).getDriverFirstName(), "no.reply.acac@gmail.com", body0);
            Mail.generateInsuranceCompanyClaimMessage(accidentPair.get(1).getDriverFirstName(), "no.reply.acac@gmail.com", body1);

            System.out.println(skadedag1);
            System.out.println(Regnr1 + " " +Regnr2);
        }
        System.out.println("Sending mail...");
    }
}
