package edu.wctc.dice.impl;

import edu.wctc.dice.iface.GameInput;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.swing.*;
@Component
@Primary
public class PopupInput implements GameInput {

    @Override
    public String getInput(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }
}
