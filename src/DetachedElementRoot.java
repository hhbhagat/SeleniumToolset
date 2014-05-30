
import java.util.HashMap;
import java.util.Map;

public class DetachedElementRoot {

    private String tagName = "";
    private Map<String, String> attrs = new HashMap<String, String>();
    
    public DetachedElementRoot(String name, Map<String, String> a){
        tagName = name;
        attrs = a;
    }
    
    public Map<String, String> getAttrs(){
        return attrs;
    }
    
}
