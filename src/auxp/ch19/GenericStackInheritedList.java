package auxp.ch19;

import java.util.ArrayList;

public class GenericStackInheritedList<E> extends ArrayList<E> {

    public int getSize(){
        return this.size();
    }

    public E peek(){
        return get(size()-1);
    }

    public void push(E o){
        add(o);
    }

    public E pop(){
        E o = get(size()-1);
        remove(size()-1);
        return o;
    }
}
