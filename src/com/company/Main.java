package com.company;

import java.util.Random;

public class Main {

    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefenseType = "";
    public static int[] heroesHealth = {260, 270, 300, 150,350,1000};
    public static int[] heroesDamage = {10, 20, 5,30,15};
    public static String[] heroesAttackType = {"physical", "magical", "mental", "lucky", "thor" };
    public static int medicheal = 100;
    public static int Chance ;



    public static void lucky(){
        if (heroesHealth[3] > 0){
            heroesHealth[3] += 50;

        }
    }

    public static void thor(){
        if (heroesHealth[4] > 0){


        }
    }




    public static void medicHeal(){
        if (heroesHealth[3] > 0) {
            for (int i = 0; i < heroesHealth.length-1 ; i++) {
                if (heroesHealth [i] < 100 && heroesHealth[i] > 0){
                    heroesHealth [i] = medicheal + heroesHealth[i];
                    System.out.println(" медик вылечил "  + heroesAttackType[i]);}
                        break;
            }
        }
    }

    public static void main(String[] args) {
        while(!isFinished()){
            round();
        }

    }
     public static void round(){
         Random random = new Random ();
         Chance = random.nextInt(5);
        printStatistics();
         System.out.println("round was started!");
         System.out.println("Chance Number "+Chance);
         heroesHit();
         changeBossDefence();
        if (Chance != 3) bosshit();
        else System.out.println(" тор оглушил босса ");
         medicHeal();
         Chance();
       //  printStatistics();

     }

     public static void Chance (){

        if (Chance == 2 ) lucky();
        if (Chance == 3) thor();

        }


    public static void printStatistics() {
        System.out.println("------------------");
        System.out.println("boss health:" + bossHealth);
        System.out.println("warrior health:" + heroesHealth[0]);
        System.out.println("magic health:" + heroesHealth[1]);
        System.out.println("kinetic health:" + heroesHealth[2]);
        System.out.println("medic health: "+ heroesHealth[3]);
        System.out.println("------------------");
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesHealth.length-1; i++) {
            if (bossHealth > 0 && heroesHealth[i] > 0) {
                if (bossHealth - heroesDamage[i] < 0) bossHealth = 0;
                else bossHealth = bossHealth - heroesDamage[i];
            }
        }
    }

    public static void bosshit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (heroesHealth[i] - bossDamage < 0) heroesHealth[i] = 0;
                else heroesHealth[i] = heroesHealth[i] - bossDamage;
            }
        }
    }

    public static boolean isFinished (){
        if (bossHealth <= 0) {
            System.out.println("heroes won!!!");
            return true;

        }
         if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0 ){
             System.out.println("boss won!!!");
             return true;
         }
         return false;
    }

    public static void changeBossDefence(){
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefenseType = heroesAttackType[randomIndex];
        System.out.println("Boss defence type:" + bossDefenseType);
    }
}
