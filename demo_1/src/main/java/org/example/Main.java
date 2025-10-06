package org.example;

import static org.example.AnimalUtil.checkAnimalType;

public class Main {
    public static void main(String[] args) {

        /* Uppgfit #6 */
       /* Person person = new Person("Anna");
        System.out.println(person);
        System.out.println("Namnet är: " + person.name());*/
        /* RESULTAT Getter: Person[name=Anna], Namnet är: Anna */
        /* Det gick inte att använda setter, alltså ändra namn*/


      /* Uppgift #7 */
       /* int number = 1;

        switch (number) {
            case 0:
                System.out.println("Case 0 körs!");
                break;
            case 1:
                System.out.println("Case 1 körs!");
                break;
        } // Skapade en switch case men inget härnvisades till enchanted switch (version 16)*/

        /* Uppgift #8 */
        /*Sealed är till för att begränsa åtkomst.
        Permits är vad som tillåts.
        Non-sealed tillåter oss att öppna upp igen för bättre kontrollering!*/
        /*Animal dog = new Dog();
        Animal cat = new Cat();

        dog.makeSound();
        cat.makeSound();*/

        /*Uppgift #9*/

        IAnimal rabbit = new Rabbit();
        IAnimal snake = new Snake();

        checkAnimalType(rabbit);
        checkAnimalType(snake);


    }
}