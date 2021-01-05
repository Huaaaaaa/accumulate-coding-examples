package com.design.pattern.structrual.bridge;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/14
 * Todo: 包包出售方
 * Time 10:51
 */
public class BagSeller {

    public void produceBag(AbstractBag abstractBag) {
        String bag = abstractBag.getStyle();
        show(bag);
    }

    private void show(String name) {
        JFrame jf = new JFrame("桥接模式测试");
        Container contentPane = jf.getContentPane();
        JPanel p = new JPanel();
        JLabel l = new JLabel(new ImageIcon("src/bridge/" + name + ".jpg"));
        p.setLayout(new GridLayout(1, 1));
        p.setBorder(BorderFactory.createTitledBorder("女士皮包"));
        p.add(l);
        contentPane.add(p, BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
