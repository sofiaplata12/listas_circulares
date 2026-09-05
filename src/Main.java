
public class Main {
    public static void main(String[] args) {
        MiListaCircular lista = new MiListaCircular();

        System.out.println("¿Vacía al inicio? " + lista.isEmpty());
        System.out.println("Tamaño inicial: " + lista.getSize());

        // --- add / insertHead / insertTail ---
        lista.add(20);
        lista.add(30);
        lista.insertHead(10);
        lista.insertTail(40);

        System.out.println("\n--- Después de add / insertHead / insertTail ---");
        imprimir(lista);

        // --- getHead / getTail ---
        System.out.println("\nHead: " + lista.getHead());
        System.out.println("Tail: " + lista.getTail());

        // --- search / contains / get(node) ---
        Node nodo20 = lista.search(20);
        System.out.println("¿Contiene 99? " + lista.contains(99));
        System.out.println("get(nodo20): " + lista.get(nodo20));

        // --- insert(Node, Object) ---
        lista.insert(nodo20, 25);
        System.out.println("\n--- Después de insert(nodo20, 25) ---");
        imprimir(lista);

        // --- insert(Object, Object) ---
        lista.insert(30, 35);
        System.out.println("\n--- Después de insert(30, 35) ---");
        imprimir(lista);

        // --- set(node, object) ---
        Node nodo25 = lista.search(25);
        lista.set(nodo25, 99);
        System.out.println("\n--- Después de set(nodo25, 99) ---");
        imprimir(lista);

        // --- remove(node) ---
        lista.remove(lista.search(99)); // 10 -> 20 -> 30 -> 35 -> 40
        System.out.println("\n--- Después de remove(99) ---");
        imprimir(lista);

        // --- toArray() ---
        System.out.println("\ntoArray(): ");
        Object[] arreglo = lista.toArray();
        for (Object o : arreglo) {
            System.out.print(o + " ");
        }
        System.out.println();

        // --- toArray(Object[]) ---
        Object[] arregloGrande = lista.toArray(new Object[8]);
        System.out.println("\ntoArray(arreglo más grande): ");
        for (Object o : arregloGrande) {
            System.out.print(o + " ");
        }
        System.out.println();

        // --- subList(from, to) ---
        Node desde = lista.search(20);
        Node hasta = lista.search(35);
        MiListaCircular sub = lista.subList(desde, hasta);
        System.out.println("\nsubList(20, 35): ");
        imprimir(sub);

        // --- sortList() ---
        MiListaCircular desordenada = new MiListaCircular();
        desordenada.add(50);
        desordenada.add(10);
        desordenada.add(30);
        desordenada.add(20);
        desordenada.add(40);

        System.out.println("\n--- Lista desordenada ---");
        imprimir(desordenada);

        MiListaCircular ordenada = desordenada.sortList();
        System.out.println("\n--- Lista ordenada ---");
        imprimir(ordenada);


        lista.clear();
        System.out.println("\n¿Vacía después de clear()? " + lista.isEmpty());
        System.out.println("Tamaño después de clear(): " + lista.getSize());
    }


    private static void imprimir(MiListaCircular l) {
        Object[] datos = l.toArray();
        for (Object dato : datos) {
            System.out.print(dato + " ");
        }
        System.out.println();
    }
}