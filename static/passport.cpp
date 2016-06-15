#include <iostream>

class InvalidDate {
    public:
        std::string text;
        InvalidDate(const std::string& text) : text(text) {}
};


class Passport {
private:
    std::string firstName;
    std::string SecondName;
    int year;
    int month;
    int day;

    void validate(int day, int month, int year) {
        if ( year <= 0 ) {
            throw InvalidDate("invalid date");
        } else if ( day <= 0 ) {
               throw InvalidDate("invalid date");
        } else if ( month <= 0 || month > 12 ) {
            throw InvalidDate("invalid date");
        }

        if ( month < 7 ) {
            if ( month % 2 == 0 && day > 30 ) {
                throw InvalidDate("invalid date");
            }

            if ( month % 2 != 0 && day > 31 ) {
                throw InvalidDate("invalid date");
            }
        }

        if ( month > 7 ) {
            if ( month % 2 == 0 && day > 31 ) {
                throw InvalidDate("invalid date");
            }

            if ( month % 2 != 0 && day > 30 ) {
                throw InvalidDate("invalid date");
            }
        }

        if ( month == 2 ) {
            if ( year % 4 == 0 && day > 29 ) {
                throw InvalidDate("invalid date");
            } else if (year % 4 != 0 && day > 28) {
                throw InvalidDate("invalid date");
            }
        }
    }
public:
    static int number;
    static std::string serial;
public:
    Passport(std::string firstName, std::string SecondName, int year, int month, int day) {
        this->firstName = firstName;
        this->SecondName = SecondName;
        validate(day, month, year);
        this->year = year;
        this->month = month;
        this->day = day;
        if ( number >= 1000000 ) {
            number = 1;
            if ( serial[1] == 'Z' ) {
                serial[0] += 1;
                serial[1] = 'A';
            } else {
            serial[1] += 1;
            }
        } else {
            number += 1;
        }
    }
    ~Passport(){

    }


    void newSerial(std::string newSerial = "AA", int newNumber = 1) {
        serial = newSerial; 
        number = newNumber;
    }

    std::string getFirstName() {
        return this->firstName;
    }

    std::string getSecondName() {
        return this->SecondName;
    }

    int getYear() {
        return this->year;
    }

    int getMonth() {
        return this->month;
    }

    int getDay() {
        return this->day;
    }

};

int Passport::number = 100000;
std::string Passport::serial = "AA";

std::ostream& operator<<(std::ostream& out, Passport& passport) {
return out  << "    PASSPORT UKRAINE\n"
            << "\n        " << Passport::serial << ' ' << Passport::number
            << "\n    SecondName: " << passport.getSecondName()
            << "\n    FirstName: " << passport.getFirstName()
            << "\n    Born: " << passport.getDay() << '.' << passport.getMonth() << '.' << passport.getYear()
            << std::endl;
}


int main() {
    Passport* Ivan = new Passport("Ivan", "Kuldarac", 1994, 12, 20);

    std::cout << *Ivan << std::endl;
    // std::cout << Passport::serial[3] << std::endl;

    return 0;
}