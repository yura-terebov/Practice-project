#include "Date.h"

void Date::validate(int day, int month, int year) {
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

Date::Date(int day, int month, int year) {
    validate(day, month, year);
    this->day = day;
    this->month = month;
    this->year = year;
}
Date::~Date() {

}

int Date::getDay() const {
    return this->day;
}

int Date::getMonth() const {
    return this->month;
}

int Date::getYear() const {
    return this->year;
}


std::ostream& operator<<(std::ostream& out, const Date& date) {
    return out  << "Date is correct "
                << '('
                << date.getDay()
                << ',' << ' '
                << date.getMonth()
                << ',' << ' '
                << date.getYear() 
                << ')' << std::endl;
}
