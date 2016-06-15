#include <iostream>

class fibonacci {
    private:
        int limit;
        int a, b, c;

    public:
        fibonacci(int limit) : limit(limit), a(1), b(0) {}

        void next() {
            if ( over() ) { // проверка чтобы не выскочить за границу
                return;
            }
            c = a + b;
            a = b;
            b = c;
        }

        void operator++() { next(); }

        void operator++(int) { operator++(); }

        bool over() { return b > limit; }

        int value() { return b; }

        int operator*() { return value(); }
};