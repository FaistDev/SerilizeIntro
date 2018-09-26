
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for (Schueler s : schueler) {
            bw.append(s.getName()+";"+s.getBirthday().toString()+"\n");
        }
        bw.flush();
        bw.close();
    }
    
    public void load(File f) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        while((line=br.readLine())!=null){
            String[] parts = line.split(";");
            try{
                add(new Schueler(parts[0], LocalDate.parse(parts[1])));
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
        
        File f = new File("./data.csv");
        try{
            bl.save(f);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
