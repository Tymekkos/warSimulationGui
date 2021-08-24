package com.company.model;

import java.util.Random;

import static com.company.stats.StatsRepository.BASE_ASSASSIN_HP_PERCENTAGE;
import static com.company.stats.StatsRepository.MAX_HP;

//big dmg to low max health targets (struggles against tanks)
public class Assassin extends Character implements ICharacter{
    public Assassin(int attack, int hp, int armor) {
        this.attack = attack;
        this.hp = hp;
        this.armor = armor;
        this.age = 0;
    }

    @Override
    public String toString(){
        return "A";
    }

    @Override
    public int attack(int opponentArmor) {
        // hp = 400 attack = 40 armor = 20 jesli pzdorwie przeciwnika jest takie samo lub
        // mniejesze od assasina - zadawaj 25% wiecvej obrazen
        Random random = new Random();
        int value = random.nextInt(99)+1;
        int armorValue = random.nextInt(99)+1;
        int tmpAttack = (value*attack)/100 - (opponentArmor*armorValue)/100;
        if(tmpAttack <= 0){
            tmpAttack = 0;
        }
        //System.out.println("Assassin attacked!");
        return tmpAttack;
    }

    @Override
    public int getHP() {
        return 0;
    }

    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public void setAttack(int attack) {

    }

    @Override
    public void setHP(int hp) {

    }

    @Override
    public int getArmor() {
        return 0;
    }

    @Override
    public void restartHP() {
        this.hp = (int) (MAX_HP* BASE_ASSASSIN_HP_PERCENTAGE);
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }


}

