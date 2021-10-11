package com.company.model;

import java.util.Random;

import static com.company.stats.StatsRepository.BASE_SLAYER_HP_PERCENTAGE;
import static com.company.stats.StatsRepository.MAX_HP;

//ignores armor, deals damage based on max health
public class  Slayer extends Character implements ICharacter{

    public Slayer(int attack, int hp, int armor) {
        this.attack = attack;
        this.hp = hp;
        this.armor = armor;
        this.age = 0;
        this.color = "orange";
    }

    @Override
    public String toString(){
        return "S";
    }

    @Override
    public int attack(int opponentArmor) {
        // hp = 400 attack = 20-30 armor = 15 jesli max zdrowie przeciwnika jest 2 razy wieksze od slayera atakuje on wtedy 2 razy mocniej
        Random random = new Random();
        int value = random.nextInt(99)+1;
        int armorValue = random.nextInt(99)+1;
        int tmpAttack = (value*attack)/100 - (opponentArmor*armorValue)/100;
        if(tmpAttack <= 0){
            tmpAttack = 0;
        }
        //System.out.println("Slayer attacked!");
        return tmpAttack;
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
        this.hp = (int) (MAX_HP* BASE_SLAYER_HP_PERCENTAGE);
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
