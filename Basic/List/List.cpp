#include "List.h"

List::List(int capacity, double multiplier) {
    this-> array = (int*)malloc(capacity*sizeof(int));

    if ( array == NULL ) {
        throw OutOfMemoryException();
    }

    this->capacity = capacity;
    this->multiplier = multiplier;
    this->current = 0;
}

List::~List() {

}

int List::size() const {
    return this->current;
}

int List::max_size() const {
    return this->capacity;
}

void List::erase(int index) {
    if ( index < this->current && index >= 0 ) {
        for (int i = index, j = i + 1; i < this->current; i++, j++ ) {
            array[i] = array[j];
        }
    } else {
        throw OutOfMemoryException();
    }
    this->current -= 1;
}

void List::insert(int value, int index) {
    if ( index < this->current && index >= 0 ) {
            array[index] = value;
    } else {
        throw OutOfMemoryException();
    }
}

int List::find(int value) const {
    int temp = 0;

    for ( int i = 0; i < this->current; i++ ) {
        if ( array[i] == value ) {
            temp = array[i];
        }
    }
    if ( !temp ) {
        return temp;
    } else {
        return -1;
    }
}

void List::push_back(int value) {
   int newCurrent = current + 1;

   if ( newCurrent > capacity ) {
       int newCapacity = capacity * multiplier;
       int* newArray = (int*)realloc(array, newCapacity*sizeof(int));

       if ( newArray == NULL ) {
           throw OutOfMemoryException();
       }

       capacity = newCapacity;
       array = newArray;
   }
   array[current] = value;
   current = newCurrent;
}

int List::pop_back() {
   if ( current == 0 ) {
       throw ZeroLenException();
   }
   current -= 1;
   return array[current];
}

void List::sort() {
    for ( int i = 1; i < this->current; i++ ) {
        for ( int j = i, k = j - 1; j > 0 && array[j] < array[k] ; j--, k-- ) {
            int temp = array[j];

            array[j] = array[k];
            array[k] = temp;
        }
    }
}


int List::operator[](int index) const {
    return this->array[index];
}

bool List::operator==(const List& other) const {
    for (int i = 0; this->array[i] != '\0'; i++ ) {
        if ( array[i] != other[i] ) {
            return false;
        }
    }
    return true;
}

bool List::operator!=(const List& other) const {
    return !(*this==other);
}



std::ostream& operator<<(std::ostream& out, const List& list) {
    if ( list.size() == 0) {
        out << 0;
    } else {
        int last = list.size() - 1;

        for ( int i = 0; i < last; i++ ) {
            out << list[i] << ' ';
        }
        out << list[last];
     }
    return out;
}