public class TesteDaListaComArray {

    public static void main(String[] args) {

        System.out.println("=== Testando ListaComArray ===");
        Lista<Integer> listaArray = new ListaComArray<Integer>();
        testar(listaArray);

        System.out.println();
        System.out.println("=== Testando ListaComEncadeamento ===");
        Lista<Integer> listaEncadeada = new ListaComEncadeamento<Integer>();
        testar(listaEncadeada);
    }

    private static void testar(Lista<Integer> lista) {

        for (int i = 0; i < 8; i++) {
            lista.add(i);
        }
        System.out.println("Apos adicionar 0..7: " + lista);

        lista.add(0, 99);
        System.out.println("Apos add(0, 99): " + lista);

        lista.add(lista.size(), 101);
        System.out.println("Apos add(size, 101): " + lista);

        System.out.println("size(): " + lista.size());
        System.out.println("isEmpty(): " + lista.isEmpty());
        System.out.println("contains(99): " + lista.contains(99));
        System.out.println("indexOf(99): " + lista.indexOf(99));
        System.out.println("lastIndexOf(101): " + lista.lastIndexOf(101));

        Integer removido = lista.remove(0);
        System.out.println("remove(0) retornou: " + removido + " -> " + lista);

        boolean removeuOk = lista.removeFirst(101);
        System.out.println("removeFirst(101): " + removeuOk + " -> " + lista);

        Object[] array = lista.toArray();
        System.out.print("toArray(): [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        lista.clear();
        System.out.println("Apos clear(): " + lista + " | isEmpty(): " + lista.isEmpty());
    }
}
