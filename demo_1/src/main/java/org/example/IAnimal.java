package org.example;

import org.example.IMammal;
import org.example.IReptile;

sealed interface IAnimal permits IMammal, IReptile {
}
