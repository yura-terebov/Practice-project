#include <iostream>

class Countable {
    public:
        static int totalCountables;

    public:
        Countable() {
            totalCountables += 1;
        }
        ~Countable() {
            totalCountables -= 1;
        }
};

int Countable::totalCountables = 0;

// int main () {
//     Countable *A = new Countable();
//     Countable *B = new Countable();
//     Countable *C = new Countable();
//     Countable *D = new Countable();

//     std::cout << "\ntotal Count     " << Countable::totalCountables << std::endl;


//     delete(A);
//     std::cout << "\ntotal Count     " << Countable::totalCountables << std::endl;
//     delete(B);
//     std::cout << "\ntotal Count     " << Countable::totalCountables << std::endl;
//     delete(C);
//     std::cout << "\ntotal Count     " << Countable::totalCountables << std::endl;
//     delete(D);
//     std::cout << "\ntotal Count     " << Countable::totalCountables << std::endl;

//     return 0;
// }