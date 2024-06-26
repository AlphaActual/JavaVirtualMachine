package hr.unipu.java.swing1.example4;

import hr.unipu.java.swing1.example4.UserData.EmailType;

import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class InputUserDataPanel extends JPanel {
  private String[] cityArray = { "Zagreb", "Osijek", "Rijeka", "Split",
      "Dubrovnik", "Zadar", "Šibenik", "Pula" };
  private JTextField tfFirstName;
  private JTextField tfLastName;
  private JCheckBox cbEmail;
  private JRadioButton rbWeekly;
  private JRadioButton rbDaily;
  private JRadioButton rbMonthly;
  private JTextField tfStreet;
  private JComboBox<String> comboCity;
  private JFormattedTextField tfPostalCode;
  private ButtonGroup emailGroup;

  public InputUserDataPanel() {

    setLayout(new SpringLayout());

    // row 0
    add(new JLabel("Ime:", SwingConstants.RIGHT));

    tfFirstName = new JTextField();
    tfFirstName.setColumns(10);
    add(tfFirstName);

    // row 1
    add(new JLabel("Prezime:", SwingConstants.RIGHT));

    tfLastName = new JTextField();
    tfLastName.setColumns(10);
    add(tfLastName);

    // row 2
    add(new JPanel());

    cbEmail = new JCheckBox("Želite li primati e-mailove?");
    add(cbEmail);

    // rox 3
    add(new JPanel());

    JPanel radioPanel = new JPanel();
    radioPanel
        .setBorder(BorderFactory.createTitledBorder(null,
            "Kako želite primati e-mailove?", TitledBorder.LEADING,
            TitledBorder.TOP));
    add(radioPanel);

    radioPanel.setLayout(new GridLayout(0, 1, 0, 0));
    emailGroup = new ButtonGroup();
    rbWeekly = new JRadioButton("Tjedno");
    radioPanel.add(rbWeekly);
    emailGroup.add(rbWeekly);
    rbDaily = new JRadioButton("Dnevno");
    radioPanel.add(rbDaily);
    emailGroup.add(rbDaily);
    rbMonthly = new JRadioButton("Mjesečno");
    radioPanel.add(rbMonthly);
    emailGroup.add(rbMonthly);

    // row 4
    add(new JLabel("Ulica i broj:", SwingConstants.RIGHT));

    tfStreet = new JTextField();
    tfStreet.setColumns(10);
    add(tfStreet);

    // row 5
    add(new JLabel("Grad:", SwingConstants.RIGHT));

    comboCity = new JComboBox<String>(cityArray);
    add(comboCity);

    // row 6
    add(new JLabel("Poštanski broj:", SwingConstants.RIGHT));

    tfPostalCode = new JFormattedTextField(new DecimalFormat("#####"));
    add(tfPostalCode);

    SpringUtilities.makeCompactGrid(this, 7, 2, 0, 0, 5, 5);
  }

  public UserData getUserData() {
    UserData data = new UserData();
    data.setFirstName(tfFirstName.getText());
    data.setLastName(tfLastName.getText());
    data.setReceiveEmails(cbEmail.isSelected());
    if (rbDaily.isSelected()) {
      data.setEmailType(EmailType.DAILY);
    } else if (rbMonthly.isSelected()) {
      data.setEmailType(EmailType.MONTHLY);
    } else {
      data.setEmailType(EmailType.WEEKLY);
    }
    data.setStreet(tfStreet.getText());
    if(tfPostalCode.getValue() == null) {
      data.setPostalCode(0);
    } else {
      data.setPostalCode(((Number) tfPostalCode.getValue()).intValue());
    }
    data.setCity((String) comboCity.getSelectedItem());
    return data;
  }

  public void setUserData(UserData userData) {
    tfFirstName.setText(userData.getFirstName());
    tfLastName.setText(userData.getLastName());
    cbEmail.setSelected(userData.isReceiveEmails());
    if (userData.getEmailType() != null) {
      switch (userData.getEmailType()) {
      case DAILY:
        rbDaily.setSelected(true);
        break;
      case WEEKLY:
        rbWeekly.setSelected(true);
        break;
      case MONTHLY:
        rbMonthly.setSelected(true);
        break;
      default:
        throw new RuntimeException(
            "UserData.EmailType is not recognized: type="
                + userData.getEmailType());
      }
    } else {
      emailGroup.clearSelection();
    }

    tfStreet.setText(userData.getStreet());
    tfPostalCode.setValue(userData.getPostalCode());
    comboCity.setSelectedItem(userData.getCity());
  }

}
