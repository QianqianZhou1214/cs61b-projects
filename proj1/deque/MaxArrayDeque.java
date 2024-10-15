package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> cmp;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.cmp = c;

    }

    public T max() {
        return max(cmp);

    }

    public T max(Comparator<T> c) {
        if (this.isEmpty()) return null;
        T maxElement = get(0); // Start with the first element
        for (int i = 1; i < size(); i++) {
            T current = get(i);
            if (current != null && c.compare(maxElement, current) < 0) {
                maxElement = current; // Update maxElement if current is greater
            }
        }
        return maxElement;
    }
}
