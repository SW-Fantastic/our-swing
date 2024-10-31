package org.swdc;

import org.swdc.swing.Alignment;
import org.swdc.swing.Direction;
import org.swdc.swing.SwingView;
import org.swdc.swing.comp.*;
import org.swdc.swing.containers.*;
import org.swdc.swing.XColor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Demo {

    public static class Controller {

        @SwingView("field")
        private JTextField field;

        @SwingView("pwd")
        private JPasswordField pwd;

        public void plusClicked(MouseEvent event) {
            System.err.println("uname : " + field.getText() + " - pwd : " + new String(pwd.getPassword()));
        }

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        Controller controller = new Controller();

        VBoxPane vBoxPane = new VBoxPane()
                .addFixedGap(80)
                .add(new HBoxPane()
                        .addFixedGap(60)
                        .add(new Label()
                                .text("UserName: ")
                                .horizontalAlignment(Alignment.CENTER)
                                .width(100)
                        ).add(new Field()
                                .text("uname")
                        ).addFixedGap(60)
                        .maxHeight(36)
                )
                .addFixedGap(20)
                .add(new HBoxPane()
                        .addFixedGap(60)
                        .add(new Label()
                                .text("Password:")
                                .horizontalAlignment(Alignment.CENTER)
                                .width(100)
                        ).add(new PasswordField()
                                .text("password")
                        ).addFixedGap(60)
                        .maxHeight(36)
                )
                .addFixedGap(40)
                .add(new HBoxPane().add(
                        new Button()
                                .text("LOGIN")
                                .maxWidth(400)
                                .maxHeight(42)
                ));

        BorderPane pane = new BorderPane()
                .top(new HBoxPane()
                        .add(new Field().text("Text").id("field").width(120))
                        .add(new PasswordField().text("password").id("pwd").width(80))
                        .add(new Button().text("Login")
                                .mouseClick("plusClicked")
                        ).addFixedGap(120)
                        .add(new Button().text("-"))
                        .add(new Button().text("*"))
                        .add(new Button().text("/"))
                        .add(new Button().text("1"))
                        .add(new ToggleButton().text("Toggle"))
                        .add(new CheckBox().text("opt A"))
                        .add(new CheckBox().text("opt B"))
                        .add(new RadioButton().text("Rad A"))
                )
                .bottom(new JButton("Bottom"))
                .left(new JButton("Left"))
                .right(new JButton("Right"))
                .backgroundColor(new XColor("#FFF"))
                .color(new XColor("#999"))
                .controller(controller);

        GridBagPane bagPane = new GridBagPane()
                .cell().x(0).y(0).fill(Direction.BOTH).scaleX(1)
                .add(new Pane())
                .cell().x(1).y(0).fill(Direction.BOTH).scaleX(1)
                .add(new Label().text("Username：").horizontalAlignment(Alignment.RIGHT))
                .cell().x(2).y(0).fill(Direction.BOTH).scaleX(4)
                .add(new Field().id("field").text("Text").width(120).height(32))
                .cell().x(3).y(0).fill(Direction.BOTH).scaleX(2)
                .add(new Pane())
                .cell().x(0).y(1).fill(Direction.BOTH).scaleX(1)
                .add(new Pane())
                .cell().x(1).y(1).fill(Direction.BOTH).scaleX(1)
                .add(new Label().text("Passowrd：").horizontalAlignment(Alignment.RIGHT))
                .cell().x(2).y(1).fill(Direction.BOTH).scaleX(4)
                .add(new PasswordField().id("pwd").text("password").width(120).height(32))
                .cell().x(3).y(1).fill(Direction.BOTH).scaleX(2)
                .add(new Pane())
                .cell().x(0).y(2).colSpan(4).align(Alignment.CENTER).insets(0,24)
                .add(new Button().text("Login").mouseClick("plusClicked").width(160).height(42))
                .controller(controller);

        JFrame frame = new JFrame();
        frame.setSize(800,600);
        frame.setContentPane(
                bagPane.getComponent()
        );
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
