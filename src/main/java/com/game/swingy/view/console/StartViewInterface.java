package com.game.swingy.view.console;

import javax.swing.*;

public interface StartViewInterface {

    ListenerInterface getBtnCreateHero(); // здесь не JButton должен быть а какой-то наш абстрактный interface
    ListenerInterface getBtnPreviouslyHero();
}