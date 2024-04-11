import java.util.AbstractList;
import java.util.NoSuchElementException;

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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T get(int index) {
        return null;
    }

    public void AddLast(T value) {
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

}
