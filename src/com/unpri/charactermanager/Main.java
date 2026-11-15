
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.controller.CharacterController;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Membuat pengelola karakter
            CharacterManager manager = new CharacterManager();

            // Menambahkan 6 karakter
            manager.add(new Character(
                    "Arjuna", CharacterType.WARRIOR, 5
            ));

            manager.add(new Character(
                    "Merlin", CharacterType.MAGE, 3
            ));

            manager.add(new Character(
                    "Athena", CharacterType.ARCHER, 4
            ));

            manager.add(new Character(
                    "Hercules", CharacterType.WARRIOR, 7
            ));

            manager.add(new Character(
                    "Luna", CharacterType.HEALER, 6
            ));

            manager.add(new Character(
                    "Orion", CharacterType.ARCHER, 2
            ));

            // Membuat Controller
            CharacterController controller =
                    new CharacterController(manager);

            // Membuat dan menampilkan View
            MainWindow window = new MainWindow(controller);
            window.setVisible(true);
        });
    }
}
