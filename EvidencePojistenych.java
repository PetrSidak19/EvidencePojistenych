package EvidencePojistenych;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class EvidencePojistenych {

    private LinkedList<ZaznamUdaju> zaznamy = new LinkedList<>();
    private ZaznamUdaju aktualniZaznam;
    private Scanner sc = new Scanner(System.in);


    public void Program() {

        String volba = "";

        while (!volba.equals("5")) {
            vypisMenu();

            if (aktualniZaznam != null) {
                try {
                    aktualniZaznam = zaznamy.getLast();
                    posledniPojistny();
                } catch (Exception e) {
                    System.out.println("Pojištěný nenalezen");
                }
            }

            System.out.print("Zadejte příkaz: ");
            volba = sc.nextLine();

            switch (volba) {
                case "1":
                    vytvorPojistneho();
                    break;

                case "2":
                    pocetPojistenych();
                    break;
                case "3":
                    vypisPojistne();
                    break;
                case "4":
                    if (zaznamy.size() != 0) {
                        smazZaznam();
                    } else {
                        System.out.println("\n*Databáze je prázdná, prosím vytvořte nový záznam*");
                    }
                    break;
                case "5":
                    System.out.println("Konec Programu:-)");
                    break;
                default:
                    System.out.println("Zadali jste špatnou hodnotu, zadejte prosím číslo od 1 do 5.");
                    break;
            }
        }

    }

    void pocetPojistenych() {
        System.out.println("------------------------------------------");
        System.out.println("Počet pojištěných: " + zaznamy.size());
    }

    void vypisMenu() {
        System.out.println();
        System.out.println("------------------------\nEvidence Pojištěných\n------------------------");
        System.out.println();
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Vytvořte pojištěnce");
        System.out.println("2 - Počet pojištěných");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Vymazat pojištěné");
        System.out.println("5 - Ukončit program");
        System.out.println();
    }

    void vytvorPojistneho() {
        LocalDate datumVytvoreniZaznamu = LocalDate.now();

        System.out.println();
        System.out.println("Vytvořte pojištěného:");
        System.out.println("--------------------");

        System.out.println("Zadejte jméno pojištěného:");
        String text = sc.nextLine();
        System.out.println("Zadejte příjmení:");
        String prijmeni = sc.nextLine();
        System.out.println("Zadejte věk:");
        int vek = Integer.parseInt(sc.nextLine());
        System.out.println("Zadejte telefonní číslo:");
        int telefon = Integer.parseInt(sc.nextLine());

        ZaznamUdaju zaznam = new ZaznamUdaju(datumVytvoreniZaznamu, text, prijmeni, telefon, vek);
        zaznamy.add(zaznam);

        aktualniZaznam = zaznam;

        System.out.println("Pojištěný byl vytvořen:-)");
    }

    void vypisPojistne() {
        pocetPojistenych();

        System.out.println("------------------------------------------");
        for (int i = 0; i < zaznamy.size(); i++) {
            System.out.println("Pojištěný [" + i + "] vytvořen " + zaznamy.get(i).getDatum() + ":" + "\n");
            System.out.println("Jméno: " + zaznamy.get(i).getJmeno() + "\n");
            System.out.println("Příjmení: " + zaznamy.get(i).getPrijmeni() + "\n");
            System.out.println("Telefon: " + zaznamy.get(i).getTelefon() + "\n");
            System.out.println("Věk: " + zaznamy.get(i).getVek() + "\n");
        }
        System.out.println("------------------------------------------");
    }

    void posledniPojistny() {
        System.out.println("------------------------------------------");
        System.out.println("Poslední záznam pojištěného:");
        System.out.println(aktualniZaznam.getJmeno());
        System.out.println("Vytvořen: " + aktualniZaznam.getDatum());
        System.out.println("------------------------------------------");
    }

    void smazZaznam() {

        vypisPojistne();

        boolean jeSpravne = false;
        /* Kontolní boolean, který slouží k potvrzení zadání správného vstupu,
         * v případě nesprávného zadání se vypíše varovná zpráva a cyklus while pokračuje,
         * dokud uživatel nezadá platný index
         */
        while (!jeSpravne) {
            try {
                System.out.println("Jaký záznam si přejete vymazat?");
                System.out.println("Pro vymazání záznamu zadejte číslo pojištěného, například => 1");
                System.out.print("Záznam k vymazání: ");
                int id = Integer.parseInt(sc.nextLine());
                // Přetypování (Parsování) vstupu uživatele do proměnné id, provádí se překlad ze String do Integer
                zaznamy.remove(id); // Vymazání záznamu
                jeSpravne = true;// Nastavení booleanu jeSpravne na true, které ukončí cyklus while
                System.out.println("Záznam byl odebrán");

            } catch (Exception e) {
                System.out.println(
                        "Zadaná hodnota neodpovídá indexu žádného ze záznamů.");
            }
        }
    }
}

