#include "Pen.h"

Pen::Pen(int inkCapacity) {
    this->inkAmount = 0;
    this->inkCapacity = inkCapacity;
}
Pen::~Pen() {

}

int Pen::getInkAmount() const {
    return this->inkAmount;
}

int Pen::getInkCapacity() const {
    return this->inkCapacity;
}

void Pen::write(Paper& paper, const std::string& message) {
    if ( this->inkAmount == 0 ) {
        throw OutOfInk();
    }

    if ( this->inkAmount < message.length() ) {
        paper.addContent(message.substr(0, this->inkAmount-1));
        this->inkAmount = 0;
        return;
    }
    paper.addContent(message);
    this->inkAmount -= message.length();
}

void Pen::refill() {
    this->inkAmount = this->inkCapacity;
}