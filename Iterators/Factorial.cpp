#include <iostream>

class Factorial {
    private:
        int limit;
        int factorial;
        int temp;
    public:
        Factorial(int limit) : limit(limit), factorial(1), temp(2) {}

        void next() {
            if ( over() ) { // проверка чтобы не выскочить за границу
                return;
            }
            factorial *= temp;
            temp += 1; 
        }

        void operator++() { next(); }

        void operator++(int) { operator++(); }

        bool over() { return factorial > limit; }

            int value() { return factorial; }

        int operator*() { return value(); }
};