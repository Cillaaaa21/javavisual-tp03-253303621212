
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {

    private static final int GOLD_LEVEL_THRESHOLD = 5;

    private final CharacterManager manager;
    private final JPanel characterPanel;

    private final JLabel totalLabel;
    private final JLabel averageLabel;
    private final JLabel highestLabel;
    private final JLabel roleCountLabel;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager - TP12");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // PANEL UTAMA
        JPanel mainPanel = new JPanel(
                new BorderLayout(12, 12));

        mainPanel.setBackground(AppTheme.BACKGROUND);
        mainPanel.setOpaque(true);
        mainPanel.setBorder(AppTheme.MAIN_PADDING_BORDER);

        // HEADER NORTH
        JPanel headerPanel = new JPanel(
                new BorderLayout(8, 8));

        headerPanel.setOpaque(false);

        JLabel titleLabel = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER);

        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.TEXT_COLOR);

        headerPanel.add(titleLabel, BorderLayout.NORTH);

        // PANEL STATISTIK TAMBAHAN
        JPanel statsPanel = new JPanel(
                new GridLayout(2, 2, 10, 8));

        statsPanel.setBackground(AppTheme.CARD_BACKGROUND);
        statsPanel.setBorder(AppTheme.CARD_BORDER);
        statsPanel.setOpaque(true);

        totalLabel = new JLabel("Total karakter: 0");
        averageLabel = new JLabel("Rata-rata level: 0.0");
        highestLabel = new JLabel("Level tertinggi: 0");
        roleCountLabel = new JLabel("Jumlah role: 0");

        JLabel[] statsLabels = {
            totalLabel, averageLabel,
            highestLabel, roleCountLabel
        };

        for (JLabel label : statsLabels) {
            label.setFont(AppTheme.BODY_FONT);
            label.setForeground(AppTheme.TEXT_COLOR);
            statsPanel.add(label);
        }

        headerPanel.add(statsPanel, BorderLayout.SOUTH);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // DAFTAR KARAKTER
        characterPanel = new JPanel(
                new GridLayout(0, 2, 12, 12));

        characterPanel.setBackground(AppTheme.BACKGROUND);
        characterPanel.setOpaque(true);

        // PANEL PEMBUNGKUS KARTU
        JPanel listWrapper = new JPanel(
                new BorderLayout());

        listWrapper.setBackground(AppTheme.BACKGROUND);
        listWrapper.setOpaque(true);

        listWrapper.add(characterPanel, BorderLayout.NORTH);

        // SCROLL PANE CENTER
        JScrollPane scrollPane =
                new JScrollPane(listWrapper);

        scrollPane.setBorder(null);

        scrollPane.setPreferredSize(
                new Dimension(650, 420));

        scrollPane.getViewport().setBackground(
                AppTheme.BACKGROUND);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // LEGENDA EAST
        JPanel legendPanel = new JPanel();

        legendPanel.setLayout(
                new BoxLayout(
                        legendPanel,
                        BoxLayout.Y_AXIS));

        legendPanel.setBackground(
                AppTheme.CARD_BACKGROUND);

        legendPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        AppTheme.CARD_BORDER,
                        BorderFactory.createEmptyBorder(
                                8, 8, 8, 8)));

        legendPanel.setPreferredSize(
                new Dimension(160, 100));

        JLabel legendTitle = new JLabel("LEGENDA ROLE");
        legendTitle.setFont(AppTheme.BODY_FONT);
        legendTitle.setForeground(AppTheme.TEXT_COLOR);

        legendPanel.add(legendTitle);
        legendPanel.add(Box.createVerticalStrut(15));

        for (CharacterType type : CharacterType.values()) {

            JLabel roleLabel = new JLabel("● " + type);

            roleLabel.setFont(AppTheme.BODY_FONT);
            roleLabel.setForeground(AppTheme.TEXT_COLOR);

            roleLabel.setOpaque(true);
            roleLabel.setBackground(
                    AppTheme.colorFor(type));

            roleLabel.setBorder(AppTheme.borderFor(type));

            legendPanel.add(roleLabel);
            legendPanel.add(Box.createVerticalStrut(10));
        }

        legendPanel.add(Box.createVerticalGlue());

        mainPanel.add(legendPanel, BorderLayout.EAST);

        // STATUS BAR SOUTH
        JPanel statusPanel = new JPanel(
                new BorderLayout());

        statusPanel.setBackground(
                AppTheme.CARD_BACKGROUND);

        statusPanel.setBorder(AppTheme.CARD_BORDER);
        statusPanel.setOpaque(true);

        JLabel statusLabel = new JLabel(
                "Character Manager siap digunakan");

        statusLabel.setFont(AppTheme.BODY_FONT);
        statusLabel.setForeground(AppTheme.TEXT_COLOR);

        JLabel versionLabel = new JLabel("v0.5");

        versionLabel.setFont(AppTheme.BODY_FONT);
        versionLabel.setForeground(AppTheme.GOLD);

        statusPanel.add(statusLabel, BorderLayout.WEST);
        statusPanel.add(versionLabel, BorderLayout.EAST);

        mainPanel.add(statusPanel, BorderLayout.SOUTH);

        // MENAMPILKAN PANEL UTAMA
        setContentPane(mainPanel);

        refreshCharacters();

        pack();
        setMinimumSize(new Dimension(650, 450));
        setLocationRelativeTo(null);
    }

    // MEMPERBARUI DATA KARAKTER
    public void refreshCharacters() {

        characterPanel.removeAll();

        List<Character> characters = manager.getAll();

        int totalLevel = 0;
        int highestLevel = 0;

        Set<CharacterType> roles = new HashSet<>();

        for (Character character : characters) {

            characterPanel.add(
                    createCharacterCard(character));

            totalLevel += character.getLevel();

            highestLevel = Math.max(
                    highestLevel,
                    character.getLevel());

            roles.add(character.getType());
        }

        totalLabel.setText(
                "Total karakter: " + characters.size());

        double averageLevel = characters.isEmpty()
                ? 0.0
                : (double) totalLevel / characters.size();

        averageLabel.setText(
                String.format(
                        "Rata-rata level: %.1f",
                        averageLevel));

        highestLabel.setText(
                "Level tertinggi: " + highestLevel);

        roleCountLabel.setText(
                "Jumlah role: " + roles.size());

        characterPanel.revalidate();
        characterPanel.repaint();
    }

    // MEMBUAT KARTU KARAKTER
    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel(
                new GridLayout(0, 1, 4, 4));

        card.setBackground(
                AppTheme.colorFor(character.getType()));

        card.setBorder(
                AppTheme.borderFor(character.getType()));

        card.setOpaque(true);

        // NAMA
        JLabel nameLabel =
                new JLabel(character.getName());

        nameLabel.setFont(AppTheme.NAME_FONT);
        nameLabel.setForeground(AppTheme.TEXT_COLOR);

        // ROLE
        JLabel typeLabel =
                new JLabel("Role: " + character.getType());

        typeLabel.setFont(AppTheme.BODY_FONT);
        typeLabel.setForeground(AppTheme.TEXT_COLOR);

        // LEVEL
        JLabel levelLabel =
                new JLabel("Level: " + character.getLevel());

        levelLabel.setFont(AppTheme.BODY_FONT);
        levelLabel.setForeground(AppTheme.TEXT_COLOR);

        if (character.getLevel() >= GOLD_LEVEL_THRESHOLD) {

            levelLabel.setForeground(AppTheme.GOLD);
            levelLabel.setFont(AppTheme.GOLD_LEVEL_FONT);
        }

        // HP
        JLabel hpLabel =
                new JLabel("HP: " + character.getHitPoints());

        hpLabel.setFont(AppTheme.BODY_FONT);
        hpLabel.setForeground(AppTheme.TEXT_COLOR);

        // ATTACK POWER
        JLabel attackLabel =
                new JLabel(
                        "Attack Power: "
                        + character.getAttackPower());

        attackLabel.setFont(AppTheme.BODY_FONT);
        attackLabel.setForeground(AppTheme.TEXT_COLOR);

        card.add(nameLabel);
        card.add(typeLabel);
        card.add(levelLabel);
        card.add(hpLabel);
        card.add(attackLabel);

        card.setToolTipText(
                character.getName()
                + " - " + character.getType()
                + " - HP: " + character.getHitPoints()
                + " - Attack: " + character.getAttackPower());

        return card;
    }
}
