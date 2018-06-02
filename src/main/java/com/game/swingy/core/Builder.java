package com.game.swingy.core;

public interface Builder {

    public void setName(String name);
    public void setHeroClass(String heroClass);
    public void setLevel(int level);
    public void setExperience(int experience);
    public void setAttack(int attack);
    public void setDefense(int defense);
    public void setHitPoints(int hitPoints);
    public void setArtefacts(String  artefacts); //TODO переробити під клас
    public void setCoorditnates(Coorditnates coorditnates);

}
