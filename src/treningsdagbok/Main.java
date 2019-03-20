package treningsdagbok;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import Registrer;
import HentTreningsOkt;
import Treningslogg;

class Main() {


    public static void main(String[] args){

        Connection conn = new Connection(); // dette du tenker på odd?
        Scanner scanner = new Scanner(System.in);
        System.out.println("//********TRENINGSDAGBOK*******/")


        while(true){
            System.out.println("VELG HVA DU VIL GJØRE: \n"
                            + "***************************"
                            + "1: \t Registrering av treningsøkter, øvelser eller apparater. \n"
                            + "2: \t Hent ut informasjon om de n siste treningsøktene. \n"
                            + "3: \t Se resultatloggen fra enkeltøvelser i et gitt tidsintervall \n"
                            + "4: \t Opprette nye øvelsegruppe og finne øvelser som er i samme gruppe \n"
                            + "5: \t Hent ut gjennomsnittsformen over et gitt tidsintervall \n"
                            + "0: \t Avslutt Treningsdagboken din"
                            + "***************************" );

            int valg = scanner.nextInt();

            if(valg == 0){
                break;
            }

            if (valg == 1){
                Registrer reg = new Registrer();
                reg.connect();



                System.out.println("REGISTRERING:\n 1: Ny treningsøkt \n 2: Ny Øvelse \n 3: nytt Apparat ");
                int alt = scanner.nextInt();

                if(alt == 1){
                    System.out.println("Dato ( YYYY-MM-DD:"); //Her må det endres til riktig datetime object
                    String tidsstempel = scanner.next();
                    System.out.println("Varighet:");
                    int varighet = scanner.nextInt();
                    System.out.println("Form (tall fra 1-10: ");
                    int form = scanner.nextInt();
                    System.out.println("Prestasjon (tall fra 1-10: )");
                    int prestasjon = scanner.nextInt();
                    System.out.println("Notat: ");
                    String notat = scanner.next();
                    notat += scanner.nextLine();

                    reg.registrer_treningsokt(tidsstempel, varighet, form, prestasjon, notat);

                }

                if(alt == 2){
                    System.out.println("Navn på Apparat: ");
                    String navn = scanner.next();
                    r.registrer_apparat(navn);
                }
                if(alt == 3){
                    System.out.println("Navn på øvelse: ");
                    String navn = scanner.next();
                    System.out.println("Beskrivelse: ")
                    String beskrivelse = scanner.next();
                    System.out.println("Antall kilo(0 hvis friøvelse):  ");
                    int kilo = scanner.nextInt();
                    System.out.println("Antall sett(0 hvis friøvelse):  ");
                    int sett = scanner.nextInt();
                    System.out.println("Type: 0 for friøvelse, 1 for på apparat:  ");
                    int type = scanner.nextInt();
                    System.out.println("ApparatId(0 hvis friøvelse): ");
                    int aID = scanner.nextInt();
                    if(kilo == 0){
                        kilo = null;
                    }
                    if(sett == 0){
                        sett = null;
                    }
                    if( aID == 0){
                        aID = null;
                    }
                    r.registrer_ovelse(navn, beskrivelse, kilo, sett, type, aID);


                }

            }

            if(valg == 2){

                HentTreningsOkt okt = new HentTreningsOkt();
                okt.connect();

                System.out.println("Hvor mange økter vil du hente ut? ");
                int n = scanner.nextInt();
                okt.hentTreningsOkter(n);

            }

            if(valg == 3){

                Treningslogg trlogg = new Treningslogg();


                System.out.println("Navn på øvelse du ønsker å se resultatlogg for: ");
                String navn = scanner.next();
                System.out.println("Start dato(YYYY-MM-DD): ");
                String start = scanner.next();
                System.out.println("Slutt dato(YYYY-MM-DD): ");
                String slutt = scanner.next();
                System.out.print("Stigende eller synkende(0 eller 1): ");
                int b = scanner.nextInt();
                Boolean asc = false;
                if( b == 0 ){
                    asc = true;
                }

                trlogg.getTreningsLogg(conn, navn, start, slutt, asc);




            }


            if(valg == 4){


            }


            if(valg == 5){
                Gjennomsnitt gs = new Gjennomsnitt();

                System.out.println("Start: ");
                String start = scanner.next();
                System.out.println("Slutt: ");
                String slutt = scanner.next();

                gs.getGjennomsnitt(conn, start, slutt);




            }


        }

        System.out.println("************AVSLUTTER TRENINGSDAGBOK***************");
        scanner.close();

        }






        }