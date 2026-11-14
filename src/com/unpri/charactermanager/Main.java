
package com.unpri.charactermanager;

import com.unpri.charactermanager.controller.CharacterController;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            CharacterManager manager = new CharacterManager();

            manager.addCharacter(new Character("Aragorn", CharacterType.WARRIOR, 5));
            manager.addCharacter(new Character("Gandalf", CharacterType.MAGE, 3));
            manager.addCharacter(new Character("Legolas", CharacterType.ARCHER, 4));
            manager.addCharacter(new Character("Evelyn", CharacterType.HEALER, 6));
            manager.addCharacter(new Character("Alucard", CharacterType.MAGE, 10));

            CharacterController controller =
                    new CharacterController(manager);

            MainWindow view = new MainWindow(controller);

            view.setVisible(true);
        });
    }
}
