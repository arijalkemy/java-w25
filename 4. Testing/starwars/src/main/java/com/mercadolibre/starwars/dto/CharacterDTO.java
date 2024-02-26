package com.mercadolibre.starwars.dto;

import java.util.Objects;

public class CharacterDTO {
  private String name;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;

  public CharacterDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHair_color() {
    return hair_color;
  }

  public void setHair_color(String hair_color) {
    this.hair_color = hair_color;
  }

  public String getSkin_color() {
    return skin_color;
  }

  public void setSkin_color(String skin_color) {
    this.skin_color = skin_color;
  }

  public String getEye_color() {
    return eye_color;
  }

  public void setEye_color(String eye_color) {
    this.eye_color = eye_color;
  }

  public String getBirth_year() {
    return birth_year;
  }

  public void setBirth_year(String birth_year) {
    this.birth_year = birth_year;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getHomeworld() {
    return homeworld;
  }

  public void setHomeworld(String homeworld) {
    this.homeworld = homeworld;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getMass() {
    return mass;
  }

  public void setMass(Integer mass) {
    this.mass = mass;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CharacterDTO)) return false;
    CharacterDTO that = (CharacterDTO) o;
    return Objects.equals(getName(), that.getName()) && Objects.equals(getHair_color(), that.getHair_color()) && Objects.equals(getSkin_color(), that.getSkin_color()) && Objects.equals(getEye_color(), that.getEye_color()) && Objects.equals(getBirth_year(), that.getBirth_year()) && Objects.equals(getGender(), that.getGender()) && Objects.equals(getHomeworld(), that.getHomeworld()) && Objects.equals(getSpecies(), that.getSpecies()) && Objects.equals(getHeight(), that.getHeight()) && Objects.equals(getMass(), that.getMass());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getHair_color(), getSkin_color(), getEye_color(), getBirth_year(), getGender(), getHomeworld(), getSpecies(), getHeight(), getMass());
  }
}
