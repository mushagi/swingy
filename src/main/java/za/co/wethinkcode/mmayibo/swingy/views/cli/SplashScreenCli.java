package za.co.wethinkcode.mmayibo.swingy.views.cli;

import za.co.wethinkcode.mmayibo.swingy.views.ISplashScreen;

public class SplashScreenCli implements ISplashScreen {
    @Override
    public void showSplashScreen() {
        String splashScreen = "" +
                "                 :~-._                                                 _.-~:\n" +
                "                  : :.~^o._        ________---------________        _.o^~.:.:\n"               +
                "                   : ::.`?88booo~~~.::::::::...::::::::::::..~~oood88P'.::.:\n"               +
                "                   :  ::: `?88P .:::....         ........:::::. ?88P' :::. :\n" +
                "                    :  :::. `? .::.            . ...........:::. P' .:::. :\n"               +
                "                     :  :::   ... ..  ...       .. .::::......::.   :::. :\n"               +
                "                     `  :' .... ..  .:::::.     . ..:::::::....:::.  `: .'\n"               +
                "                      :..    ____:::::::::.  . . ....:::::::::____  ... :\n"               +
                "                     :... `:~    ^~-:::::..  .........:::::-~^    ~::.::::\n"               +
                "                     `.::. `\\   (8)  \\b:::..::.:.:::::::d/  (8)   /'.::::'\n"               +
                "                      ::::.  ~-._v    |b.::::::::::::::d|    v_.-~..:::::\n"               +
                "                      `.:::::... ~~^?888b..:::::::::::d888P^~...::::::::'\n"               +
                "                       `.::::::::::....~~~ .:::::::::~~~:::::::::::::::'\n"               +
                "                        `..:::::::::::   .   ....::::    ::::::::::::,'\n"               +
                "                          `. .:::::::    .      .::::.    ::::::::'.'\n"               +
                "                            `._ .:::    .        :::::.    :::::_.'\n"               +
                "                               `-. :    .        :::::      :,-'\n"               +
                "                                  :.   :___     .:::___   .::\n"               +
                "                        ..--~~~~--:+::. ~~^?b..:::dP^~~.::++:--~~~~--..\n"               +
                "                          ___....--`+:::.    `~8~'    .:::+'--....___\n"               +
                "                        ~~   __..---`_=:: ___gd8bg___ :==_'---..__   ~~\n"               +
                "                         -~~~  _.--~~`-.~~~~~~~~~~~~~~~,-' ~~--._ ~~~-\n"               +
                "                            -~~            ~~~~~~~~~   _ Seal _  ~~-\n"               +
                "                         __              ___                           \n"               +
                "                        (_     o._  _     | ._  \\    /_.|  _.._  _| _. \n"               +
                "                        __)\\/\\/|| |(_|\\/ _|_| |  \\/\\/(_||<(_|| |(_|(_| \n"               +
                "                                    _|/                                \n\n"              ;
        System.out.println(splashScreen);

    }
}