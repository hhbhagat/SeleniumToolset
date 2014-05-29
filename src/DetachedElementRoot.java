
import java.util.HashMap;
import java.util.Map;

public class DetachedElementRoot {

    Map<String, String> attrs = new HashMap<String, String>();
    
    public DetachedElementRoot(Map<String, String> a){
        attrs = a;
    }
    
    public Map<String, String> getAttrs(){
        return attrs;
    }
    
}
