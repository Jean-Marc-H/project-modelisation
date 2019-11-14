package salle;

import java.util.ArrayList;

public class Salle {
    ArrayList<Table> tables=new ArrayList<Table>();

    public ArrayList<Table> getTablesLibres(int nombrePersonnes){
        ArrayList<Table> tablesLibres=new ArrayList<>();
        for(Table table:this.tables){
            if(table.getSieges()>=nombrePersonnes&&table.estLibre()){
                tablesLibres.add(table);
            }
        }
        return tablesLibres;
    }
}
