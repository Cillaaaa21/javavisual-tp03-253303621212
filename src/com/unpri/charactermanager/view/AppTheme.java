
package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.CharacterType;

public class AppTheme {

    // =========================
    // BACKGROUND COLORS
    // =========================

    public static final Color BACKGROUND =
            new Color(23, 21, 47);

    public static final Color BG_MAIN = BACKGROUND;

    public static final Color CARD_BACKGROUND =
            new Color(39, 35, 70);

    public static final Color PANEL_BACKGROUND =
            new Color(51, 36, 93);

    public static final Color TEXT_COLOR =
            new Color(245, 242, 255);

    public static final Color TEXT_MAIN = TEXT_COLOR;

    public static final Color TEXT_MUTED =
            new Color(190, 184, 218);

    // =========================
    // ACCENT COLORS
    // =========================

    public static final Color GOLD =
            new Color(213, 169, 78);

    public static final Color GOLD_LIGHT =
            new Color(245, 210, 130);

    public static final Color ERROR =
            new Color(255, 105, 120);

    public static final Color SUCCESS =
            new Color(100, 220, 160);

    public static final Color BUTTON_BACKGROUND =
            new Color(213, 169, 78);

    public static final Color BUTTON_TEXT =
            new Color(35, 27, 53);

    // =========================
    // ROLE COLORS
    // =========================

    public static final Color WARRIOR_COLOR =
            new Color(141, 53, 72);

    public static final Color MAGE_COLOR =
            new Color(104, 69, 163);

    public static final Color ARCHER_COLOR =
            new Color(40, 120, 93);

    public static final Color HEALER_COLOR =
            new Color(40, 107, 155);

    // =========================
    // FONT SETTINGS
    // =========================

    public static final Font TITLE_FONT =
            new Font("SansSerif", Font.BOLD, 27);

    public static final Font NAME_FONT =
            new Font("SansSerif", Font.BOLD, 19);

    public static final Font BODY_FONT =
            new Font("SansSerif", Font.PLAIN, 13);

    public static final Font FONT_BODY = BODY_FONT;

    public static final Font GOLD_LEVEL_FONT =
            new Font("SansSerif", Font.BOLD, 14);

    public static final Font MONO_FONT =
            new Font("Monospaced", Font.PLAIN, 12);

    // =========================
    // BORDER SETTINGS
    // =========================

    public static final Border MAIN_PADDING_BORDER =
            BorderFactory.createEmptyBorder(18, 18, 18, 18);

    public static final Border CARD_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            new Color(92, 77, 133), 1
                    ),
                    BorderFactory.createEmptyBorder(
                            12, 14, 12, 14
                    )
            );

    // =========================
    // ROLE COLOR METHOD
    // =========================

    public static Color colorFor(CharacterType type) {

        if (type == null) {
            return CARD_BACKGROUND;
        }

        switch (type) {

            case WARRIOR:
                return WARRIOR_COLOR;

            case MAGE:
                return MAGE_COLOR;

            case ARCHER:
                return ARCHER_COLOR;

            case HEALER:
                return HEALER_COLOR;

            default:
                return CARD_BACKGROUND;
        }
    }

    // =========================
    // ROLE BORDER METHOD
    // =========================

    public static Border borderFor(CharacterType type) {

        Color roleColor = colorFor(type);

        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        roleColor.brighter(), 2
                ),
                BorderFactory.createEmptyBorder(
                        12, 12, 12, 12
                )
        );
    }

    // Constructor
    private AppTheme() {
        // Utility class
    }
}
