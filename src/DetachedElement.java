
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DetachedElement {

    private ArrayList<DetachedElement> childrenArr = null;
    private DetachedElementRoot root = null;
    private Map<String, Map<String, String>> tags = new HashMap<String, Map<String, String>>();
    private boolean isRoot = false;

    public DetachedElement() {
        childrenArr = new ArrayList<DetachedElement>();
    }

    public void setRoot(String tagName, Map<String, String> a) {
        root = new DetachedElementRoot(tagName, a);
        isRoot = true;
    }

    public void addTag(String tag, Map<String, String> attrMap) {
        tags.put(tag, attrMap);
    }

    public ArrayList<Map<String, String>> getTags(String q) {
        ArrayList<Map<String, String>> foundTags = new ArrayList<Map<String, String>>();
        for (Map<String, String> m : tags.values()) {
            if (m.containsKey(q)) {
                foundTags.add(m);
            }
        }
        return foundTags;
    }

}
