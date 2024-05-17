package edu.wctc.dice.impl;

import edu.wctc.dice.iface.GameOutput;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.swing.*;
@Component
@Primary
public class PopupOutput implements GameOutput {

    @Override
    public void output(String text) {
        JOptionPane.showMessageDialog(null, text);
    }
}
