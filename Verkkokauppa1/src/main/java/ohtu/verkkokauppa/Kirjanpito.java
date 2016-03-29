
package ohtu.verkkokauppa;

import java.util.*;
import org.springframework.stereotype.Component;
@Component
public class Kirjanpito implements IKirjanpito {
    private List<String> tapahtumat;

    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }
    
    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public List<String> getTapahtumat() {
        return tapahtumat;
    }       
}
