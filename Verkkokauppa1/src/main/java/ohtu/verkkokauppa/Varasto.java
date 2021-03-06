package ohtu.verkkokauppa;

import java.util.*;

public class Varasto implements IVarasto {
 
    private IKirjanpito kirjanpito;
    private HashMap<ITuote, Integer> saldot;  
    
    public Varasto(Kirjanpito kirjanpito) {
        this.kirjanpito = kirjanpito;
        saldot = new HashMap<ITuote, Integer>();
        alustaTuotteet();
    }
            
    @Override
    public ITuote haeTuote(int id){
        for (ITuote t : saldot.keySet()) {
            if ( t.getId()==id) return t;
        }
        
        return null;
    }

    @Override
    public int saldo(int id){
        return saldot.get(haeTuote(id));
    }
    
    @Override
    public void otaVarastosta(ITuote t){        
        saldot.put(t,  saldo(t.getId())-1 );
        kirjanpito.lisaaTapahtuma("otettiin varastosta "+t);
    }
    
    @Override
    public void palautaVarastoon(ITuote t){
        saldot.put(t,  saldo(t.getId())+1 );
        kirjanpito.lisaaTapahtuma("palautettiin varastoon "+t);
    }    
    
    private void alustaTuotteet() {
        saldot.put(new Tuote(1, "Koff Portteri", 3), 100);
        saldot.put(new Tuote(2, "Fink Bräu I", 1), 25);
        saldot.put(new Tuote(3, "Sierra Nevada Pale Ale", 5), 30);
        saldot.put(new Tuote(4, "Mikkeller not just another Wit", 7), 40);
        saldot.put(new Tuote(5, "Weihenstephaner Hefeweisse", 4), 15);
    }
}
