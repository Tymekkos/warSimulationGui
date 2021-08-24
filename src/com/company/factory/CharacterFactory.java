package com.company.factory;

import com.company.model.*;

import java.util.Random;

import static com.company.stats.StatsRepository.*;

public class CharacterFactory {
    public static ICharacter getRandomCharacter(){
        Random random = new Random();
        int randomNumber = random.nextInt(6);

        return switch (randomNumber) {
            case 0 -> new Hunter((int) (MAX_ATTACK* BASE_HUNTER_ATTACK_PERCENTAGE), (int) (MAX_HP* BASE_HUNTER_HP_PERCENTAGE), (int) (MAX_ARMOR* BASE_HUNTER_ARMOR_PERCENTAGE));
            case 1 -> new Assassin((int) (MAX_ATTACK* BASE_ASSASSIN_ATTACK_PERCENTAGE), (int) (MAX_HP* BASE_ASSASSIN_HP_PERCENTAGE), (int) (MAX_ARMOR* BASE_ASSASSIN_ARMOR_PERCENTAGE));
            case 2 -> new Warrior((int) (MAX_ATTACK* BASE_WARRIOR_ATTACK_PERCENTAGE), (int) (MAX_HP * BASE_WARRIOR_HP_PERCENTAGE), (int) (MAX_ARMOR* BASE_WARRIOR_ARMOR_PERCENTAGE));
            case 3 -> new Mage((int) (MAX_ATTACK* BASE_MAGE_ATTACK_PERCENTAGE), (int) (MAX_HP * BASE_MAGE_HP_PERCENTAGE), (int) (MAX_ARMOR* BASE_MAGE_ARMOR_PERCENTAGE));
            case 4 -> new Slayer((int) (MAX_ATTACK* BASE_SLAYER_ATTACK_PERCENTAGE), (int) (MAX_HP * BASE_SLAYER_HP_PERCENTAGE), (int) (MAX_ARMOR* BASE_SLAYER_ARMOR_PERCENTAGE));
            case 5 -> new Tank((int) (MAX_ATTACK* BASE_TANK_ATTACK_PERCENTAGE), (int) (MAX_HP * BASE_TANK_HP_PERCENTAGE), (int) (MAX_ARMOR* BASE_TANK_ARMOR_PERCENTAGE));
            default -> null;
        };
    }
    public static ICharacter getParticularCharacter(ICharacter character){
        if(character.getClass().toString().equals(Assassin.class.toString())) {
            return new Assassin((int) (0.8*character.getAttack()), (int) (0.8*character.getHP()), character.getArmor());
        }
        else if(character.getClass().toString().equals(Hunter.class.toString())) {
            return new Hunter((int) (0.8*character.getAttack()), (int) (0.8*character.getHP()), character.getArmor());
        }
        else if(character.getClass().toString().equals(Mage.class.toString())) {
            return new Mage((int) (0.8*character.getAttack()), (int) (0.8*character.getHP()), character.getArmor());
        }
        else if(character.getClass().toString().equals(Slayer.class.toString())) {
            return new Slayer((int) (0.8*character.getAttack()), (int) (0.8*character.getHP()), character.getArmor());
        }
        else if(character.getClass().toString().equals(Tank.class.toString())) {
            return new Tank((int) (0.8*character.getAttack()), (int) (0.8*character.getHP()), character.getArmor());
        }
        else if(character.getClass().toString().equals(Warrior.class.toString())) {
            return new Warrior((int) (0.8*character.getAttack()), (int) (0.8*character.getHP()), character.getArmor());
        }
        else{
            return null;
        }
    }
}
