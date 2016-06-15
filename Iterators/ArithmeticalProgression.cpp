#include <iostream>

class arithmeticalProgression {
    private:
        int limit;
        int current;
        int step;
    public:
        arithmeticalProgression(int limit, int step) : limit(limit), current(1), step(step) {}

        void next() {
            if ( over() ) { // проверка чтобы не выскочить за границу
                return;
            }
            current += step; 
        }

        void operator++() { next(); }

        void operator++(int) { operator++(); }

        bool over() { return current > limit; }

        int value() { return current; }

        int operator*() { return value(); }
};