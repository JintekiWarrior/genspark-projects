package com.company;

import GameArt.GameArt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)
    {
        GameArt gameArt = new GameArt();
        System.out.println(gameArt.getGameArt(1));
    }

}
