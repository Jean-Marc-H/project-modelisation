package salle;

import java.util.ArrayList;

public class Salle {
    ArrayList<Table> tables=new ArrayList<Table>();

    public ArrayList<Table> getTables(){
        return this.tables;
    }

    public void ajouterTable(int numero){
        this.tables.add(new Table(numero));
    }
}
