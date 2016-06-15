#include "Paper.h"

Paper::Paper(int maxSymbols) { 
    this->maxSymbols = maxSymbols;
    this->symbols = 0;
    this->content = std::string();
}
Paper::~Paper() { 

}

int Paper::getMaxSymbols() const { 
    return this->maxSymbols;
}

int Paper::getSymbols() const { 
    return this->symbols;
}

void Paper::addContent(const std::string& message) { 
int total = content.length() + message.length();

if ( total > maxSymbols ) {
    content += message.substr(0, maxSymbols-symbols-1);
    symbols = maxSymbols;
    throw OutOfSpace();
}
content += message;
symbols = total;
}

void Paper::show() const { 
    std::cout << content << std::endl;
}