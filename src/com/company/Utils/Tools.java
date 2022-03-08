package com.company.Utils;

import com.company.Menus.Menu;
import com.company.Treads.ThreadController;

public class Tools {
    public static void MainTask(int amountExpressions)
    {
        int answer;
        do {
            answer = Menu.mainMenu();

            switch (answer) {
                case 1:
                    ThreadController.workWithThreads(1, amountExpressions);
                    break;
                case 2:
                    ThreadController.workWithThreads(8, amountExpressions);
            }
        } while (answer != 0);
    }
}
