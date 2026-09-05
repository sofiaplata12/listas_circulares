public class MiListaCircular implements ListInterface {
    private Node cabeza;
    private Node cola;
    private int tamano;

    @Override
    public boolean isEmpty() {
        return tamano == 0;
    }

    @Override
    public int getSize() {
        return tamano;
    }

    @Override
    public void clear() {
        cabeza = null;
        cola = null;
        tamano = 0;
    }

    @Override
    public Object getHead() {
        if (cabeza == null) {
            return null;
        }
        return cabeza.dato;
    }

    @Override
    public Object getTail() {
        if (cola == null) {
            return null;
        }
        return cola.dato;
    }

    @Override
    public Object get(Node node) {
        if (node == null) {
            return null;
        }
        return node.dato;
    }

    @Override
    public Node search(Object object) {
        if (cabeza == null) {
            return null;
        }

        Node actual = cabeza;

        for (int i = 0; i < tamano; i++) {
            if (actual.dato.equals(object)) {
                return actual;
            }
            actual = actual.siguiente;
        }

        return null;
    }

    @Override
    public boolean add(Object object) {
        Node nuevo = new Node(object);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cola.siguiente = nuevo;
            cola = nuevo;
        }

        tamano++;
        return true;
    }

    @Override
    public boolean insert(Node node, Object object) {
        if (node == null) {
            return false;
        }

        Node nuevo = new Node(object);

        nuevo.siguiente = node.siguiente;
        node.siguiente = nuevo;

        // si insertamos después de la cola, el nuevo nodo pasa a ser la cola
        if (node == cola) {
            cola = nuevo;
        }

        tamano++;
        return true;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        Node nodoReferencia = search(objectRef);

        if (nodoReferencia == null) {
            return false;
        }

        return insert(nodoReferencia, object);
    }

    @Override
    public boolean insertHead(Object object) {
        Node nuevo = new Node(object);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cola.siguiente = nuevo;  // la cola debe apuntar al nuevo inicio
            cabeza = nuevo;
        }

        tamano++;
        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        Node nuevo = new Node(object);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cola.siguiente = nuevo;
            cola = nuevo;
        }

        tamano++;
        return true;
    }

    @Override
    public boolean set(Node node, Object object) {
        if (node == null) {
            return false;
        }

        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(Node node) {
        if (node == null || cabeza == null) {
            return false;
        }

        if (tamano == 1) {
            cabeza = null;
            cola = null;
            tamano = 0;
            return true;
        }


        Node actual = cabeza;
        for (int i = 0; i < tamano; i++) {
            if (actual.siguiente == node) {

                actual.siguiente = node.siguiente;

                if (node == cabeza) {
                    cabeza = node.siguiente;
                }
                if (node == cola) {
                    cola = actual;
                }

                tamano--;
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {
        Object[] arreglo = new Object[tamano];

        Node actual = cabeza;
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = actual.dato;
            actual = actual.siguiente;
        }

        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        if (object.length < tamano) {
            object = new Object[tamano];
        }

        Node actual = cabeza;
        for (int i = 0; i < tamano; i++) {
            object[i] = actual.dato;
            actual = actual.siguiente;
        }

        if (object.length > tamano) {
            object[tamano] = null;
        }

        return object;
    }

    @Override
    public MiListaCircular subList(Node from, Node to) {
        MiListaCircular sublista = new MiListaCircular();

        if (from == null || to == null) {
            return sublista;
        }

        Node actual = from;

        for (int i = 0; i < tamano; i++) {
            sublista.insertTail(actual.dato);

            if (actual == to) {
                break;
            }

            actual = actual.siguiente;
        }

        return sublista;
    }

    @Override
    public MiListaCircular sortList() {
        MiListaCircular listaOrdenada = new MiListaCircular();

        Object[] arreglo = this.toArray();

        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                Comparable actual = (Comparable) arreglo[j];
                Comparable siguiente = (Comparable) arreglo[j + 1];

                if (actual.compareTo(siguiente) > 0) {
                    Object temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }

        for (Object dato : arreglo) {
            listaOrdenada.insertTail(dato);
        }

        return listaOrdenada;
    }

}

