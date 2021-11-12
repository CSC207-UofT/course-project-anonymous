import java.util.ArrayList;
import java.util.Iterator;

class GeneralIterator<T> implements Iterator<T> {
    private int currentIndex;
    private ArrayList<T> collection;

    GeneralIterator(ArrayList<T> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return currentIndex <= this.collection.size() - 1;
    }

    @Override
    public T next() {
        int currentIndexTemp = this.currentIndex;
        this.currentIndex ++;

        return this.collection.get(currentIndexTemp);
    }
}
