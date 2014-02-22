package net.technicpack.launcher.ui.components.news;

import net.technicpack.launcher.lang.ResourceLoader;
import net.technicpack.launcher.ui.LauncherFrame;
import net.technicpack.launcher.ui.controls.AAJLabel;
import net.technicpack.launcher.ui.controls.RectButton;
import net.technicpack.launcher.ui.controls.TiledBackground;
import sun.plugin.javascript.JSClassLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This file is part of The Technic Launcher Version 3.
 * Copyright (C) 2013 Syndicate, LLC
 *
 * The Technic Launcher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Technic Launcher  is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License,
 * as well as a copy of the GNU Lesser General Public License,
 * along with The Technic Launcher.  If not, see <http://www.gnu.org/licenses/>.
 */
public class NewsInfoPanel extends TiledBackground {
    private ResourceLoader resources;

    JTextArea newsText;
    JScrollPane newsScroller;
    public NewsInfoPanel(ResourceLoader resources) {
        super(resources.getImage("background_repeat2.png"));

        this.resources = resources;

        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20,20,18,16));

        JLabel title = new AAJLabel("SOMETHING UPDATED");
        title.setForeground(LauncherFrame.COLOR_BLUE);
        title.setFont(resources.getFont("Raleway-Light.ttf", 36));
        add(title, new GridBagConstraints(0,0,2,1,1.0,0.0,GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));

        JPanel authorshipInfo = new JPanel();
        authorshipInfo.setLayout(new FlowLayout(FlowLayout.LEADING));
        authorshipInfo.setBackground(LauncherFrame.COLOR_CHARCOAL);
        add(authorshipInfo, new GridBagConstraints(0,1,2,1,1.0,0.0,GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0,0,8,0),0,0));

        JLabel author = new AAJLabel("Skuli");
        author.setForeground(LauncherFrame.COLOR_BLUE);
        author.setFont(resources.getFont("Raleway-Light.ttf", 18, Font.BOLD));
        author.setIcon(resources.getIcon("news/authorHelm.png"));
        authorshipInfo.add(author);

        JLabel postedTime = new AAJLabel("/ Posted 3 Hours Ago");
        postedTime.setForeground(LauncherFrame.COLOR_WHITE_TEXT);
        postedTime.setFont(resources.getFont("Raleway-Light.ttf", 18));
        authorshipInfo.add(postedTime);

        newsText = new JTextArea();
        newsText.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        newsText.setBackground(LauncherFrame.COLOR_CHARCOAL);
        newsText.setForeground(LauncherFrame.COLOR_WHITE_TEXT);
        newsText.setFont(resources.getFont("OpenSans-Regular.ttf", 13.5f));
        newsText.setEditable(false);
        newsText.setHighlighter(null);
        newsText.setAlignmentX(LEFT_ALIGNMENT);
        newsText.setLineWrap(true);
        newsText.setWrapStyleWord(true);
        newsText.setText("Attack of the B-Team 1.0.8 is now marked Recommended in the launcher, and users will be asked to update the next time\n they attempt to launch B-Team. This is a minor version update over 1.0.7a, ");

        newsScroller = new JScrollPane(newsText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        newsScroller.setBorder(BorderFactory.createEmptyBorder());
        newsScroller.setMaximumSize(new Dimension(32000,900));

        JPanel newsTextPanel = new JPanel();
        newsTextPanel.setLayout(new BoxLayout(newsTextPanel, BoxLayout.PAGE_AXIS));
        newsTextPanel.setOpaque(false);
        newsTextPanel.add(newsScroller);
        newsTextPanel.add(Box.createVerticalGlue());

        add(newsTextPanel, new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 10, 0), 0, 0));

        add(Box.createGlue(), new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        RectButton discussButton = new RectButton("DISCUSS ON THE PLATFORM");
        discussButton.setPreferredSize(new Dimension(400, 40));
        discussButton.setMinimumSize(new Dimension(400, 40));
        discussButton.setFont(resources.getFont("Raleway-Light.ttf", 24));
        discussButton.setBorder(BorderFactory.createEmptyBorder());
        discussButton.setForeground(LauncherFrame.COLOR_WHITE_TEXT);
        discussButton.setBackground(LauncherFrame.COLOR_BLUE);
        discussButton.setHoverBackground(LauncherFrame.COLOR_BLUE_DARKER);
        discussButton.setAlignmentX(RIGHT_ALIGNMENT);
        add(discussButton, new GridBagConstraints(1,3,1,1,0.0,0.0,GridBagConstraints.SOUTHEAST, GridBagConstraints.BOTH, new Insets(0,0,0,0),0,0));
    }
}