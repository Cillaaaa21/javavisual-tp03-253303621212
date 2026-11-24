
package com.unpri.charactermanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

public class CharacterFormPanel extends JPanel {

    private final CharacterManager manager;
    private final Runnable onAdded;

    private final JTextField nameField = new JTextField(14);

    private final JComboBox<CharacterType> roleBox =
            new JComboBox<>(CharacterType.values());

    private final JSpinner levelSpinner =
            new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));

    private final JLabel messageLabel = new JLabel(" ");

    private final Border nameBorder;
    private final Border levelBorder;

    public CharacterFormPanel(
            CharacterManager manager,
            Runnable onAdded
    ) {

        this.manager = manager;
        this.onAdded = onAdded;

        setLayout(new BorderLayout());
        setBackground(AppTheme.PANEL_BACKGROUND);

        setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(92, 77, 133), 1
                        ),
                        BorderFactory.createEmptyBorder(
                                14, 12, 14, 12
                        )
                )
        );

        setPreferredSize(new Dimension(255, 0));

        // =========================
        // FORM TITLE
        // =========================

        JLabel title = new JLabel("✦ CREATE NEW HERO");

        title.setFont(
                AppTheme.BODY_FONT.deriveFont(Font.BOLD, 16f)
        );

        title.setForeground(AppTheme.GOLD_LIGHT);

        JLabel subtitle = new JLabel(
                "Build your legendary team"
        );

        subtitle.setFont(AppTheme.MONO_FONT);
        subtitle.setForeground(AppTheme.TEXT_MUTED);

        // =========================
        // INPUT STYLING
        // =========================

        styleTextField(nameField);

        roleBox.setFont(AppTheme.BODY_FONT);
        roleBox.setBackground(Color.WHITE);
        roleBox.setForeground(new Color(35, 27, 53));

        levelSpinner.setFont(AppTheme.BODY_FONT);
        levelSpinner.setBackground(Color.WHITE);

        levelSpinner.setBorder(
                BorderFactory.createLineBorder(
                        new Color(110, 91, 151), 1
                )
        );

        JSpinner.DefaultEditor editor =
                (JSpinner.DefaultEditor) levelSpinner.getEditor();

        editor.getTextField().setBackground(Color.WHITE);
        editor.getTextField().setForeground(
                new Color(35, 27, 53)
        );

        // Simpan border normal
        nameBorder = nameField.getBorder();
        levelBorder = levelSpinner.getBorder();

        // =========================
        // MESSAGE
        // =========================

        messageLabel.setFont(
                AppTheme.BODY_FONT.deriveFont(Font.BOLD, 12f)
        );

        messageLabel.setForeground(AppTheme.TEXT_MUTED);

        // =========================
        // SAVE BUTTON
        // =========================

        JButton saveButton = new JButton("✦  SIMPAN HERO");

        saveButton.setFont(
                AppTheme.BODY_FONT.deriveFont(Font.BOLD, 13f)
        );

        saveButton.setBackground(AppTheme.BUTTON_BACKGROUND);
        saveButton.setForeground(AppTheme.BUTTON_TEXT);
        saveButton.setFocusPainted(false);
        saveButton.setOpaque(true);

        saveButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                AppTheme.GOLD_LIGHT, 1
                        ),
                        BorderFactory.createEmptyBorder(
                                10, 12, 10, 12
                        )
                )
        );

        saveButton.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        saveButton.addActionListener(e -> onSave());
        nameField.addActionListener(e -> onSave());

        // =========================
        // FORM ROWS
        // =========================

        JPanel rows = new JPanel();

        // Menggunakan BoxLayout agar tinggi komponen
        // mengikuti ukuran masing-masing komponen
        rows.setLayout(
                new BoxLayout(rows, BoxLayout.Y_AXIS)
        );

        rows.setOpaque(false);

        title.setAlignmentX(LEFT_ALIGNMENT);
        subtitle.setAlignmentX(LEFT_ALIGNMENT);
        messageLabel.setAlignmentX(LEFT_ALIGNMENT);
        saveButton.setAlignmentX(LEFT_ALIGNMENT);

        rows.add(title);
        rows.add(subtitle);

        rows.add(makeLabel("NAMA HERO", nameField));
        rows.add(nameField);

        rows.add(makeLabel("ROLE", roleBox));
        rows.add(roleBox);

        rows.add(makeLabel("LEVEL", levelSpinner));
        rows.add(levelSpinner);

        rows.add(messageLabel);
        rows.add(saveButton);

        add(rows, BorderLayout.NORTH);
    }

    // =========================
    // TEXT FIELD STYLE
    // =========================

    private void styleTextField(JTextField field) {

        field.setFont(AppTheme.BODY_FONT);
        field.setBackground(Color.WHITE);
        field.setForeground(new Color(35, 27, 53));
        field.setCaretColor(AppTheme.MAGE_COLOR);

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(110, 91, 151), 1
                        ),
                        BorderFactory.createEmptyBorder(
                                7, 8, 7, 8
                        )
                )
        );
    }

    // =========================
    // LABEL
    // =========================

    private JLabel makeLabel(
            String text,
            JComponent target
    ) {

        JLabel label = new JLabel(text);

        label.setFont(
                AppTheme.BODY_FONT.deriveFont(Font.BOLD, 12f)
        );

        label.setForeground(AppTheme.TEXT_MUTED);
        label.setLabelFor(target);
        label.setAlignmentX(LEFT_ALIGNMENT);

        return label;
    }

    // =========================
    // SAVE PROCESS
    // =========================

    private void onSave() {

        clearMessage();

        String name = nameField.getText().trim();

        String problem = validateName(name);

        if (problem != null) {
            showError(problem, nameField);
            return;
        }

        // Membaca spinner setelah commitEdit()
        try {

            levelSpinner.commitEdit();

        } catch (ParseException | IllegalArgumentException ex) {

            showError(
                    "Level harus berupa angka antara 1 dan 99",
                    levelSpinner
            );

            return;
        }

        CharacterType role =
                (CharacterType) roleBox.getSelectedItem();

        int level = (Integer) levelSpinner.getValue();

        // Membuat karakter melalui Model
        try {

            Character newCharacter =
                    new Character(name, role, level);

            boolean added = manager.addCharacter(newCharacter);

            if (!added) {
                showError("Nama sudah dipakai!", nameField);
                return;
            }

        } catch (IllegalArgumentException ex) {

            showError(ex.getMessage(), levelSpinner);
            return;
        }

        // Jika berhasil
        nameField.setText("");
        roleBox.setSelectedIndex(0);
        levelSpinner.setValue(1);

        showSuccess("Hero berhasil ditambahkan: " + name);

        nameField.requestFocusInWindow();

        // Memperbarui daftar karakter
        onAdded.run();
    }

    // =========================
    // NAME VALIDATION
    // =========================

    private String validateName(String name) {

        // 1. Kelengkapan
        if (name.isEmpty()) {
            return "Nama wajib diisi!";
        }

        // 2. Panjang
        if (name.length() < 3 || name.length() > 20) {
            return "Nama harus 3-20 karakter!";
        }

        // 3. Format
        if (!name.matches("[A-Za-z ]+")) {
            return "Nama hanya boleh berisi huruf dan spasi!";
        }

        // 4. Keunikan
        if (manager.isNameTaken(name)) {
            return "Nama sudah dipakai!";
        }

        return null;
    }

    // =========================
    // ERROR MESSAGE
    // =========================

    private void showError(
            String text,
            JComponent source
    ) {

        messageLabel.setText(text);
        messageLabel.setForeground(AppTheme.ERROR);

        source.setBorder(
                BorderFactory.createLineBorder(
                        AppTheme.ERROR, 2
                )
        );

        source.requestFocusInWindow();

        if (source == levelSpinner) {
            levelSpinner.getEditor().requestFocusInWindow();
        }
    }

    // =========================
    // SUCCESS MESSAGE
    // =========================

    private void showSuccess(String text) {

        messageLabel.setText(text);
        messageLabel.setForeground(AppTheme.SUCCESS);
    }

    // =========================
    // RESET MESSAGE
    // =========================

    private void clearMessage() {

        messageLabel.setText(" ");

        nameField.setBorder(nameBorder);
        levelSpinner.setBorder(levelBorder);
    }
}
