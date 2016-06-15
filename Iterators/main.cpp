#include <iostream>
#include "arithmeticalProgression.cpp"
#include "GeometricProg.cpp"
#include "Factorial.cpp"
#include "Fibonacci.cpp"
#include "Simple.cpp"

using namespace std;

int main() {
    arithmeticalProgression seq(40, 4);
    GeometricProgression seq1(1000, 3);
    Factorial seq2(10000);
    fibonacci seq3(10000);
    Simple seq4(100);

    for ( ; !seq4.over(); seq4.next() ) {
        cout << seq4.value() << endl;
    }

    // for (int i = 0; i < 100; i++) {
    //     if ( seq4.getBuffer(i) != 0 ) {
    //     cout << seq4.getBuffer(i) << endl;
    //     }
    // }

    return 0;
}