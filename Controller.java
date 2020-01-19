import javax.swing.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class Controller {


    String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private Model model;
    private View view;
    private DataBase dataBase;
    public Controller(Model m, View v, DataBase d) {
        model = m;
        view = v;
        dataBase= d;
        v.gogoView();
    }

    public void initController() {
        view.getSingInItem().addActionListener(e -> view.frameAddSingIn());
        view.getNewPlaylistItem().addActionListener(e -> newPL() );
        view.getDatabaseItem().addActionListener(e -> printAllSongs());
        view.getRandTrecksItem().addActionListener(e ->  fiveSongs());
        view.getSelectionItem().addActionListener(e ->  selectonItem());
        view.getSingUpItem().addActionListener(e -> view.frameAddSingUp());


        view.getSubmitButton().addActionListener(e -> singIn());
        view.getResetButton().addActionListener(e -> view.clearForm());
        view.getResetButtonReg().addActionListener(e -> view.clearFromReg());
        view.getRegisterButton().addActionListener(e -> singUp());
        view.getRandButton().addActionListener(e ->  fiveSongs());
        view.getAddButyonNP().addActionListener(e -> addToPlayTable());
        view.getPodborButton().addActionListener(e -> view.showSelectionTable(model.combineSongs( dataBase.getMusicAfterSelection(dataBase.getIdSong(dataBase.getIdPlaylist(dataBase.getIdGroup(readSelectedJrs(view.getJr()))))),dataBase.getAnotherMusic(dataBase.getGenreGroup(readSelectedJrs(view.getJr()))),readSelectedJrs(view.getJr()))));
        view.getDeleteButyonNP().addActionListener(e -> deleneSongNP());
        view.getSavePlayButton().addActionListener(e ->  savePL());
         }

    public  Set<Object> readSelectedJrs(JCheckBox jr[]){
        Set<Object> groupSelected = new LinkedHashSet<>();
        for(int i =0;i<jr.length;i++){
        if(jr[i].isSelected()) {
            jr[i].getText();
            groupSelected.add( jr[i].getText());
        }
        }
        return groupSelected;
    }

    public void selectonItem(){
       view.selectoinShow(dataBase.getGroupsSet());
    }

    public void savePL(){
//        dataBase.sentToUserHasPlaylist(getLogin(),view.getNameNewPlaylistJTEXTF().getText());
        dataBase.addPLname(view.getNameNewPlaylistJTEXTF().getText());
        dataBase.addUserHasPL( dataBase.getUserId(getLogin()),dataBase.getPLid(view.getNameNewPlaylistJTEXTF().getText()));
        for(int i =0; i< view.getTableModelPlaylist().getRowCount();i++){
          dataBase.addPlaylistHasMusic(dataBase.getPLid(view.getNameNewPlaylistJTEXTF().getText()),   dataBase.getSongId(view.getTableModelPlaylist().getValueAt(i,0).toString()));
             }
    }

    public void newPL(){
        view.newPl(getLogin(), dataBase.getModelAllSongs());
    }
    public void addToPlayTable(){
        int idx =   view.getTableBD().getSelectedRow();
        int indx =  view.getTablePlaylist().getRowCount();
        System.out.println("view.getTableBD().getSelectedRow() = " + view.getTableBD().getSelectedRow() + ";  view.getTablePlaylist().getRowCount() = " +view.getTablePlaylist().getRowCount() + "; view.getTableBD().getValueAt(idx,1).toString(),indx,1 =  " + view.getTableBD().getValueAt(idx,1).toString());
        if(idx>-1){
                view.getTableModelPlaylist().insertRow(indx , new String[] {
                view.getTableBD().getValueAt(idx,0).toString(), view.getTableBD().getValueAt(idx,1).toString(), view.getTableBD().getValueAt(idx,2).toString()});
         }
    }

    public void deleneSongNP(){
        int indx = view.getTablePlaylist().getSelectedRow();
        if (indx>-1) {
            view.getTableModelPlaylist().removeRow(indx);
        }
    }
    public void singIn(){
        dataBase.checkuser( view.getLoginTextField().getText(), view.getPasswordField().getText());
        setLogin(view.getLoginTextField().getText());
    }

    public void singUp(){
        int y = model.checkFillFormReg(view.getLoginTextFieldReg(),view.getFirstNametextField(),view.getLastNametextField(), view.getEmailTextField(),view.getPasswordFieldReg(), view.getConfirmPasswordField());
        switch (y){
            case 1: view.showErrorInFill("Вы успешно зарегестрировалась");
                    dataBase.addUser(view.getLoginTextFieldReg().getText().toString(),view.getFirstNametextField().getText().toString(),view.getLastNametextField().getText().toString(), view.getEmailTextField().getText().toString(),view.getPasswordFieldReg().getText().toString());
                    setLogin(view.getLoginTextFieldReg().getText());
                    break;
            case 2: view.showErrorInFill("Заполните форму");
                    break;
            case 0: view.showErrorInFill("Пароли не совпадают");
                    break;
        }
    }


    public void printAllSongs(){
       view.allSongs(dataBase.getModelAllSongs());
    }

    public void fiveSongs(){
       view.fiveRand(dataBase.get5Rand());
    }


}
