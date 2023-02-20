package com.example.projectcode.ITERATOR;

import java.util.List;
/* String Repository sınıfı Container interface'ini implemente eder. Dolayısıyla getItertor kullanılmalıdır.*/
public class StringRepository implements Container{
    /* String değerler alan liste tutulur. */
    List<String> stringList;

    /* String değerler tutulan liste constructor ile sınıfta tanımlanır.*/
    public StringRepository(List<String> stringList) {
        this.stringList = stringList;
    }

    /* String Iterator döndürülür. Bu bir inner sınıftır. Buna ulaşmak için bu metot önemlidir.*/
    @Override
    public Iterator getIterator() {
        return new StringIterator();
    }


    // Inner Sınıf String Iterator, Iterator interface'ini implemente eder.
    private class StringIterator implements Iterator {
        /* index değeri tutulmuştur.*/
        private int index;

        /* Iterator için, bir sonraki değer var mı? Kontrol edilir. Index size ile eşit olduğunda
        * sonraki değerin olmadığı anlaşılır. */
        @Override
        public boolean hasNext() {
            if(index < stringList.size()){
                return true;
            }
            return false;
        }

        /* Next ile iterator bir sonraki değere gider, index ile sonraki değere ulaşılır sonra
        * index değer bir arttırılır. Bu işlem için bir sonraki elemanın olması koşulu (hasNext) eklenemiştir. Aksi durumda
        * null değer döner.*/
        @Override
        public Object next() {
            if(this.hasNext()){
                return stringList.get(index++);
            }
            return null;
        }
    }

}


