
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class SchuelerBL {
    private ArrayList<Schueler> schueler = new ArrayList<>();
    
    public void add(Schueler s){
        schueler.add(s);
    }
    
    public void save(File f) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Schueler s : schueler) {
            oos.writeObject(s);
        }
        oos.flush();
    }
    
    public void load(File f) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
       Object s=null;
        while((s=ois.readObject())!=null){
            try{
                add((Schueler) s);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        }
    }
    
    public static void main(String[] args) {
        Schueler s1 = new Schueler("Hans", LocalDate.of(2000, Month.MARCH, 3));
        Schueler s2 = new Schueler("Grete", LocalDate.of(1999, Month.OCTOBER, 10));
        
        SchuelerBL bl = new SchuelerBL();
        bl.add(s1);
        bl.add(s2);
        
        File f = new File("./data.bin");
        try{
            bl.save(f);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
