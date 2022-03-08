package com.company.Menus;

import com.company.Utils.Input;
import com.sun.nio.sctp.SctpSocketOption;

import java.util.Scanner;

public class Menu {

    /**
     * Меню выбора режима работы
     */
    public static int mainMenu() {
        System.out.println("Выберите действие из списка:");
        System.out.println("1 - вычисления в однопоточном режиме");
        System.out.println("2 - вычисления в многопоточном режиме");
        System.out.println("0 - завершить работу");
        return Input.inputNum(0, 2, "Введите число: ");
    }
}
