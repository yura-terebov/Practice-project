#include <iostream>

class Mohican {
    private:
        Mohican* prevMohican;
        Mohican* nextMohican;
    public: 
        static Mohican* lastMohican;


    public:
        Mohican() {
            prevMohican = lastMohican;
            lastMohican = this;
            nextMohican = NULL;
            if ( prevMohican != NULL ) {
            prevMohican->nextMohican = this;
            }

        }
        ~Mohican() {
            if ( nextMohican == NULL ) {
                lastMohican = prevMohican;
            } else {
                if ( prevMohican != NULL ) {
                prevMohican->nextMohican = this;
                }
                nextMohican->prevMohican = prevMohican;
            }
        }
        

}; 

Mohican* Mohican::lastMohican = NULL;

int main () {
    Mohican* A = new Mohican();
    std::cout << "ID - Mohican : " << Mohican::lastMohican << std::endl;
    Mohican* B = new Mohican();
    std::cout << "ID - Mohican : " << Mohican::lastMohican << std::endl;
    Mohican* C = new Mohican();
    std::cout << "ID - Mohican : " << Mohican::lastMohican << std::endl;
    Mohican* D = new Mohican();

    std::cout << "ID - Mohican : " << Mohican::lastMohican << std::endl;


    delete A;
    delete B;
    // delete C;
    delete D;
    std::cout << "After Edit \nlastID - Mohican : " << Mohican::lastMohican << std::endl;

    return 0;
}
