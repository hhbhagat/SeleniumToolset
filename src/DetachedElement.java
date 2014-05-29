
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DetachedElement {

    ArrayList<DetachedElement> childrenArr = null;
    DetachedElementRoot root = null;
    Map<String, String> attrs = new HashMap<String, String>();
    boolean isRoot = false;

    public DetachedElement() {
        childrenArr = new ArrayList<DetachedElement>();
    }

    public void setRoot(Map<String, String> a) {
        root = new DetachedElementRoot(a);
        isRoot = true;
    }

    public void addAttr(String k, String v) {
        attrs.put(k, v);
    }

    public String[] getAttr(String q) {
        String[] pair = new String[2];
        if (attrs.containsKey(q)) {
            pair[0] = q;
            pair[1] = attrs.get(q);
        } else {
            return null;
        }
        return pair;
    }
    
    

}
