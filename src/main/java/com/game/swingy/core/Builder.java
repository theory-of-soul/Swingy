package com.game.swingy.core;

public interface Builder {

    public void setKindOfUnit(EnumUnitTypeField kindOfUnit);
    public void setName(String name);
    public void setHeroClass(String heroClass);
    public void setLevel(int level);
    public void setExperience(int experience);
    public void setAttack(int attack);
    public void setDefense(int defense);
    public void setHitPoints(int hitPoints);
    public void setArtefacts(Artefacts  artefacts);
    public void setCoordinates(Coordinates coordinates);

}
