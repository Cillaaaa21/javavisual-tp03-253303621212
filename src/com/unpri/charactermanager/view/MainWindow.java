
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

        setTitle("Character Manager - TP14");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(14, 14));
        mainPanel.setBackground(AppTheme.BACKGROUND);
        mainPanel.setBorder(AppTheme.MAIN_PADDING_BORDER);

        // =========================
        // HEADER
        // =========================

        JPanel headerPanel = new JPanel(new BorderLayout(5, 5));
        headerPanel.setOpaque(false);

        JLabel titleLabel = new JLabel(
                "✦ CHARACTER MANAGER ✦",
                SwingConstants.CENTER
        );

        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.GOLD_LIGHT);

        JLabel subtitleLabel = new JLabel(
                "CREATE YOUR OWN LEGENDARY TEAM",
                SwingConstants.CENTER
        );

        subtitleLabel.setFont(AppTheme.MONO_FONT);
        subtitleLabel.setForeground(AppTheme.TEXT_MUTED);

        JPanel titleBox = new JPanel(new GridLayout(2, 1, 0, 5));
        titleBox.setOpaque(false);
        titleBox.add(titleLabel);
        titleBox.add(subtitleLabel);

        headerPanel.add(titleBox, BorderLayout.NORTH);

        // =========================
        // STATISTICS
        // =========================

        JPanel statsPanel = new JPanel(
                new GridLayout(1, 4, 12, 0)
        );

        statsPanel.setOpaque(false);
        statsPanel.setBorder(
                BorderFactory.createEmptyBorder(12, 0, 0, 0)
        );

        totalLabel = createStatCard(
                "TOTAL HEROES", "0", new Color(53, 91, 145)
        );

        averageLabel = createStatCard(
                "AVERAGE LEVEL", "0.0", new Color(104, 69, 163)
        );

        highestLabel = createStatCard(
                "HIGHEST LEVEL", "0", new Color(141, 53, 72)
        );

        roleCountLabel = createStatCard(
                "ACTIVE ROLES", "0", new Color(40, 120, 93)
        );

        statsPanel.add(totalLabel);
        statsPanel.add(averageLabel);
        statsPanel.add(highestLabel);
        statsPanel.add(roleCountLabel);

        headerPanel.add(statsPanel, BorderLayout.SOUTH);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // =========================
        // CHARACTER LIST
        // =========================

        characterPanel = new JPanel(
                new GridLayout(0, 2, 14, 14)
        );

        characterPanel.setBackground(AppTheme.BACKGROUND);
        characterPanel.setOpaque(true);
        characterPanel.setBorder(
                BorderFactory.createEmptyBorder(4, 4, 4, 4)
        );

        JPanel listWrapper = new JPanel(new BorderLayout());
        listWrapper.setBackground(AppTheme.BACKGROUND);
        listWrapper.add(characterPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(listWrapper);
        scrollPane.setBorder(
                BorderFactory.createLineBorder(
                        new Color(92, 77, 133), 1
                )
        );

        scrollPane.setPreferredSize(new Dimension(650, 420));
        scrollPane.getViewport().setBackground(AppTheme.BACKGROUND);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // =========================
        // FORM
        // =========================

        CharacterFormPanel formPanel =
                new CharacterFormPanel(
                        manager,
                        this::refreshList
                );

        mainPanel.add(formPanel, BorderLayout.WEST);

        // =========================
        // ROLE LEGEND
        // =========================

        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(
                new BoxLayout(legendPanel, BoxLayout.Y_AXIS)
        );

        legendPanel.setBackground(AppTheme.CARD_BACKGROUND);
        legendPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        AppTheme.CARD_BORDER,
                        BorderFactory.createEmptyBorder(
                                12, 10, 12, 10
                        )
                )
        );

        legendPanel.setPreferredSize(new Dimension(165, 100));

        JLabel legendTitle = new JLabel("✦ HERO ROLES");
        legendTitle.setFont(
                AppTheme.BODY_FONT.deriveFont(Font.BOLD, 14f)
        );
        legendTitle.setForeground(AppTheme.GOLD_LIGHT);

        legendPanel.add(legendTitle);
        legendPanel.add(Box.createVerticalStrut(18));

        for (CharacterType type : CharacterType.values()) {

            JLabel roleLabel = new JLabel("● " + type);
            roleLabel.setFont(AppTheme.BODY_FONT);
            roleLabel.setForeground(Color.WHITE);
            roleLabel.setOpaque(true);
            roleLabel.setBackground(AppTheme.colorFor(type));
            roleLabel.setBorder(
                    BorderFactory.createEmptyBorder(9, 8, 9, 8)
            );

            legendPanel.add(roleLabel);
            legendPanel.add(Box.createVerticalStrut(12));
        }

        legendPanel.add(Box.createVerticalGlue());

        mainPanel.add(legendPanel, BorderLayout.EAST);

        // =========================
        // FOOTER
        // =========================

        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(AppTheme.CARD_BACKGROUND);
        footerPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 14, 10, 14)
        );

        JLabel statusLabel = new JLabel(
                "✦ Character Manager is ready"
        );

        statusLabel.setFont(AppTheme.BODY_FONT);
        statusLabel.setForeground(AppTheme.TEXT_MUTED);

        JLabel versionLabel = new JLabel("TP14 • UNPRI");
        versionLabel.setFont(AppTheme.BODY_FONT);
        versionLabel.setForeground(AppTheme.GOLD);

        footerPanel.add(statusLabel, BorderLayout.WEST);
        footerPanel.add(versionLabel, BorderLayout.EAST);

        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);

        refreshCharacters();

        pack();

        setMinimumSize(new Dimension(1050, 650));
        setLocationRelativeTo(null);
    }

    // =========================
    // STATISTIC CARD
    // =========================

    private JLabel createStatCard(
            String title,
            String value,
            Color background
    ) {

        JLabel label = new JLabel(
                "<html><div style='text-align:center;'>"
                + "<span style='font-size:10px; color:#E5DDFB;'>"
                + title
                + "</span><br>"
                + "<span style='font-size:22px; font-weight:bold; color:white;'>"
                + value
                + "</span></div></html>",
                SwingConstants.CENTER
        );

        label.setOpaque(true);
        label.setBackground(background);
        label.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                background.brighter(), 1
                        ),
                        BorderFactory.createEmptyBorder(
                                12, 8, 12, 8
                        )
                )
        );

        return label;
    }

    // =========================
    // REFRESH LIST
    // =========================

    public void refreshList() {
        refreshCharacters();
    }

    public void refreshCharacters() {

        characterPanel.removeAll();

        List<Character> characters = manager.getAll();

        int totalLevel = 0;
        int highestLevel = 0;

        Set<CharacterType> roles = new HashSet<>();

        for (Character character : characters) {

            characterPanel.add(createCharacterCard(character));

            totalLevel += character.getLevel();

            highestLevel = Math.max(
                    highestLevel,
                    character.getLevel()
            );

            roles.add(character.getType());
        }

        updateStatCard(
                totalLabel, "TOTAL HEROES",
                String.valueOf(characters.size())
        );

        double average = characters.isEmpty()
                ? 0.0
                : (double) totalLevel / characters.size();

        updateStatCard(
                averageLabel, "AVERAGE LEVEL",
                String.format("%.1f", average)
        );

        updateStatCard(
                highestLabel, "HIGHEST LEVEL",
                String.valueOf(highestLevel)
        );

        updateStatCard(
                roleCountLabel, "ACTIVE ROLES",
                String.valueOf(roles.size())
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }

    // Memperbarui isi statistik
    private void updateStatCard(
            JLabel label,
            String title,
            String value
    ) {

        label.setText(
                "<html><div style='text-align:center;'>"
                + "<span style='font-size:10px; color:#E5DDFB;'>"
                + title
                + "</span><br>"
                + "<span style='font-size:22px; font-weight:bold; color:white;'>"
                + value
                + "</span></div></html>"
        );
    }

    // =========================
    // CHARACTER CARD
    // =========================

    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel(
                new GridLayout(0, 1, 5, 5)
        );

        Color roleColor = AppTheme.colorFor(character.getType());

        card.setBackground(roleColor);
        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                roleColor.brighter(), 2
                        ),
                        BorderFactory.createEmptyBorder(
                                14, 14, 14, 14
                        )
                )
        );

        JLabel nameLabel = new JLabel(
                "✦ " + character.getName()
        );

        nameLabel.setFont(AppTheme.NAME_FONT);
        nameLabel.setForeground(Color.WHITE);

        JLabel typeLabel = new JLabel(
                "ROLE: " + character.getType()
        );

        typeLabel.setFont(AppTheme.BODY_FONT);
        typeLabel.setForeground(new Color(235, 225, 255));

        JLabel levelLabel = new JLabel(
                "LEVEL: " + character.getLevel()
        );

        levelLabel.setFont(AppTheme.BODY_FONT);
        levelLabel.setForeground(AppTheme.GOLD_LIGHT);

        if (character.getLevel() >= GOLD_LEVEL_THRESHOLD) {
            levelLabel.setFont(AppTheme.GOLD_LEVEL_FONT);
        }

        JLabel hpLabel = new JLabel(
                "HP: " + character.getHitPoints()
        );

        hpLabel.setFont(AppTheme.BODY_FONT);
        hpLabel.setForeground(Color.WHITE);

        JLabel attackLabel = new JLabel(
                "ATTACK POWER: " + character.getAttackPower()
        );

        attackLabel.setFont(AppTheme.BODY_FONT);
        attackLabel.setForeground(Color.WHITE);

        card.add(nameLabel);
        card.add(typeLabel);
        card.add(levelLabel);
        card.add(hpLabel);
        card.add(attackLabel);

        card.setToolTipText(
                character.getName()
                + " - " + character.getType()
                + " - HP: " + character.getHitPoints()
                + " - Attack: " + character.getAttackPower()
        );

        return card;
    }
}
