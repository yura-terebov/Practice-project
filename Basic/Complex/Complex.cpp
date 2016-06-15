#include "Complex.h"

Complex::Complex(double real, double imaginary) {
    this->real = real;
    this->imaginary = imaginary;
}
Complex::~Complex() {

}

double Complex::getReal() const {
    return this->real;
}

double Complex::getImaginary() const {
    return this->imaginary;
}

bool Complex::operator==(const Complex& other) const {
    return this->real == other.real && this->imaginary == other.imaginary;
}

bool Complex::operator!=(const Complex& other) const {
    return !(*this==other);
}

void Complex::operator+=(const Complex& other) {
    this->real += other.real;
    this->imaginary += other.imaginary;
}

void Complex::operator-=(const Complex& other) {
    this->real -= other.real;
    this->imaginary -= other.imaginary;
}

Complex Complex::operator+(const Complex& other) const {
    Complex temp = *this;

    temp += other;
    return temp;
}

Complex Complex::operator-(const Complex& other) const {
    Complex temp = *this;

    temp -= other;
    return temp;
}

Complex Complex::operator*(const Complex& other) const {
    Complex tempThis = *this;
    double temp;
    
    temp = this->real * other.real - this->imaginary * other.imaginary;
    tempThis.imaginary = this->real * other.imaginary + this->imaginary * other.real;
    tempThis.real = temp;
    return tempThis;
}

std::ostream& operator<<(std::ostream& out, const Complex& complex) {
    out << complex.getReal() << "+" << complex.getImaginary() << 'i';

    return out;
}