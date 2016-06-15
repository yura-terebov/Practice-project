#include <iostream>

class Identifiable {
    private:
        int id;
    public:
        static int lastId;

    public:
        Identifiable() {
            lastId += 1;
            this->id = lastId;
        }
        ~Identifiable() {

        }

        int getId () {
            return this->id;
        }
};

int Identifiable::lastId = 0;

int main () {
    Identifiable* A = new Identifiable();
    Identifiable* B = new Identifiable();
    Identifiable* C = new Identifiable();
    Identifiable* D = new Identifiable();

    std::cout << "ID : " << A->getId() << std::endl;
    std::cout << "ID : " << B->getId() << std::endl;
    std::cout << "ID : " << C->getId() << std::endl;
    std::cout << "ID : " << D->getId() << std::endl;


    delete A;
    delete B;
    delete C;
    delete D;

    return 0;
}
