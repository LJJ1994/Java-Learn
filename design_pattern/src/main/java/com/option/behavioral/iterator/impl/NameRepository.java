package com.option.behavioral.iterator.impl;

import com.option.behavioral.iterator.Container;
import com.option.behavioral.iterator.Iterator;

public class NameRepository implements Container {
    public String[] names = {"A", "B", "C"};
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        private int index;
        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
