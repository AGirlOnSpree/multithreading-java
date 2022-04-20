package multitreading.threadlocal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {

    private ThreadLocal<List<String>> itemsPerThread = ThreadLocal.withInitial(ArrayList::new);

    public void addItem(String item) {
        itemsPerThread.get().add(item);
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(itemsPerThread.get());
    }
}
