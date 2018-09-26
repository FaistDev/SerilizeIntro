
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
            bw.append(s.getName()+";"+s.getAge()+","+s.getBirthday().toString()+"\n");
        }
        bw.flush();
        bw.close();
    }
    
    public void load(File f){
        
    }
    
    public static void main(String[] args) {
        
    }
}
