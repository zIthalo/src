public class ListaComEncadeamento<E> implements Lista<E> {

    private NoLista<E>  first;
    private NoLista<E>  last;
    private int         counter;

    public ListaComEncadeamento() {
        this.first      = null;
        this.last       = null;
        this.counter    = 0;
    }

    @Override
    public void add(E element) {

        NoLista<E> node = new NoLista<E>();
        node.setInfo(element);

        if (counter == 0) {
            this.first = node;
        } else {
            last.setNext(node);
        }

        this.last = node;
        counter++;
    }

    @Override
    public void add(int index, E element) {

        if (index < 0 || index > counter) {
            return;
        }

        if (index == counter) {
            add(element);
            return;
        }

        NoLista<E> node = new NoLista<E>();
        node.setInfo(element);

        if (index == 0) {
            node.setNext(first);
            first = node;
        } else {
            NoLista<E> anterior = getNode(index - 1);
            node.setNext(anterior.getNext());
            anterior.setNext(node);
        }

        counter++;
    }

    @Override
    public E remove(int index) {

        if (index < 0 || index >= counter) {
            return null;
        }

        E removido;

        if (index == 0) {
            removido = first.getInfo();
            first = first.getNext();

            if (first == null) {
                last = null;
            }
        } else {
            NoLista<E> anterior = getNode(index - 1);
            NoLista<E> alvo = anterior.getNext();
            removido = alvo.getInfo();

            anterior.setNext(alvo.getNext());

            if (alvo == last) {
                last = anterior;
            }
        }

        counter--;

        return removido;
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

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    @Override
    public int size() {
        return this.counter;
    }

    @Override
    public boolean isEmpty() {
        return (this.counter == 0);
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(E element) {

        NoLista<E> current = this.first;
        int index = 0;

        while (current != null) {
            if (current.getInfo().equals(element)) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(E element) {

        NoLista<E> current = this.first;
        int index = 0;
        int ultimoIndice = -1;

        while (current != null) {
            if (current.getInfo().equals(element)) {
                ultimoIndice = index;
            }
            current = current.getNext();
            index++;
        }

        return ultimoIndice;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {

        E[] novoArray = (E[]) new Object[counter];

        NoLista<E> current = this.first;
        int i = 0;

        while (current != null) {
            novoArray[i] = current.getInfo();
            current = current.getNext();
            i++;
        }

        return novoArray;
    }

    /**
     * Retorna o nó armazenado na posição index (0-based).
     * Método auxiliar interno, não faz parte da interface Lista.
     */
    private NoLista<E> getNode(int index) {

        NoLista<E> current = this.first;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        NoLista<E> current = this.first;

        while (current != null) {
            sb.append(current.getInfo());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        sb.append("]");

        return sb.toString();
    }
}
