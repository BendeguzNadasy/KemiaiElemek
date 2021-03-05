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
        
        //5. feladat
        Scanner sc = new Scanner(System.in);
        int joKarakter = 0;
        int karakterSzam;
        String vegyjel;
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

        System.out.println("7. feladat:"+ legnagyobbkulombseg+" év volt a leghosszab időszak a két elem felfedezése között");
        
        HashMap<Integer,Integer> hanyEgyEvben = new HashMap<>();
        for (int i = 0; i < elemek.size()-1; i++) {
            Elem elem = elemek.get(i);
            if (elem.getEv().charAt(0)!='Ó') {
                int kulcs = Integer.parseInt(elem.getEv());
                if (hanyEgyEvben.containsKey(kulcs)) {
                    int jelenlegiDb = hanyEgyEvben.get(kulcs);
                    hanyEgyEvben.remove(kulcs);
                    hanyEgyEvben.put(kulcs, ++jelenlegiDb);
                } else {
                    hanyEgyEvben.put(kulcs, 1);
                }
            }
        
        }
        // feladat 8
        System.out.println("8. feladat: Statisztika");
        for (Map.Entry<Integer, Integer> entry : hanyEgyEvben.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value>3){
                System.out.println(""+key+": "+value+" db");
            }
        }

    }
    
}
