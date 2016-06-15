#include <iostream>

#include <cmath>
#include <cstdlib>


class Simple {
    private:
        int limit;
        int current;
        int* array;
    public:
        Simple(int limit) {
            this->limit = limit;
            this->current = 2;
            this-> array = (int*)malloc(limit*sizeof(int));

            for ( int i = 0; i < limit; i++ ) {
                array[i] = 0;
            }
        }

        void next() {
            if ( over() ) { // проверка чтобы не выскочить за границу
                return; 
            }
            array[current] = current;
            current += 1;
            for ( int i = 2; i < current; i++ ) {
                if ( remainder(current,i) == 0 ) {
                    current += 1;
                    i = 2;
                }
            }
        }

        void operator++() { next(); }

        void operator++(int) { operator++(); }

        bool over() { return current > limit; }

        int value() { return current; }

        int operator*() { return value(); }

        int getBuffer(int index) {
            return this->array[index];
        }
};