package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model
{
    public String getName() {
        return name;
    }

    public String name;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String name)
    {
        this.name = name;
    }

    //method to get the latest readings from arraylist 'readings'
    public Reading latestReading() {
        if (this.readings.size() == 0) {
            return null;
        } else {
            return this.readings.get(this.readings.size() - 1);
        }
    }
}

