#include "Gun.h"

Gun::Gun(const std::string& model, int capacity) {
    this->amount = 0;
    this->capacity = capacity;
    this->isReady = false;
    this->model = model;
    this->totalShots = 0;

}
Gun::~Gun() {

}

int Gun::getAmount() const {
    return this->amount;
}

int Gun::getCapacity() const {
    return this->capacity;
}

bool Gun::ready() const {
    return this->isReady;
}

const std::string& Gun::getModel() const {
    return this->model;
}

int Gun::getTotalShots() const {
    return this->totalShots;
}

void Gun::prepare() {
   this->isReady = !isReady;
}

void Gun::reload() {
    this->amount = this->capacity;
}

void Gun::shoot() {
   if ( !ready() ) {
       throw NotReady();
   }
   if ( amount == 0 ) {
       throw OutOfRounds();
   }

   std::cout << "Bang! \n" << std::endl;
   this->amount -= 1;
   this->totalShots += 1;
   this->isReady = false;
}


std::ostream& operator<<(std::ostream& out, const Gun& gun) {
    return out  <<  " Model is " << gun.getModel()
                << "\n Magazine " << gun.getAmount() << '/' << gun.getCapacity()
                << "\n Total HeadShot " << gun.getTotalShots()
                << "\n Readiness " << gun.ready() << std::endl;
}
