import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class View {

    //main components
    JFrame frame = new JFrame("Main frame");
    JPanel panel = new JPanel();

    JMenuBar menuBar = new JMenuBar();
    JMenu playlistMenu = new JMenu("Плейлисты");
    JMenuItem newPlaylistItem =new JMenuItem("Создать плейлист");
    JMenuItem databaseItem  =new JMenuItem("База данных всех треков");

    JMenu generateMenu = new JMenu("Генератор");
    JMenuItem randTrecksItem =new JMenuItem("5 рандомных треков");
    JMenuItem selectionItem =new JMenuItem("Подбор треков по группам");

    JMenu acountMenu = new JMenu("Аккаунт");
    JMenuItem singInItem =new JMenuItem("Войти");
    JMenuItem singUpItem =new JMenuItem("Регистрация");


    //sing in
    JLabel singLabel=new JLabel("Вход");
    JLabel loginLabel=new JLabel("Логин");
    JLabel passwordLabel=new JLabel("Пароль");
    JTextField loginTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton submitButton=new JButton("Вход");
    JButton resetButton=new JButton("Сбросить");

    //SING UP
    JLabel regLabel=new JLabel("Регистрация");
    JLabel loginLabelReg=new JLabel("Логин");
    JLabel passwordLabelReg=new JLabel("Пароль");
    JLabel confirmPasswordLabel=new JLabel("Подтвердите пароль");
    JLabel emailLabel=new JLabel("Email");
    JTextField loginTextFieldReg=new JTextField(null);
    JPasswordField passwordFieldReg=new JPasswordField(null);
    JPasswordField confirmPasswordField=new JPasswordField(null);
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("Регистрация");
    JButton resetButtonReg=new JButton("Сбросить");
    JLabel firstNameLabel = new  JLabel("Имя");
    JLabel lastNameLabel = new  JLabel("Фамилия");
    JTextField firstNametextField=new JTextField(null);
    JTextField lastNametextField=new JTextField(null);


    //fonts
    Font fontWelcome = new Font("Verdana", Font.PLAIN, 50);
    Font font = new Font("Verdana", Font.PLAIN, 11);
    Font fontBold = new Font("Verdana", Font.BOLD, 11);
    Font fontBig = new Font("Verdana", Font.BOLD, 20);
    Color color=new Color(240,248,255);
    Color colorB = new Color(70,130,180);

    //5 rand songs
    JLabel randLabel = new JLabel("Для вас были отобраны 5 случайных треков");
    JButton randButton = new JButton("Cгенерировать");
    JTable tableRandom;
    JScrollPane jpRand;

    //Podbor
    JLabel podborLabel = new JLabel("Выберите любимые группы:");
    JButton podborButton = new JButton("Найти что-то новенькое ");
//    Set<Object> genreSet = new LinkedHashSet<>();
    JCheckBox[] jr = new JCheckBox[0];
    JTable tablePodbor;

    //playlists
    Object[] columnsHeader = new String[] {"Song", "Group", "Genre"};
    JButton deleteButyonNP = new JButton("Удалить");
    JButton addButyonNP = new JButton("Добавить");
    JTable tableBD;
    JTable tablePlaylist;
    DefaultTableModel tableModelPlaylist = new DefaultTableModel();
    JScrollPane jscrBD;
    JScrollPane jscrPlaylist;

    JButton savePlayButton =new JButton("Сохранить");
    JLabel newPlaylistLabel = new JLabel("Создание нового плейлиста");
    JLabel userNPlayLabel = new JLabel("Пользователь");
    JTextField userNPlayJTEXTF = new JTextField();

    public JTextField getNameNewPlaylistJTEXTF() {
        return nameNewPlaylistJTEXTF;
    }

    JLabel nameNewPlaylistLabel = new JLabel("Название плейлиста");
    JTextField nameNewPlaylistJTEXTF  = new JTextField("");

// ALL TR
    private JScrollPane scrollPaneAllSongs;
    private DefaultTableCellRenderer cellRenderer;
    JTable tableAllSongs = new JTable();
    JScrollPane jp;


    public void gogoView(){
        addComponentsToFrame();
        createWindow();
        setLocatons();
        setStyles();
    }


    public void setLocatons(){
        randLabel.setBounds(25,10,300,30);
        randButton.setBounds(80,50,150,35);
        podborLabel.setBounds(25,10,300,30);
        podborButton.setBounds(400,25,200,35);

        loginLabel.setBounds(20,50,40,70);
        passwordLabel.setBounds(20,100,100,70);
        singLabel.setBounds(150,5,200,50);
        loginTextField.setBounds(180,73,165,23);
        passwordField.setBounds(180,123,165,23);
        submitButton.setBounds(30,180,150,35);
        resetButton.setBounds(190,180,150,35);

        firstNameLabel.setBounds(20,50,40,70);
        lastNameLabel.setBounds(20,100,100,70);
        firstNametextField.setBounds(180,73,165,23);
        lastNametextField.setBounds(180,123,165,23);
        regLabel.setBounds(110,5,200,50);
        loginLabelReg.setBounds(20,150,140,70);
        passwordLabelReg.setBounds(20,200,100,70);
        confirmPasswordLabel.setBounds(20,250,140,70);
        emailLabel.setBounds(20,300,100,70);
        loginTextFieldReg.setBounds(180,173,165,23);
        passwordFieldReg.setBounds(180,223,165,23);
        confirmPasswordField.setBounds(180,273,165,23);
        emailTextField.setBounds(180,323,165,23);
        registerButton.setBounds(30,400,150,35);
        resetButtonReg.setBounds(190,400,150,35);

        newPlaylistLabel.setBounds(30,20,200,15);
        userNPlayLabel.setBounds(30,50,150,23);
        userNPlayJTEXTF.setBounds(200,50,150,23);
        nameNewPlaylistLabel.setBounds(30,85,150,23);
        nameNewPlaylistJTEXTF.setBounds(200,85,150,23);

        deleteButyonNP.setBounds(410,355,150,35);
        addButyonNP.setBounds(230,355,150,35);
        savePlayButton.setBounds(500,60,150,35);
    }

    public void setStyles(){
        randLabel.setFont(fontBold);
        playlistMenu.setFont(font);
        newPlaylistItem.setFont(font);
        generateMenu.setFont(font);
        randTrecksItem.setFont(font);
        selectionItem.setFont(font);
        acountMenu.setFont(font);
        singInItem.setFont(font);
        singUpItem.setFont(font);
        randTrecksItem.setFont(font);
        databaseItem.setFont(font);
        podborLabel.setFont(fontBold);
        podborButton.setFont(fontBold);
        singLabel.setForeground(colorB);
        singLabel.setFont(fontBig);
        loginLabel.setFont(font);
        passwordLabel.setFont(font);
        loginTextField.setFont(font);
        passwordField.setFont(font);
        submitButton.setFont(font);
        resetButton.setFont(font);

        regLabel.setForeground(colorB);
        regLabel.setFont(fontBig);
        loginLabelReg.setFont(font);
        passwordLabelReg.setFont(font);
        confirmPasswordLabel.setFont(font);
        emailLabel.setFont(font);
        loginTextFieldReg.setFont(font);
        passwordFieldReg.setFont(font);
        confirmPasswordField.setFont(font);
        emailTextField.setFont(font);
        registerButton.setFont(font);
        resetButtonReg.setFont(font);
        lastNameLabel.setFont(font);
        lastNametextField.setFont(font);
        firstNameLabel.setFont(font);
        firstNametextField.setFont(font);

        newPlaylistLabel.setFont(fontBold);
        userNPlayLabel.setFont(font);
        nameNewPlaylistLabel.setFont(font);
        deleteButyonNP.setFont(font);
        addButyonNP.setFont(font);
        savePlayButton.setFont(font);
    }

    public void addComponentsToFrame(){
        frame.add(panel);
        playlistMenu.add(newPlaylistItem);
        playlistMenu.add(databaseItem);
        generateMenu.add(randTrecksItem);
        generateMenu.add(selectionItem);
        acountMenu.add(singInItem);
        acountMenu.add(singUpItem);
        menuBar.add(playlistMenu);
        menuBar.add(generateMenu);
        menuBar.add(acountMenu);
        frame.setJMenuBar(menuBar);
    }

    public void createWindow(){
        frame.getContentPane().setLayout(null);
        frame.setPreferredSize(new Dimension(800, 700));
        frame.getContentPane().setBackground(color);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    // SING IN
    public void frameAddSingIn(){
        frame.getContentPane().removeAll();
        frame.add(singLabel);
        frame.add(loginLabel);
        frame.add(passwordLabel);
        frame.add(loginTextField);
        frame.add(passwordField);
        frame.add(resetButton);
        frame.add(submitButton);
        frame.repaint();
    }

    public void clearForm(){
        loginTextField.setText("");
        passwordField.setText("");
    }



    //SING UP
    public void frameAddSingUp(){
        frame.getContentPane().removeAll();
        frame.add(firstNameLabel);
        frame.add(firstNametextField);
        frame.add(lastNameLabel);
        frame.add(lastNametextField);
        frame.add(regLabel);
        frame.add(loginLabelReg);
        frame.add(passwordLabelReg);
        frame.add(confirmPasswordLabel);
        frame.add(emailLabel);
        frame.add(loginTextFieldReg);
        frame.add(passwordFieldReg);
        frame.add(confirmPasswordField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButtonReg);
        frame.repaint();
    }

    public void clearFromReg(){
        firstNametextField.setText(null);
        lastNametextField.setText(null);
        loginTextFieldReg.setText(null);
        passwordFieldReg.setText(null);
        confirmPasswordField.setText(null);
        emailTextField.setText(null);
    }

    //ALL SONGS
    public void allSongs(DefaultTableModel model){
        frame.getContentPane().removeAll();
        frame.setLayout(new FlowLayout());
        tableAllSongs = new JTable();
        tableAllSongs.setModel(model);
        jp = new JScrollPane(tableAllSongs);
        jp.setBounds(90,10,600,800);
        frame.getContentPane().add(jp);
        frame.getContentPane().repaint();
    }

// 5 rand trecks
    public void fiveRand(DefaultTableModel tableModeRandom){
        frame.getContentPane().removeAll();
        frame.setLayout(new FlowLayout());
        frame.add(randLabel);
        frame.add(randButton);
        tableRandom = new JTable();
        tableRandom.setModel(tableModeRandom);
        jpRand = new JScrollPane(tableRandom);
        jpRand.setBounds(90,100,600,120);
        frame.add(jpRand);
        frame.getContentPane().repaint();
    }


    public JTable getTablePlaylist() {
        return tablePlaylist;
    }

    public void setTablePlaylist(JTable tablePlaylist) {
        this.tablePlaylist = tablePlaylist;
    }

    public JTable getTableBD() {
        return tableBD;
    }

    public void setTableBD(JTable tableBD) {
        this.tableBD = tableBD;
    }

    public DefaultTableModel getTableModelPlaylist() {
        return tableModelPlaylist;
    }

    public void setTableModelPlaylist(DefaultTableModel tableModelPlaylist) {
        this.tableModelPlaylist = tableModelPlaylist;
    }

    public void newPl(String login, DefaultTableModel tableModelBD){
        frame.getContentPane().removeAll();
        frame.setLayout(new FlowLayout());
        userNPlayJTEXTF.setText(login);
        tableModelPlaylist.setColumnIdentifiers(columnsHeader);
        tableBD = new JTable();
        tablePlaylist =new JTable();
        tablePlaylist.setModel(tableModelPlaylist);
        tableBD.setModel(tableModelBD);

        jscrBD = new JScrollPane(tableBD);
        jscrBD.setBounds(90,140,600,200);
        jscrPlaylist = new JScrollPane(tablePlaylist);
        jscrPlaylist.setBounds(90,410,600,200);

        frame.add(jscrBD);
        frame.add(jscrPlaylist);
        frame.add(deleteButyonNP);
        frame.add(addButyonNP);
        frame.add(newPlaylistLabel);
        frame.add(userNPlayLabel);
        frame.add(userNPlayJTEXTF);
        frame.add(nameNewPlaylistLabel);
        frame.add(nameNewPlaylistJTEXTF);
        frame.add(savePlayButton);
    }


    public JCheckBox[] getJr() {
        return jr;
    }

    public void selectoinShow(Set<Object> groupSet){
        frame.getContentPane().removeAll();
        frame.add(podborLabel);
        frame.add(podborButton);

        Object[] groups = groupSet.toArray();
        jr = new JCheckBox[groups.length];
        for (int i = 0; i <groups.length; i++) {
            jr[i] = new JCheckBox(groups[i].toString());
//            jr[i].addActionListener(actionListener);

            jr[i].setBounds(50,50+i*20,150,20);

            jr[i].setBackground(color);
            frame.add(jr[i]);
        }

         frame.repaint();
    }

    public void showSelectionTable(DefaultTableModel songsModel){
        frame.setLayout(new FlowLayout());
        tablePodbor = new JTable();
        tablePodbor.setModel(songsModel);
        jp = new JScrollPane(tablePodbor);
        jp.setBounds(200,100,400,500);
        frame.getContentPane().add(jp);
        frame.getContentPane().repaint();
    }

    public void showErrorInFill(String message ){
        JOptionPane.showMessageDialog(null,message);
    }
    public JTextField getLoginTextFieldReg() {
        return loginTextFieldReg;
    }

    public JPasswordField getPasswordFieldReg() {
        return passwordFieldReg;
    }

    public JPasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JButton getResetButtonReg() {
        return resetButtonReg;
    }

    public JTextField getFirstNametextField() {
        return firstNametextField;
    }

    public JTextField getLastNametextField() {
        return lastNametextField;
    }

    public JTextField getLoginTextField() {
        return loginTextField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JButton getRandButton() {
        return randButton;
    }

    public JButton getPodborButton() {
        return podborButton;
    }

    public JButton getDeleteButyonNP() {
        return deleteButyonNP;
    }

    public JButton getAddButyonNP() {
        return addButyonNP;
    }

    public JButton getSavePlayButton() {
        return savePlayButton;
    }

    public JMenuItem getNewPlaylistItem() {
        return newPlaylistItem;
    }

    public JMenuItem getDatabaseItem() {
        return databaseItem;
    }

    public JMenuItem getRandTrecksItem() {
        return randTrecksItem;
    }

    public JMenuItem getSelectionItem() {
        return selectionItem;
    }

    public JMenuItem getSingInItem() {
        return singInItem;
    }

    public JMenuItem getSingUpItem() {
        return singUpItem;
    }


}





