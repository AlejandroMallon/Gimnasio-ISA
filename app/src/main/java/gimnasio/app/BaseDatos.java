package gimnasio.app;

import java.util.ArrayList;

public class BaseDatos {

    private ArrayList<Director> ldirector;

    public BaseDatos (){
        ldirector = new ArrayList<Director>();
    }

    public void add(Director dir){
        ldirector.add(dir);
    }

    //! Hay que hacer eliminar. 
    
}
