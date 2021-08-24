package com.company.map;

import com.company.model.ICharacter;

import java.util.List;

public class WorldMapUtils {
    private static ICharacter pvp(ICharacter character1, ICharacter character2){
        //returns lost unit
        int counter = 0;
        while((character1.getHP() > 0 && character2.getHP() > 0) && counter <=50){
            int damage1 = character1.attack(character2.getArmor());
            int damage2 = character2.attack(character1.getArmor());
            character2.setHP(character2.getHP() - damage1);
            character1.setHP(character1.getHP() - damage2);
            counter++;
        }
        if(counter > 50){
            if(character1.getHP() >  character2.getHP()){
                return character2;
            }
            else{
                return character1;
            }
        }
        if(character1.getHP() > 0)
            return character2;
        else
            return character1;

    }

    public static void pvpForList(List<ICharacter> characters) {
        ICharacter loser;
        if(characters.size()>1){
            while(!isAllTheSameProfession(characters)){
                int i=1;
                while(i<characters.size()){
                    if(!characters.get(i-1).isTheSameProfession(characters.get(i))){
                        loser=pvp(characters.get(i-1), characters.get(i));
                        characters.remove(loser);
                    }
                    else{
                        i++;
                    }
                }
            }
        }
    }

    private static boolean isAllTheSameProfession(List<ICharacter> characters){
        if(characters.size() == 1){
            return true;
        }
        for(int i=1; i<characters.size(); i++){
            if (!characters.get(i-1).isTheSameProfession(characters.get(i))){
                return false;
            }
        }
        return true;

    }

}
