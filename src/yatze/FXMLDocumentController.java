        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatze;

import java.util.Random;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Toomas
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    Label ones, twos, threes, fours, fives, sixes;
    @FXML
    Label totalNumbers, bonus, totalSum;
    @FXML
    Label kolmPaar, neliPaar, smallStraight, bigStraight, Yatzy, chance2, maja;
    @FXML
    CheckBox hoia1, hoia2, hoia3, hoia4, hoia5;
    @FXML
    Label veeretusteArv;
    @FXML
    ImageView dice1, dice2, dice3, dice4, dice5;
    @FXML
    Button onesButton, twosButton, threesButton, foursButton, fivesButton, sixesButton;
    @FXML
    Button onePairButton, twoPairButton, majaButton, smallStraightButton, bigStraightButton;
    @FXML
    Button yatzyButton, chanceButton, rollButton;

    Image[] dices = new Image[8];
    Image questionmark = new Image("/pildid/questionmark.png");

    int[] dice = {0, 0, 0, 0, 0};
    int veeretusi = 3;
    Random rand = new Random();
    int number = 0;
    int hetkeSumma = 0;
    int kogusumma = 0;
    int numbSumma = 0;
    int boonusSumma = 0;
    boolean yatzi = false;

    @FXML
    private void veereta(ActionEvent event) {
        System.out.println("veeretan");
        if (veeretusi != 0) {
            rollButton.setDisable(true);
            if (!hoia1.isSelected()) {
                dice[0] = rand.nextInt(6) + 1;
                dice1.setImage(dices[dice[0]]);
            }
            if (!hoia2.isSelected()) {
                dice[1] = rand.nextInt(6) + 1;
                dice2.setImage(dices[dice[1]]);
            }
            if (!hoia3.isSelected()) {
                dice[2] = rand.nextInt(6) + 1;
                dice3.setImage(dices[dice[2]]);
            }
            if (!hoia4.isSelected()) {
                dice[3] = rand.nextInt(6) + 1;
                dice4.setImage(dices[dice[3]]);
            }
            if (!hoia5.isSelected()) {
                dice[4] = rand.nextInt(6) + 1;
                dice5.setImage(dices[dice[4]]);
            }
            System.out.println(dice[0]);
            System.out.println(dice[1]);
            System.out.println(dice[2]);
            System.out.println(dice[3]);
            System.out.println(dice[4]);
            hoia1.setDisable(false);
            hoia2.setDisable(false);
            hoia3.setDisable(false);
            hoia4.setDisable(false);
            hoia5.setDisable(false);

            veeretusi = veeretusi - 1;
            veeretusteArv.setText(Integer.toString(veeretusi));
            rollButton.setDisable(false);
        }
        if (veeretusi == 0) {
            rollButton.setDisable(true);
        }
        hetkeSumma = dice[0] + dice[1] + dice[2] + dice[3] + dice[4];
    }

    @FXML
    private void ones(ActionEvent event) {
        onesButton.setDisable(true);
        String diceString = "";
        for (int i : dice) {
            diceString = diceString + Integer.toString(i);
        }
        int ones2 = StringUtils.countMatches(diceString, "1");
        hetkeSumma = 1 * ones2;
        kogusumma = kogusumma + hetkeSumma;
        numbSumma = numbSumma + hetkeSumma;
        ones.setText(Integer.toString(hetkeSumma));
        resetRolls();
    }

    @FXML
    private void twos(ActionEvent event) {
        twosButton.setDisable(true);
        String diceString = "";
        for (int i : dice) {
            diceString = diceString + Integer.toString(i);
        }
        int twos2 = StringUtils.countMatches(diceString, "2");
        hetkeSumma = 2 * twos2;
        kogusumma = kogusumma + hetkeSumma;
        numbSumma = numbSumma + hetkeSumma;
        twos.setText(Integer.toString(hetkeSumma));
        resetRolls();
    }

    @FXML
    private void threes(ActionEvent event) {
        threesButton.setDisable(true);
        String diceString = "";
        for (int i : dice) {
            diceString = diceString + Integer.toString(i);
        }
        int threes2 = StringUtils.countMatches(diceString, "3");
        hetkeSumma = 3 * threes2;
        kogusumma = kogusumma + hetkeSumma;
        numbSumma = numbSumma + hetkeSumma;
        threes.setText(Integer.toString(hetkeSumma));
        resetRolls();
    }

    @FXML
    private void fours(ActionEvent event) {
        foursButton.setDisable(true);
        String diceString = "";
        for (int i : dice) {
            diceString = diceString + Integer.toString(i);
        }
        int fours2 = StringUtils.countMatches(diceString, "4");
        hetkeSumma = 4 * fours2;
        kogusumma = kogusumma + hetkeSumma;
        numbSumma = numbSumma + hetkeSumma;
        fours.setText(Integer.toString(hetkeSumma));
        resetRolls();
    }

    @FXML
    private void fives(ActionEvent event) {
        fivesButton.setDisable(true);
        String diceString = "";
        for (int i : dice) {
            diceString = diceString + Integer.toString(i);
        }
        int fives2 = StringUtils.countMatches(diceString, "5");
        hetkeSumma = 5 * fives2;
        kogusumma = kogusumma + hetkeSumma;
        numbSumma = numbSumma + hetkeSumma;
        fives.setText(Integer.toString(hetkeSumma));
        resetRolls();
    }

    @FXML
    private void sixes(ActionEvent event) {
        String diceString = "";
        for (int i : dice) {
            diceString = diceString + Integer.toString(i);
        }
        int sixes2 = StringUtils.countMatches(diceString, "6");
        hetkeSumma = 6 * sixes2;
        kogusumma = kogusumma + hetkeSumma;
        numbSumma = numbSumma + hetkeSumma;
        sixes.setText(Integer.toString(hetkeSumma));
        sixesButton.setDisable(true);
        resetRolls();
    }

    @FXML
    private void onePair(ActionEvent event) {
        onePairButton.setDisable(true);
        String diceString = "";
        for (int i : dice) {
            diceString = diceString + Integer.toString(i);
        }
        int ones2 = StringUtils.countMatches(diceString, "1");
        int twos2 = StringUtils.countMatches(diceString, "2");
        int threes2 = StringUtils.countMatches(diceString, "3");
        int fours2 = StringUtils.countMatches(diceString, "4");
        int fives2 = StringUtils.countMatches(diceString, "5");
        int sixes2 = StringUtils.countMatches(diceString, "6");
        if (ones2 == 3 || twos2 == 3 || threes2 == 3 || fours2 == 3 || fives2 == 3 || sixes2 == 3) {
            kogusumma = kogusumma + hetkeSumma;
            kolmPaar.setText(Integer.toString(hetkeSumma));
        }
        resetRolls();
    }

    @FXML
    private void twoPair(ActionEvent event) {
        String diceString = "";
        twoPairButton.setDisable(true);
        for (int i : dice) {
            diceString = diceString + Integer.toString(i);
        }
        int ones2 = StringUtils.countMatches(diceString, "1");
        int twos2 = StringUtils.countMatches(diceString, "2");
        int threes2 = StringUtils.countMatches(diceString, "3");
        int fours2 = StringUtils.countMatches(diceString, "4");
        int fives2 = StringUtils.countMatches(diceString, "5");
        int sixes2 = StringUtils.countMatches(diceString, "6");
        if (ones2 == 4 || twos2 == 4 || threes2 == 4 || fours2 == 4 || fives2 == 4 || sixes2 == 4) {
            kogusumma = kogusumma + hetkeSumma;
            neliPaar.setText(Integer.toString(hetkeSumma));
        }
        resetRolls();
    }

    @FXML
    private void house(ActionEvent event) {
        majaButton.setDisable(true);
        if (majaKontroll() == true) {
            System.out.println("maja leitud!");
            maja.setText("25");
            hetkeSumma = 25;
        }
        kogusumma = kogusumma + hetkeSumma;
        resetRolls();
    }

    @FXML
    private void smallStraight(ActionEvent event) {
        smallStraightButton.setDisable(true);
        if (kontrolliVaikestSirget() == true) {
            smallStraight.setText("30");
            hetkeSumma = 30;
        }
        kogusumma = kogusumma + hetkeSumma;
        resetRolls();
    }

    @FXML
    private void bigStraight(ActionEvent event) {
        bigStraightButton.setDisable(true);
        if (kontrolliSuurtSirget() == true) {
            bigStraight.setText("50");
            hetkeSumma = 50;
        }
        kogusumma = kogusumma + hetkeSumma;
        resetRolls();
    }

    @FXML
    private void yatzy(ActionEvent event) {
        yatzyButton.setDisable(true);
        String diceString = "";
        for (int i : dice) {
            diceString = diceString + Integer.toString(i);
        }
        int ones2 = StringUtils.countMatches(diceString, "1");
        int twos2 = StringUtils.countMatches(diceString, "2");
        int threes2 = StringUtils.countMatches(diceString, "3");
        int fours2 = StringUtils.countMatches(diceString, "4");
        int fives2 = StringUtils.countMatches(diceString, "5");
        int sixes2 = StringUtils.countMatches(diceString, "6");
        if (ones2 == 5 || twos2 == 5 || threes2 == 5 || fours2 == 5 || fives2 == 5 || sixes2 == 5) {
            kogusumma = kogusumma + 50;
            Yatzy.setText(Integer.toString(50));
        }
        kogusumma = kogusumma + hetkeSumma;
        resetRolls();
    }

    @FXML
    private void chance(ActionEvent event) {
        chanceButton.setDisable(true);
        hetkeSumma = dice[0] + dice[1] + dice[2] + dice[3] + dice[4];
        chance2.setText(Integer.toString(hetkeSumma));
        kogusumma = kogusumma + hetkeSumma;
        resetRolls();
    }

    private void resetRolls() {
        totalSum.setText(Integer.toString(kogusumma));
        totalNumbers.setText(Integer.toString(numbSumma));
        if (numbSumma >= 63 && yatzi == false) {
            yatzi = true;
            bonus.setText(Integer.toString(50));
            kogusumma = kogusumma + 50;
        }
        rollButton.setDisable(false);
        hetkeSumma = 0;
        veeretusi = 3;
        veeretusteArv.setText(Integer.toString(veeretusi));
        hoia1.setSelected(false);
        hoia2.setSelected(false);
        hoia3.setSelected(false);
        hoia4.setSelected(false);
        hoia5.setSelected(false);
        hoia1.setDisable(true);
        hoia2.setDisable(true);
        hoia3.setDisable(true);
        hoia4.setDisable(true);
        hoia5.setDisable(true);
        dice1.setImage(questionmark);
        dice2.setImage(questionmark);
        dice3.setImage(questionmark);
        dice4.setImage(questionmark);
        dice5.setImage(questionmark);
    }

    private Boolean majaKontroll() {
        int[] i = new int[5];

        i[0] = dice[0];
        i[1] = dice[1];
        i[2] = dice[2];
        i[3] = dice[3];
        i[4] = dice[4];

        Arrays.sort(i);

        if ((((i[0] == i[1]) && (i[1] == i[2])) && // 3
                (i[3] == i[4]) && // 2
                (i[2] != i[3]))
                || ((i[0] == i[1]) && // 2
                ((i[2] == i[3]) && (i[3] == i[4])) && // 3
                (i[1] != i[2]))) {
            return true;
        } else {
            return false;
        }
    }

    private boolean kontrolliSuurtSirget() {
        int[] i = new int[5];

        i[0] = dice[0];
        i[1] = dice[1];
        i[2] = dice[2];
        i[3] = dice[3];
        i[4] = dice[4];
        Arrays.sort(i);

        if (((i[0] == 1)
                && (i[1] == 2)
                && (i[2] == 3)
                && (i[3] == 4)
                && (i[4] == 5))
                || ((i[0] == 2)
                && (i[1] == 3)
                && (i[2] == 4)
                && (i[3] == 5)
                && (i[4] == 6))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean kontrolliVaikestSirget() {
        int Sum = 0;

        int[] i = new int[5];

        i[0] = dice[0];
        i[1] = dice[1];
        i[2] = dice[2];
        i[3] = dice[3];
        i[4] = dice[4];

        Arrays.sort(i);

        for (int j = 0; j < 4; j++) {
            int y = 0;
            if (i[j] == i[j + 1]) {
                y = i[j];

                for (int k = j; k < 4; k++) {
                    i[k] = i[k + 1];
                }

                i[4] = y;
            }
        }

        if (((i[0] == 1) && (i[1] == 2) && (i[2] == 3) && (i[3] == 4))
                || ((i[0] == 2) && (i[1] == 3) && (i[2] == 4) && (i[3] == 5))
                || ((i[0] == 3) && (i[1] == 4) && (i[2] == 5) && (i[3] == 6))
                || ((i[1] == 1) && (i[2] == 2) && (i[3] == 3) && (i[4] == 4))
                || ((i[1] == 2) && (i[2] == 3) && (i[3] == 4) && (i[4] == 5))
                || ((i[1] == 3) && (i[2] == 4) && (i[3] == 5) && (i[4] == 6))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 1; i < 7; i++) {
            dices[i] = new Image("/pildid/die" + i + ".png");
        }
        hoia1.setDisable(true);
        hoia2.setDisable(true);
        hoia3.setDisable(true);
        hoia4.setDisable(true);
        hoia5.setDisable(true);
    }
}
