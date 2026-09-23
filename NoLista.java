public class NoLista<E> {
    private E info;
    private NoLista<E> next;

    public NoLista() {
        this.info = null;
        this.next = null;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public NoLista<E> getNext() {
        return next;
    }

    public void setNext(NoLista<E> next) {
        this.next = next;
    }
}
