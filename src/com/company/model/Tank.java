package com.company.model;

import java.util.Random;

import static com.company.stats.StatsRepository.BASE_TANK_HP_PERCENTAGE;
import static com.company.stats.StatsRepository.MAX_HP;

public class Tank extends Character implements ICharacter{

    public Tank(int attack, int hp, int armor) {
        this.attack = attack;
        this.hp = hp;
        this.armor = armor;
        this.age = 0;
        this.color = "#006400";
    }

    @Override
    public String toString(){
        return "T";
    }

    @Override
    public int attack(int opponentArmor){
        // hp = 1000 attack = 10 armor = 50 20%chance to fully block an attack
        Random random = new Random();
        int armorValue = random.nextInt(99)+1;
        int value = random.nextInt(99)+1;
        int blockChance = random.nextInt(99)+1;
        int tmpAttack = (value*attack)/100 - (opponentArmor*armorValue)/100;
        if(blockChance <= 20)
        {
            //block an attack
        }
        if (tmpAttack <=0)
        {
            tmpAttack = 0;
        }
        //System.out.println("Tank attacked!");
        return attack;
    }

    @Override
    public int getHP() {
        return this.hp;
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
        this.hp = hp;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public void restartHP() {
        this.hp = (int) (MAX_HP* BASE_TANK_HP_PERCENTAGE);
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}