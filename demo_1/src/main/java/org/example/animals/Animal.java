package org.example.animals;

sealed interface Animal permits Dog, Cat {
    void makeSound();
}

final class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Voff voff!");
    }
}

final class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Mjau mjau!");
    }
}
