package kemia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kemia {

    public static void main(String[] args) throws IOException {
        List<String> sorok = Files.readAllLines(Paths.get("felfedezesek.csv"));
        ArrayList<Elem> elemek = new ArrayList<>();
        
        for (int i = 1; i < sorok.size(); i++) {
            elemek.add(new Elem(sorok.get(i)));
        }
        
        //3. feladat 
        

        //4. feladat
        
        //5. feladat
        Scanner sc = new Scanner(System.in);
//        System.out.print("5.feladat: Kérek egy vegyjelet: ");
//        String vegyjel = sc.nextLine();
        int joKarakter = 0;
        int karakterSzam;
        String vegyjel;
//        vegyjel = "ö";
        do {                
        System.out.print("5.feladat: Kérek egy vegyjelet: ");
        vegyjel = sc.nextLine();
        karakterSzam = vegyjel.length();
        joKarakter = 0;
            System.out.println(karakterSzam);
            if (vegyjel.length() <= 2) {
                for (int i = 0; i < vegyjel.length(); i++) {
                    char betu = vegyjel.charAt(i);
                    System.out.println("haló");
                    if ((betu >= 'a' && betu <= 'z') || (betu >= 'A' && betu <= 'Z')) {
                        joKarakter++;
                        System.out.println(joKarakter);
                        System.out.println(karakterSzam);
                    }

                } 
            }
        } while (joKarakter < karakterSzam);
       
        
//        while(vegyjel.equals("ö") || vegyjel.equals("ü") || vegyjel.equals("ó") || vegyjel.equals("ő") || vegyjel.equals("ú") || vegyjel.equals("ű") || vegyjel.equals("é") || vegyjel.equals("á")|| vegyjel.equals("í")){           
//            System.out.print("5.feladat: Kérek egy vegyjelet: ");
//            vegyjel = sc.nextLine();
//        }
        System.out.println(vegyjel);
        
        //6.feladat
        vegyjel = "Co";
        int i = 0;
        while(i < elemek.size() && !(vegyjel.equals(elemek.get(i).getVegyjel()))) {
            i++;
        }
        if (i >= elemek.size()) {
            System.out.println("Nincs ilyen elem az adatforrásban");
        }else {
            System.out.println(elemek.get(i).getVegyjel());
            System.out.println(elemek.get(i).getNev());
            System.out.println(elemek.get(i).getRendszam());
            System.out.println(elemek.get(i).getEv());
            System.out.println(elemek.get(i).getFelfedezo());
        }

        System.out.print("3. feladat: ");
        System.out.println("Elemek száma: " + elemek.size());
        
        //4. feladat
        
        System.out.print("4. feladat:");
        int okorDb = 0;
        for (Elem elem : elemek) {
            if (elem.getEv().equals("Ókor")) {
                okorDb++;
            }
        }
        System.out.println("Felfedezések száma az ókorban: " + okorDb);

    }
    
}
