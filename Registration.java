//*package com.mycompany.Registration;*/

import java.awt.*;
import java.awt.event.*;

public class Registration extends Frame implements ActionListener {
    TextField nameField, mobileField, dobField;
    TextArea addressArea, outputArea;
    Checkbox maleCheckbox, femaleCheckbox, acceptCheckbox;
    Button submitButton, resetButton;

    // Constructor to set up GUI components
   Registration() {
        setTitle("Registration Form");
        setSize(800, 500); // Widen frame to accommodate output on the right
        setLayout(null);

        // Registration Form Title
        Label formTitle = new Label("Registration Form", Label.CENTER);
        formTitle.setFont(new Font("Arial", Font.BOLD, 16));
        formTitle.setBounds(100, 30, 200, 30);
        add(formTitle);

        // Name
        Label nameLabel = new Label("Name:");
        nameLabel.setBounds(50, 80, 100, 30);
        add(nameLabel);

        nameField = new TextField();
        nameField.setBounds(150, 80, 200, 30);
        add(nameField);

        // Mobile
        Label mobileLabel = new Label("Mobile:");
        mobileLabel.setBounds(50, 130, 100, 30);
        add(mobileLabel);

        mobileField = new TextField();
        mobileField.setBounds(150, 130, 200, 30);
        add(mobileField);

        // Gender
        Label genderLabel = new Label("Gender:");
        genderLabel.setBounds(50, 180, 100, 30);
        add(genderLabel);

        maleCheckbox = new Checkbox("Male");
        maleCheckbox.setBounds(150, 180, 60, 30);
        add(maleCheckbox);

        femaleCheckbox = new Checkbox("Female");
        femaleCheckbox.setBounds(220, 180, 80, 30);
        add(femaleCheckbox);

        // DOB
        Label dobLabel = new Label("DOB:");
        dobLabel.setBounds(50, 230, 100, 30);
        add(dobLabel);

        dobField = new TextField();
        dobField.setBounds(150, 230, 200, 30);
        add(dobField);

        // Address
        Label addressLabel = new Label("Address:");
        addressLabel.setBounds(50, 280, 100, 30);
        add(addressLabel);

        addressArea = new TextArea();
        addressArea.setBounds(150, 280, 200, 60);
        add(addressArea);

        // Accept Terms and Conditions
        acceptCheckbox = new Checkbox("Accept Terms and Conditions");
        acceptCheckbox.setBounds(50, 360, 250, 30);
        add(acceptCheckbox);

        // Submit and Reset buttons
        submitButton = new Button("Submit");
        submitButton.setBounds(100, 400, 80, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        resetButton = new Button("Reset");
        resetButton.setBounds(200, 400, 80, 30);
        resetButton.addActionListener(this);
        add(resetButton);

        // Output Section
        Label outputLabel = new Label("Output:");
        outputLabel.setBounds(450, 50, 100, 30);
        outputLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(outputLabel);

        outputArea = new TextArea();
        outputArea.setBounds(450, 80, 300, 300);
        outputArea.setEditable(false);
        add(outputArea);

setVisible(true);
    }
    // Action performed when buttons are clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (acceptCheckbox.getState()) {
                // Display output in the outputArea
                outputArea.setText("Form Submitted Successfully\n\n");
                outputArea.append("Name: " + nameField.getText() + "\n");
                outputArea.append("Mobile: " + mobileField.getText() + "\n");
                outputArea.append("Gender: " + (maleCheckbox.getState() ? "Male" : femaleCheckbox.getState() ? "Female" : "Unspecified") + "\n");
                outputArea.append("DOB: " + dobField.getText() + "\n");
                outputArea.append("Address: " + addressArea.getText());
            } else {
                outputArea.setText("Please accept the Terms and Conditions.");
            }
        } else if (e.getSource() == resetButton) {
            // Clear all fields
            nameField.setText("");
            mobileField.setText("");
            dobField.setText("");
            addressArea.setText("");
            maleCheckbox.setState(false);
            femaleCheckbox.setState(false);
            acceptCheckbox.setState(false);
            outputArea.setText("");
        }
    }
    public static void main(String[] args) {
        new Registration();
    }
}