
import java.io.Serializable;
import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 * 
 * mit .gitingnore build und dist werden nicht von git beachtet und hochgeladen
 */
public class Schueler implements Serializable{
    private String name;
    private int age;
    private LocalDate birthday;

    public Schueler(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        this.age = LocalDate.now().getYear() - birthday.getYear();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    
    
    
}
