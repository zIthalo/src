public class ListaComArray<E> implements Lista<E> {

    private E[] array;
    private boolean resizable;
    private int initialCapacity;
    private int counter;
    private final static int x = 10;

    public ListaComArray() {
        this(10);
    }

    public ListaComArray(int initialCapacity) {
        this(initialCapacity, true);
    }

    @SuppressWarnings("unchecked")
    public ListaComArray(int initialCapacity, boolean resizable) {
        this.initialCapacity = initialCapacity;
        this.resizable = resizable;
        this.counter = 0;
        this.array = (E[]) new Object[initialCapacity];
    }

    @Override
    public void add(E element) {

        if (counter >= array.length) {

            if (!resizable) {
                return;
            }

            resizeArrayList();
        }

        array[counter] = element;
        counter++;
    }

    @Override
    public void add(int index, E element) {

        if (index < 0 || index > counter) {
            return;
        }

        if (counter == array.length) {

            if (resizable) {
                resizeArrayList();
            } else {
                return;
            }
        }

        for (int i = counter; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = element;
        counter++;
    }

    @SuppressWarnings("unchecked")
    private void resizeArrayList() {

        E novo[] = (E[]) new Object[array.length + x];

        System.arraycopy(array, 0, novo, 0, counter);

        array = novo;
    }

    @Override
    public E remove(int index) {

        if (index < 0 || index >= counter) {
            return null;
        }

        E elementoRemovido = array[index];

        for (int i = index; i < counter - 1; i++) {
            array[i] = array[i + 1];
        }

        array[counter - 1] = null;
        counter--;

        return elementoRemovido;
    }

    @Override
    public boolean removeFirst(E element) {

        int index = indexOf(element);

        if (index == -1) {
            return false;
        }

        remove(index);

        return true;
    }

    public E get(int index) {

        if (index < 0 || index >= counter) {
            return null;
        }

        return array[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {

        if (resizable) {
            array = (E[]) new Object[initialCapacity];
        }

        counter = 0;
    }

    @Override
    public int size() {
        return counter;
    }

    public E set(int index, E element) {

        if (index < 0 || index >= counter) {
            return null;
        }

        E old = array[index];

        array[index] = element;

        return old;
    }

    @Override
    public boolean isEmpty() {
        return (counter == 0);
    }

    public boolean isFull() {

        if (!resizable) {
            return (counter == array.length);
        }

        return false;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(E element) {

        for (int i = 0; i < counter; i++) {

            if (array[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(E element) {

        for (int i = (counter - 1); i >= 0; i--) {

            if (array[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {

        E[] novoArray = (E[]) new Object[counter];

        for (int i = 0; i < counter; i++) {
            novoArray[i] = array[i];
        }
        return novoArray;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < counter; i++) {
            sb.append(array[i]);
            if (i < counter - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
