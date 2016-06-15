#include "Unit.h"

void Unit::ensureIsAlive() {
   if ( hitPoints == 0 ) {
       throw UnitIsDead();
   }
}

Unit::Unit(const std::string& name, int hp, int dmg) {
    this->damage = dmg;
    this->hitPoints = hp;
    this->hitPointsLimit = hp;
    this->name = name;
}
Unit::~Unit() {

}

int Unit::getDamage() const {
    return this->damage;
}

int Unit::getHitPoints() const {
    return this->hitPoints;
}

int Unit::getHitPointsLimit() const {
    return this->hitPointsLimit;
}

const std::string& Unit::getName() const {
    return this->name;
}

void Unit::addHitPoints(int hp) {
    ensureIsAlive();

    if ( this->hitPoints + hp > hitPointsLimit ) {
        this->hitPoints = hitPointsLimit;
    } else {
        this->hitPoints += hp;
    }
}

void Unit::takeDamage(int dmg) {
    ensureIsAlive();

    if ( dmg > this->hitPoints ) {
        this->hitPoints = 0;
    } else {
        this->hitPoints -= dmg;
    }
}


void Unit::attack(Unit& enemy) {
    enemy.takeDamage(this->damage);

    if ( enemy.hitPoints > 0 ) {
        this->counterAttack(enemy);
    }
}

void Unit::counterAttack(Unit& enemy) {
    this->takeDamage(enemy.damage/2);
}

std::ostream& operator<<(std::ostream& out, const Unit& unit) {
    return out  << "    Unit: " << unit.getName()
                << "\n    hp: " << unit.getHitPoints() << '/' << unit.getHitPointsLimit()
                << "\n    Damage attack: " << unit.getDamage() << std::endl;
}