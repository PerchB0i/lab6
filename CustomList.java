import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class CustomList<T> extends AbstractList<T> {
    public class Node {
        T value;
        Node next;
    }

    Node start;
    Node end;

    public CustomList() {
        this.start = this.end = null;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node tmp = start;

            @Override
            public boolean hasNext() {
                return tmp != null;
            }

            @Override
            public T next() {
                T value = tmp.value;
                tmp = tmp.next;
                return value;
            }
        };
    }

    public Stream<T> stream() {
        Stream.Builder<T> streamBuilder = Stream.builder();

        for(T item : this) {
            streamBuilder.accept(item);
        }

        return streamBuilder.build();
    }

    @Override
    public int size() {
        int size = 1;
        Node tmp = new Node();
        tmp.value = null;
        tmp.next = null;
        if(this.end == null){
            return 0;
        } if(this.end == this.start) {
            return 1;
        } else {
            while (tmp != this.end) {
                tmp.value = tmp.next.value;
                tmp.next = tmp.next.next;
                size += 1;
            }
        }

        return size;
    }

    @Override
    public T get(int index) {
        if(this.end == null){
            throw new NoSuchElementException();
        }
        Node tmp = start;
        if(this.end == this.start) {
            tmp.value = this.start.value;
        } if(index < size()) {
            for (int i = 0; i <= index; i++) {

                tmp.value = tmp.next.value;
                tmp.next = tmp.next.next;
            }
        } else {
            throw new NoSuchElementException();
        }
        return tmp.value;
    }

    public void addLast(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;

        if (this.start == null)
            this.start = newNode;
        else
            this.end.next = newNode;

        this.end = newNode;
    }

    public T getLast() {
        if(this.end == null)
        {
            throw new NoSuchElementException();
        }
        return this.end.value;
    }

    public void addFirst(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = start;

        if (this.start == null) {
            this.start = newNode;
            this.end = newNode;
        }
        else {
            this.start = newNode;
        }
    }

    public T getfirst() {
        if(this.start == null)
        {
            throw new NoSuchElementException();
        }
        return this.start.value;
    }

    public T removeFirst() {
        if(this.start == null)
        {
            throw new NoSuchElementException();
        }
        T value = this.getfirst();
        if(this.start == this.end) {
            this.start = this.end = null;
        } else
            this.start = this.start.next;

        return value;
    }

    public T removeLast() {
        if(this.start == null)
        {
            throw new NoSuchElementException();
        }

        T value = this.getLast();

        if(this.start == this.end) {
            this.start = this.end = null;
            return value;
        } else {
            Node tmp = this.start;
            while (tmp.next != this.end)
            {
                tmp = tmp.next;
            }
            tmp.next = null;
            this.end = tmp;
            return value;
        }
    }

    public boolean add(T t) {
        this.addLast(t);
        return true;
    }

}
